package ru.sber.javaschool.processing.operations;

import ru.sber.javaschool.processing.models.Balance;

public class OperationBalance extends Operation{
    public OperationBalance(long cardNumber, String pin) {
        super(cardNumber, pin);
    }

    public ru.sber.javaschool.processing.models.Balance execute() throws IllegalAccessException {
        if(this.getStatus().equals(Status.OK)) {
            return new ru.sber.javaschool.processing.models.Balance();
        }else {
            throw new IllegalAccessException();
        }
    }
}
