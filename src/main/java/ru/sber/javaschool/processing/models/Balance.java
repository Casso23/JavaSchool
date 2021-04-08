package ru.sber.javaschool.processing.models;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Balance {
    public enum Currency {USD,EUR, RUB}
    private Double balance;
    private Currency currency;
}
