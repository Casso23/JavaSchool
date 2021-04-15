package ru.sber.javaschool.processing.models;

import ru.sber.javaschool.processing.StatusOperation;

import java.math.BigDecimal;

public class CreditBalance extends Balance implements GetSetBalance {
    public CreditBalance(Currency currency, StatusOperation statusOperation) {
        super(currency, statusOperation);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public BigDecimal getBalance(){
        return balance;
    }

    public void setBalance(BigDecimal bigDecimal) {
        balance = bigDecimal;
    }
}
