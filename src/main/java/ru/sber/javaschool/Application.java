package ru.sber.javaschool;

import ru.sber.javaschool.processing.models.Balance;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        System.out.println("Введите карту:");
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLong()){
            long cardNumber = scanner.nextLong();
            System.out.println("Введите ПИН КОД:");
            String pin = scanner.next();

            Session session = new Session(cardNumber, pin);
            if(session.getSessionStatus().equals(Session.Status.OPEN)){
                System.out.println("Введите номер операции:\r\n1 - Узнать баланс");
                if(scanner.hasNextInt()) {
                    Integer operationNumber = scanner.nextInt();
                    if(operationNumber.equals(1)){
                        try {
                            System.out.println("Введите ПИН КОД:");
                            pin = scanner.next();
                            Balance balance = session.getBalance(pin);
                            System.out.println(balance.toString());
                        }catch (IllegalAccessException ex){
                            System.out.println("Отказ авторизации");
                        }
                    } else{
                        System.out.println("Введена недопустимая операция");
                    }
                }else {
                    System.out.println("Введена недопустимая операция");
                }
                session.closeSession();
            } else {
                System.out.println("Отказ авторизации");
            }
        }else {
            System.out.println("Ошибка обработки карты");
        }
    }
}
