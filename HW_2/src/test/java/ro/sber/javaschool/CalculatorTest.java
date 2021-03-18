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
        double exp = 12d;
        Assert.assertTrue(exp==calculator.summation());
    }

    @Test
    public void subtraction() {
        Calculator calculator=new Calculator();
        calculator.setA(8d);
        calculator.setB(3d);
        double exp = 5d;
        Assert.assertTrue(exp==calculator.subtraction());
    }

    @Test
    public void multiplying() {
        Calculator calculator=new Calculator();
        calculator.setA(8d);
        calculator.setB(4d);
        double exp = 32d;
        Assert.assertTrue(exp==calculator.multiplying());
    }

    @Test
    public void dividing() {
        Calculator calculator=new Calculator();
        calculator.setA(8d);
        calculator.setB(4d);
        double exp = 2d;
        Assert.assertTrue(exp==calculator.dividing());
    }

    @Test
    public void square() {
        Calculator calculator=new Calculator();
        calculator.setA(3969d);
        double exp = 63d;

        Assert.assertTrue(exp==calculator.square());
    }

    @Test
    public void max() {
        Calculator calculator=new Calculator();
        calculator.setA(5d);
        calculator.setB(3d);
        Assert.assertTrue(calculator.getA()==calculator.max());
    }

    @Test
    public void min() {
        Calculator calculator=new Calculator();
        calculator.setA(5d);
        calculator.setB(3d);

        Assert.assertTrue(calculator.getB()==calculator.min());
    }
}