package ro.sber.javaschool;


import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Calculator {
    private Double a;
    private Double b;

    public Double summation(){
        return a+b;
    }
    public Double subtraction(){
        return a-b;
    }
    public Double multiplying(){
        return a*b;
    }
    public Double dividing(){
        if(b.equals(0d)){
            System.out.println("Ошибка: деление на 0");
        }
        return a/b;
    }
    public Double square(){
        return Math.sqrt(a);
    }
    public Double max(){
        return Math.max(a,b);
    }
    public Double min(){
        return Math.min(a,b);
    }

}
