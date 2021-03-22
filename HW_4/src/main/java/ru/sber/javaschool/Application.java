package ru.sber.javaschool;

import java.io.IOException;
import java.time.LocalDateTime;

public class Application {
    public static void main(String[] args) {
        FileHandler fileHandler=new FileHandler();
        try {
            System.out.println(LocalDateTime.now());
            fileHandler.startOfProcessing("d1.csv", '1');
            System.out.println(LocalDateTime.now());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
