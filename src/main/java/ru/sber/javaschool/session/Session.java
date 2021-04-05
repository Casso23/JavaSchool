package ru.sber.javaschool.session;

import lombok.Data;
import lombok.experimental.Accessors;
import ru.sber.javaschool.processing.models.Balance;
import ru.sber.javaschool.processing.operations.Operation;
import ru.sber.javaschool.processing.operations.AuthorizationOperation;
import ru.sber.javaschool.processing.operations.BalanceOperation;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Accessors(chain = true)
public class Session {

    private long cardNumber;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private List<Operation> operations = new ArrayList<>();
    private Status sessionStatus = Status.UNAUTHORIZED;

    public Session (long cardNumber, String pin){
        this.cardNumber = cardNumber;
        startTime = LocalDateTime.now();
        start(pin);
    }

    private void start(String pin){
        AuthorizationOperation authorizationOperation = new AuthorizationOperation(this.cardNumber,pin);
        operations.add(authorizationOperation);
        if(authorizationOperation.isAuthorization()){
            sessionStatus = Status.OPENED;
        }
    }
    public Balance getBalance(String pin) throws IllegalAccessException {
        BalanceOperation balanceOperation = new BalanceOperation(this.cardNumber, pin);
        operations.add(balanceOperation);
        return balanceOperation.execute();
    }
    public void closeSession(){
        sessionStatus = Status.CLOSED;
        endTime = LocalDateTime.now();
    }
}
