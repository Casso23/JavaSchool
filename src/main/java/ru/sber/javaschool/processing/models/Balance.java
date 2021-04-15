package ru.sber.javaschool.processing.models;

import lombok.Data;
import lombok.experimental.Accessors;
import ru.sber.javaschool.processing.StatusOperation;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Balance {
    protected BigDecimal balance;
    private Currency currency;
    private StatusOperation statusOperation;

    public Balance(Currency currency, StatusOperation statusOperation){
        this.currency= currency;
        this.statusOperation=statusOperation;
    }

    public StatusOperation getStatusOperation() {
        return statusOperation;
    }

    public String toString(){
        DecimalFormat decimalFormat = new DecimalFormat();
        decimalFormat.setMinimumFractionDigits(0);
        decimalFormat.setMaximumFractionDigits(2);

        return  decimalFormat.format(balance)+" "+currency;
    }
}
