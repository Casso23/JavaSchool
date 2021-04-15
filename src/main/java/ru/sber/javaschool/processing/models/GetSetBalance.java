package ru.sber.javaschool.processing.models;

import java.math.BigDecimal;

public interface GetSetBalance {
    BigDecimal getBalance() throws SignumBalanceException;

    void setBalance(BigDecimal bigDecimal) throws SignumBalanceException;
}
