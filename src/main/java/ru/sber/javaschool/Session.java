package ru.sber.javaschool;

import lombok.Data;
import lombok.experimental.Accessors;
import ru.sber.javaschool.customer.Card;
import ru.sber.javaschool.customer.Customer;
import ru.sber.javaschool.processing.models.Balance;
import ru.sber.javaschool.processing.operations.Authorization;
import ru.sber.javaschool.processing.operations.Operation;
import ru.sber.javaschool.processing.operations.OperationAuthorization;
import ru.sber.javaschool.processing.operations.OperationBalance;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Accessors(chain = true)
public class Session {
    public enum Status{NO_AUTHORIZATION,OPEN,CLOSE}

    private long cardNumber;
    private Date startTime;
    private Date endTime;
    private List<Operation> operations = new ArrayList<>();
    private Status sessionStatus = Status.NO_AUTHORIZATION;

    public Session (long cardNumber, String pin){
        this.cardNumber = cardNumber;
        this.startTime = new Date();
        start(pin);
    }

    private void start(String pin){
        OperationAuthorization operationAuthorization = new OperationAuthorization(this.cardNumber,pin);
        operations.add(operationAuthorization);
        if(operationAuthorization.isAuthorization()){
            this.sessionStatus = Status.OPEN;
        }
    }
    public Balance getBalance(String pin) throws IllegalAccessException {
        OperationBalance operationBalance = new OperationBalance(this.cardNumber, pin);
        operations.add(operationBalance);
        return operationBalance.execute();
    }
    public void closeSession(){
        this.sessionStatus = Status.CLOSE;
        this.endTime = new Date();
    }
}
