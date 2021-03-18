package ro.sber.javaschool;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application {
    static Map<Integer,String> operations = new HashMap <>();
    static Calculator calculator = new Calculator();
    public static void main(String[] args) {
        setOperations();

        Integer operation = selectOperation();
        if(operation.equals(-1)){
            return;
        }
        Double result = 0d;
        System.out.println(operations.get(operation));
        switch (operation){
            case 0:
                calculator.setA(getNumber("a",true));
                calculator.setB(getNumber("b",true));
                result = calculator.summation();
                break;
            case 1:
                calculator.setA(getNumber("a",true));
                calculator.setB(getNumber("b",true));
                result = calculator.subtraction();
                break;
            case 2:
                calculator.setA(getNumber("a",true));
                calculator.setB(getNumber("b",true));
                result = calculator.multiplying();
                break;
            case 3:
                calculator.setA(getNumber("a",true));
                calculator.setB(getNumber("b",false));
                result = calculator.dividing();
                break;
            case 4:
                calculator.setA(getNumber("a",true));
                result = calculator.square();
                break;
            case 5:
                calculator.setA(getNumber("a",true));
                calculator.setB(getNumber("b",true));
                result = calculator.max();
                break;
            case 6:
                calculator.setA(getNumber("a",true));
                calculator.setB(getNumber("b",true));
                result = calculator.min();
                break;
        }
        System.out.println("Результат: "+result);
    }
    private static void setOperations(){
        operations.put(0, "Сложение");
        operations.put(1, "Вычитание");
        operations.put(2, "Умножение");
        operations.put(3, "Деление");
        operations.put(4, "Корень квадратный");
        operations.put(5, "Максимальное значение");
        operations.put(6, "Минимальное значение");
    }
    public static Integer selectOperation(){
        while (true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите номер операции (Для выхода введите exit):");
            for (int i=0; i<operations.size();i++){
                System.out.println(i+ " - "+operations.get(i));
            }
            if(scanner.hasNextInt()){
                int number = scanner.nextInt();
                if(number>=0 && number<operations.size()) {
                    return number;
                }
            }
            else {
                String value = scanner.next();
                if(value.equalsIgnoreCase("exit")){
                    return -1;
                }
            }
            System.out.println("Ошибка: введено некорректное значение.");
        }
    }
    public static Double getNumber(String name, Boolean possibleZero){
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите число "+name+":");
            if (scanner.hasNextDouble()) {
                double number = scanner.nextDouble();
                if(!possibleZero && number == 0){
                    System.out.println("Ошибка ввода, значение должно отличаться от 0");
                }else {
                    return number;
                }
            } else {
                System.out.println("Ошибка ввода, введено не число");
            }
        }
    }

}
