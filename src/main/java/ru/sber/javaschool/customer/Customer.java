package ru.sber.javaschool.customer;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<Account> getAccountsByCard(String cardNumber){
        return accounts.stream().filter((p)->p.checkCard(cardNumber)).collect(Collectors.toList());
    }

    public void setName(String name) {
        this.name = name;
    }
}
