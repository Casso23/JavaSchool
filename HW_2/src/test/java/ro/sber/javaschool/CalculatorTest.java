package ro.sber.javaschool;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {
    @Test
    public void summation() {
        Calculator calculator=new Calculator();
        calculator.setA(8d);
        calculator.setB(4d);
        Double exp = 12d;
        Assert.assertEquals(exp,calculator.summation());
    }

    @Test
    public void subtraction() {
        Calculator calculator=new Calculator();
        calculator.setA(8d);
        calculator.setB(3d);
        Double exp = 5d;
        Assert.assertEquals(exp,calculator.subtraction());
    }

    @Test
    public void multiplying() {
        Calculator calculator=new Calculator();
        calculator.setA(8d);
        calculator.setB(4d);
        Double exp = 32d;
        Assert.assertEquals(exp,calculator.multiplying());
    }

    @Test
    public void dividing() {
        Calculator calculator=new Calculator();
        calculator.setA(8d);
        calculator.setB(4d);
        Double exp = 2d;
        Assert.assertEquals(exp,calculator.dividing());
    }

    @Test
    public void square() {
        Calculator calculator=new Calculator();
        calculator.setA(3969d);
        Double exp = 63d;

        Assert.assertEquals(exp,calculator.square());
    }

    @Test
    public void max() {
        Calculator calculator=new Calculator();
        calculator.setA(5d);
        calculator.setB(3d);

        Assert.assertEquals(calculator.getA(),calculator.max());
    }

    @Test
    public void min() {
        Calculator calculator=new Calculator();
        calculator.setA(5d);
        calculator.setB(3d);

        Assert.assertEquals(calculator.getB(),calculator.min());
    }
}