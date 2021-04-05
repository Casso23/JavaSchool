package ru.sber.javaschool.processing.operations;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class Operation implements Authorization {
    private LocalDateTime operationTime;
    private StatusAuthorization status;

    public Operation(long cardNumber, String pin){
        operationTime = LocalDateTime.now();
        status = authorization(cardNumber,pin);
    }

    @Override
    public StatusAuthorization authorization(long cardNum, String pin) {
        return StatusAuthorization.SUCCESS;
    }

    @Override
    public int getAttemptsCount() {
        return 1;
    }
}
