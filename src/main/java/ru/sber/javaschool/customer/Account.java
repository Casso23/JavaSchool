package ru.sber.javaschool.customer;

import ru.sber.javaschool.processing.models.Balance;
import ru.sber.javaschool.processing.models.CreditBalance;
import ru.sber.javaschool.processing.models.DebitBalance;
import ru.sber.javaschool.processing.models.GetSetBalance;

import java.util.HashMap;
import java.util.List;

public class Account{
    private String accountNumber;
    private Balance balance;
    private HashMap<String,Card> cards;

    public Account(){
        cards=new HashMap<>();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void putCard(Card card){
        cards.put(card.getNumber(),card);
    }

    public boolean checkCard(String cardNumber) {
        return  cards.containsKey(cardNumber);
    }

    public Card getCard(String cardNumber){
        return cards.get(cardNumber);
    }

    public Balance getBalance() {
        return balance;
    }

    public <T extends Balance & GetSetBalance> void setBalance(T balance) {
        this.balance = balance;
    }
}