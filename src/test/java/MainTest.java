import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

public class MainTest {

    @DataProvider(name = "factorialData")
    public Object[][] provideFactorialData() {
        return new Object[][]{
                {6, 720},
                {0, 1},
                {20, 2432902008176640000L}
        };
    }

    @Test(dataProvider = "factorialData")
    public void testFactorial(int number, long expected) {
        long actual = Main.factorial(number);
        assertEquals(actual, expected);
    }

    @Test
    public void testFactorialByNegative() {
        int number = -1;

        assertThrows(IllegalArgumentException.class, () -> {
            Main.factorial(number);
        });
    }

    @Test
    public void testFactorialTooBig() {
        int number = 21;

        assertThrows(IllegalArgumentException.class, () -> {
            Main.factorial(number);
        });
    }

    @DataProvider(name = "triangleExceptionData")
    public Object[][] provideTriangleExceptionData() {
        return new Object[][]{
                {0, 2, 2},
                {-1, 2, 2},
                {1, 2, 4},
                {2, 2, 4}
        };
    }

    @Test(dataProvider = "triangleExceptionData")
    public void testAreaTriangleException(double a, double b, double c) {
        assertThrows(IllegalArgumentException.class, () -> {
            Main.areaTriangle(a, b, c);
        });
    }

    @Test
    public void testAreaTriangleValid() {
        double a = 5;
        double b = 4;
        double c = 3;

        double actual = Main.areaTriangle(a, b, c);
        double expected = 6;
        assertEquals(actual, expected, 0.0001);
    }

    @DataProvider(name = "calculateData")
    public Object[][] provideCalculateData() {
        return new Object[][]{
                {0, 0, Main.ArithmeticOperation.ADDITION, 0},
                {8, -2, Main.ArithmeticOperation.ADDITION, 6},
                {-8, -2, Main.ArithmeticOperation.ADDITION, -10},
                {8, 2, Main.ArithmeticOperation.ADDITION, 10},
                {1, 1, Main.ArithmeticOperation.SUBTRACTION, 0},
                {-8, -2, Main.ArithmeticOperation.SUBTRACTION, -6},
                {8, 2, Main.ArithmeticOperation.SUBTRACTION, 6},
                {-8, 2, Main.ArithmeticOperation.MULTIPLICATION, -16},
                {8, 0, Main.ArithmeticOperation.MULTIPLICATION, 0},
                {-8, -2, Main.ArithmeticOperation.MULTIPLICATION, 16},
                {8, 2, Main.ArithmeticOperation.MULTIPLICATION, 16},
                {8, 2, Main.ArithmeticOperation.DIVISION, 4},
                {5, 2, Main.ArithmeticOperation.DIVISION, 2.5},
                {-8, 2, Main.ArithmeticOperation.DIVISION, -4},
                {-8, -2, Main.ArithmeticOperation.DIVISION, 4},
        };
    }

    @Test(dataProvider = "calculateData")
    public void testCalculate(int number1, int number2, Main.ArithmeticOperation operation, double expected) {
        double actual = Main.calculate(number1, number2, operation);
        assertEquals(actual, expected, 0.0001);
    }

    @Test
    public void testCalculateDivByZero() {
        int a = 8;
        int b = 0;

        assertThrows(ArithmeticException.class, () -> {
            Main.calculate(a, b, Main.ArithmeticOperation.DIVISION);
        });
    }


    @DataProvider(name = "compareNumbersData")
    public Object[][] provideCompareNumbersData() {
        return new Object[][]{
                {-8, -2, -1},
                {0, 0, 0},
                {8, 2, 1},
                {2, 8, -1}
        };
    }

    @Test(dataProvider = "compareNumbersData")
    public void testCompareNumbers(int a, int b, int expected) {
        int actual = Main.compareNumbers(a, b);
        assertEquals(actual, expected);
    }
}