package ru.sber.javaschool.processing.models;


import ru.sber.javaschool.processing.StatusOperation;

import java.math.BigDecimal;

public class DebitBalance extends Balance implements GetSetBalance {

    public DebitBalance(Currency currency, StatusOperation statusOperation) {
        super(currency, statusOperation);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public BigDecimal getBalance() throws SignumBalanceException {
        if(balance.signum()<0){
            throw new SignumBalanceException();
        }
        else {
            return balance;
        }
    }

    public void setBalance(BigDecimal bigDecimal) throws SignumBalanceException {
        if(bigDecimal.signum()<0){
            throw new SignumBalanceException();
        }
        else {
            balance = bigDecimal;
        }
    }


}
