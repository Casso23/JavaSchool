package ru.sber.javaschool.processing.operations;

public class AuthorizationOperation extends Operation{
    public AuthorizationOperation(long cardNumber, String pin) {
        super(cardNumber, pin);
    }

    public boolean isAuthorization(){
        return getStatus()== StatusAuthorization.SUCCESS;
    }
}
