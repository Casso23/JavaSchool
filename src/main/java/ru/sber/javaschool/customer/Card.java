package ru.sber.javaschool.customer;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors
public class Card {
    private long account;
    private long number;
    private long customerId;
    private boolean status;
}
