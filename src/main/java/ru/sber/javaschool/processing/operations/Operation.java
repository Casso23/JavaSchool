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
    public Status authorization(Long cardNum, String pin) {
        if(pin.equals("1234")){
            if(cardNum.equals(4444000000001111L)){
                return Status.CARD_BLOCKED;
            }else {
                return Status.OK;
            }
        }else {
            return Status.INCORRECT_PIN;
        }
    }

    @Override
    public int getAttemptsCount() {
        return 1;
    }
}
