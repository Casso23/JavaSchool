package ru.sber.javaschool.customer;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

@Data
@Accessors(chain = true)
public class Customer {
    private long id;
    private String name;
    private List<Account> accounts;

    public Customer(){
        accounts = new ArrayList<>();
    }

    public void putAccount(Account account) {
        accounts.add(account);
    }


    public boolean checkCard(String cardNumber) {
        return accounts.stream().anyMatch((p)->p.checkCard(cardNumber));
    }
}
