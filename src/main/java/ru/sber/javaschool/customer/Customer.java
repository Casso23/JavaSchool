package ru.sber.javaschool.customer;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Customer {
    private long id;
    private String firstName;
    private String lastName;
    private String surname;
}
