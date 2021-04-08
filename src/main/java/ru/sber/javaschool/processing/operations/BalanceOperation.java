package ru.sber.javaschool.processing.operations;

public class BalanceOperation extends Operation{
    public BalanceOperation(long cardNumber, String pin) {
        super(cardNumber, pin);
    }

    public ru.sber.javaschool.processing.models.Balance execute() throws IllegalAccessException {
        if(getStatus()== StatusAuthorization.SUCCESS) {
            return new ru.sber.javaschool.processing.models.Balance();
        }else {
            throw new IllegalAccessException();
        }
    }
}
