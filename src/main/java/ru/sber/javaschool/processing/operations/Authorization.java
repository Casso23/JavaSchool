package ru.sber.javaschool.processing.operations;

public interface Authorization {
    enum Status {CARD_BLOCKED, INCORRECT_PIN, OK}
    Status authorization (long cardNum, String pin) ;
    int getAttemptsCount();
}
