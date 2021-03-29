package ru.sber.javaschool.processing.operations;

public class OperationAuthorization extends Operation{
    public OperationAuthorization(long cardNumber, String pin) {
        super(cardNumber, pin);
    }

    public boolean isAuthorization(){
        return this.getStatus().equals(Status.OK);
    }
}
