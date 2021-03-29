package ru.sber.javaschool.processing.operations;

import ru.sber.javaschool.processing.models.Balance;

public class OperationBalance extends Operation{
    public OperationBalance(long cardNumber, String pin) {
        super(cardNumber, pin);
    }

    public ru.sber.javaschool.processing.models.Balance execute() throws IllegalAccessException {
        if(this.getStatus().equals(Status.OK)) {
            ru.sber.javaschool.processing.models.Balance balance = new ru.sber.javaschool.processing.models.Balance();
            balance.setBalance(9000.77D);
            balance.setCurrency(Balance.Currency.RUB);
            return balance;
        }else {
            throw new IllegalAccessException();
        }
    }
}
