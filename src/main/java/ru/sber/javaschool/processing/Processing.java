package ru.sber.javaschool.processing;

import ru.sber.javaschool.customer.Account;
import ru.sber.javaschool.customer.Card;
import ru.sber.javaschool.customer.Customer;
import ru.sber.javaschool.processing.models.Balance;
import ru.sber.javaschool.processing.models.CreditBalance;
import ru.sber.javaschool.processing.models.Currency;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Processing {
    private List<Customer> customers;
    private StatusOperation statusOperation;
    private Customer currentCustomer;
    private Account currentAccount;

    public Processing(){
        statusOperation = StatusOperation.UNAUTHORIZED;
        generateTestData();
    }

    public StatusOperation authorization(String cardNumber, String pin){
        if(!formatCheck(cardNumber, pin)){
            return statusOperation;
        }
        if(!searchCustomer(cardNumber, pin)){
            return statusOperation;
        }
        if(!searchAccount(cardNumber, pin)){
            return statusOperation;
        }
        if(!checkPinAndCardStatus(cardNumber, pin)){
            return statusOperation;
        }

        statusOperation = StatusOperation.SUCCESS;
        return statusOperation;
    }

    public Balance getBalance(String cardNumber, String pin){
        Balance balance;
        if(authorization(cardNumber, pin)== StatusOperation.SUCCESS) {
            balance = currentAccount.getBalance();
        }else {
            balance = new Balance(Currency.RUB, statusOperation);
        }
        return  balance;
    }

    private boolean formatCheck(String cardNumber, String pin){
        Pattern pattern = Pattern.compile("\\d{16}");
        Matcher matcher = pattern.matcher(cardNumber);
        if(!matcher.matches()){
            statusOperation = StatusOperation.INVALID_FORMAT_OF_CARD_NUMBER;
            return false;
        }

        pattern = Pattern.compile("\\d{3}");
        matcher = pattern.matcher(pin);
        if(!matcher.matches()){
            statusOperation = StatusOperation.INVALID_FORMAT_OF_PIN;
            return false;
        }

        return true;
    }

    private boolean searchCustomer(String cardNumber, String pin){
        List<Customer> foundCustomers = customers.stream().filter((p)->p.checkCard(cardNumber)).collect(Collectors.toList());
        if(foundCustomers.size()>1){
            statusOperation = StatusOperation.CUSTOMER_FOUND_SEVERAL;
            return false;
        }
        if(foundCustomers.size()==0){
            statusOperation = StatusOperation.CUSTOMER_NOT_FOUND;
            return false;
        }

        currentCustomer = foundCustomers.get(0);
        return true;
    }

    private boolean searchAccount(String cardNumber, String pin){
        List<Account> accounts = currentCustomer.getAccountsByCard(cardNumber);
        if(accounts.size()<1){
            statusOperation = StatusOperation.ACCOUNT_NOT_FOUND;
            return false;
        }
        if(accounts.size()>1){
            statusOperation = StatusOperation.ACCOUNT_FOUND_SEVERAL;
            return false;
        }
        currentAccount = accounts.get(0);
        return true;
    }

    private boolean checkPinAndCardStatus(String cardNumber, String pin){
        Card card = currentAccount.getCard(cardNumber);
        if(!card.checkPin(pin)){
            statusOperation = StatusOperation.INCORRECT_PIN;
            return false;
        }
        if(!card.checkExpiry()){
            statusOperation = StatusOperation.CARD_EXPIRED;
            return false;
        }
        if(!card.checkStatus()){
            statusOperation = StatusOperation.CARD_BLOCKED;
            return false;
        }

        return true;
    }

    public StatusOperation getStatusOperation() {
        return statusOperation;
    }

    private void generateTestData(){
        customers = new ArrayList<>();

        Card card1 = new Card("1111222233334444",LocalDate.of(2020, 2,22),"123",true);
        Card card2 = new Card("2222333344445555",LocalDate.of(2023, 2,22),"123",true);
        Card card3 = new Card("3333444455556666",LocalDate.of(2023, 2,22),"123",false);

        CreditBalance balance = new CreditBalance(Currency.RUB, StatusOperation.SUCCESS);
        balance.setBalance(new BigDecimal("2345.23"));


        Account account = new Account();
        account.setAccountNumber("12345123451234512345");
        account.setBalance(balance);
        account.putCard(card1);
        account.putCard(card2);
        account.putCard(card3);

        Customer customer = new Customer();
        customer.setName("Иван Иванович И.");
        customer.putAccount(account);

        customers.add(customer);
    }
}
