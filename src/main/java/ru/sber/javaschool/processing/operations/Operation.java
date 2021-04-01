package ru.sber.javaschool.processing.operations;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
public class Operation implements Authorization {
    private Date operationTime;
    private Status status;

    public Operation(long cardNumber, String pin){
        this.operationTime = new Date();
        this.status = authorization(cardNumber,pin);
    }

    @Override
    public Status authorization(long cardNum, String pin) {
        return Status.OK;
    }

    @Override
    public int getAttemptsCount() {
        return 1;
    }
}
