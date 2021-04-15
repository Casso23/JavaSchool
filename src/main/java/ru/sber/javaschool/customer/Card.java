package ru.sber.javaschool.customer;

import lombok.Data;
import lombok.experimental.Accessors;
import ru.sber.javaschool.processing.StatusOperation;

import java.time.LocalDate;

@Data
@Accessors
public class Card {
    private String number;
    private LocalDate expireDate;
    private String pin;
    private boolean status;

    public Card(String number, LocalDate expireDate, String pin, boolean status) {
        this.number = number;
        this.expireDate =expireDate;
        this.pin =pin;
        this.status = status;
    }

    public String getNumber(){
        return number;
    }

    public boolean checkPin(String pin) {
        return this.pin.equals(pin);
    }

    public boolean checkExpiry() {
        return this.expireDate.isAfter(LocalDate.now());
    }

    public boolean checkStatus() {
        return status;
    }
}
