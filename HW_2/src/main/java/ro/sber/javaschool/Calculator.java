package ro.sber.javaschool;


import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Calculator {
    private double a;
    private double b;

    public double summation(){
        return a+b;
    }
    public double subtraction(){
        return a-b;
    }
    public double multiplying(){
        return a*b;
    }
    public double dividing(){
        if(b==0d){
            System.out.println("Ошибка: деление на 0");
        }
        return a/b;
    }
    public double square(){
        return Math.sqrt(a);
    }
    public double max(){
        return Math.max(a,b);
    }
    public double min(){
        return Math.min(a,b);
    }

}
