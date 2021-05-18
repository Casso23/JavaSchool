package ru.sber.javaschool.session;

import lombok.Data;
import lombok.experimental.Accessors;
import ru.sber.javaschool.processing.Processing;
import ru.sber.javaschool.processing.StatusOperation;
import ru.sber.javaschool.processing.models.Balance;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class Session {

    private String cardNumber;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Status sessionStatus = Status.UNAUTHORIZED;
    private Processing processing;

    public Session (String cardNumber, String pin){
        this.cardNumber = cardNumber;
        startTime = LocalDateTime.now();
        start(pin);
    }

    private void start(String pin){
        processing = new Processing();
        processing.authorization(cardNumber,pin);
        if(processing.getStatusOperation()== StatusOperation.SUCCESS){
            sessionStatus = Status.OPENED;
        }
    }
    public Balance getBalance(String pin) {
        return processing.getBalance(cardNumber,pin);
    }
    public void closeSession(){
        sessionStatus = Status.CLOSED;
        endTime = LocalDateTime.now();
    }
}
