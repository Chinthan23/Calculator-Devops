import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import calculator.Calculator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    static Calculator calculator;
    private static final double DELTA = 1e-15;
    @BeforeAll
    static void setup(){
        System.out.println("Initialising Calculator Class");
        calculator = new Calculator();
    }

    @Test
    public void squareRootTruePositive()
    {
        assertEquals(2, calculator.mySqrt(4), DELTA, "Square Root Test 1");
        assertEquals( 3, calculator.mySqrt(9), DELTA, "Square Root Test 2");
        assertEquals(9, calculator.mySqrt(81), DELTA,"Square Root Test 3");
        assertEquals(1.4142135623730951, calculator.mySqrt(2), DELTA, "Square Root Test 4");
    }

    @Test
    public void squareRootFalsePositive()
    {
        assertNotEquals( 1, calculator.mySqrt(4), DELTA,"Square Root Test 1");
        assertNotEquals(2, calculator.mySqrt(9), DELTA, "Square Root Test 2");
        assertNotEquals(2, calculator.mySqrt(15), DELTA,"Square Root Test 3");
        assertNotEquals(2, calculator.mySqrt(20), DELTA,"Square Root Test 4");
    }

    @Test
    public void factorialTruePositive()
    {
        assertEquals( 1, calculator.myFactorial(0), DELTA,"Factorial Test 1");
        assertEquals( 1, calculator.myFactorial(1), DELTA,"Factorial Test 2");
        assertEquals( 2, calculator.myFactorial(2), DELTA,"Factorial Test 3");
        assertEquals( 6, calculator.myFactorial(3), DELTA,"Factorial Test 4");
    }

    @Test
    public void factorialFalsePositive()
    {
        assertNotEquals( 0, calculator.myFactorial(0), DELTA,"Factorial Test 1");
        assertNotEquals( 0, calculator.myFactorial(1), DELTA,"Factorial Test 2");
        assertNotEquals( 1, calculator.myFactorial(2), DELTA,"Factorial Test 3");
        assertNotEquals( 3, calculator.myFactorial(3), DELTA,"Factorial Test 4");
    }

    @Test
    public void logTruePositive()
    {
        assertEquals(2.302585092994046, calculator.myLog(10), DELTA,"Log Test 1");
        assertEquals(4.605170185988092, calculator.myLog(100), DELTA,"Log Test 2");
        assertEquals( 0, calculator.myLog(1), DELTA,"Log Test 3");
    }

    @Test
    public void logFalsePositive()
    {
        assertNotEquals( 2, calculator.myLog(10), DELTA,"Log Test 1");
        assertNotEquals( 4, calculator.myLog(100), DELTA,"Log Test 2");
        assertNotEquals( 1, calculator.myLog(1), DELTA,"Log Test 3");
    }

    @Test
    public void powerTruePositive()
    {
        assertEquals( 4, calculator.myPow(2, 2), DELTA,"Power Test 1");
        assertEquals( 125, calculator.myPow(5, 3), DELTA,"Power Test 2");
        assertEquals( 3, calculator.myPow(3, 1), DELTA,"Power Test 3");
        assertEquals( 1, calculator.myPow(10, 0), DELTA,"Power Test 4");
    }

    @Test
    public void powerFalsePositive()
    {
        assertNotEquals( 10, calculator.myPow(2, 2), DELTA,"Power Test 1");
        assertNotEquals( 5, calculator.myPow(5, 3), DELTA,"Power Test 2");
        assertNotEquals( 0, calculator.myPow(3, 1), DELTA,"Power Test 3");
        assertNotEquals( 10, calculator.myPow(10, 0), DELTA,"Power Test 4");
    }
}