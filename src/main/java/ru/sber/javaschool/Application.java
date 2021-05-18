package ru.sber.javaschool;

import ru.sber.javaschool.processing.StatusOperation;
import ru.sber.javaschool.processing.models.Balance;
import ru.sber.javaschool.session.Session;
import ru.sber.javaschool.session.Status;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        System.out.println("PIN-123\r\n1111222233334444 - expired\r\n2222333344445555 - activ\r\n3333444455556666 - blocked");


        System.out.println("Введите карту:");
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()){
            String cardNumber = scanner.next();
            System.out.println("Введите ПИН КОД:");
            String pin = scanner.next();

            Session session = new Session(cardNumber, pin);
            if(session.getSessionStatus()== Status.OPENED){
                System.out.println("Введите номер операции:\r\n1 - Узнать баланс");
                if(scanner.hasNextInt()) {
                    Integer operationNumber = scanner.nextInt();
                    if(operationNumber.equals(1)){
                        System.out.println("Введите ПИН КОД:");
                        pin = scanner.next();
                        Balance balance = session.getBalance(pin);
                        if(balance.getStatusOperation()== StatusOperation.SUCCESS){
                            System.out.println(balance.toString());
                        }else {
                            System.out.println("Отказ авторизации " + balance.getStatusOperation());
                        }

                    } else{
                        System.out.println("Введена недопустимая операция");
                    }
                }else {
                    System.out.println("Введена недопустимая операция");
                }
                session.closeSession();
            } else {
                System.out.println("Отказ авторизации "+session.getProcessing().getStatusOperation());
            }
        }else {
            System.out.println("Ошибка обработки карты");
        }
    }
}
