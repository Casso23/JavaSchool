package ru.sber.javaschool.processing.operations;

public interface Authorization {
    StatusAuthorization authorization (long cardNum, String pin) ;
    int getAttemptsCount();
}
