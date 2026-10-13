import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MainTest {

    @ParameterizedTest
    @CsvSource({
            "6, 720",
            "0, 1",
            "20, 2432902008176640000"
    })
    public void testFactorial(int number, long expected) {
        long actual = Main.factorial(number);
        assertEquals(expected, actual);
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

    @ParameterizedTest
    @CsvSource({
            "0, -2, 0",
            "1, 2, 4",
            "2, 2, 4"
    })
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
        assertEquals(expected, actual, 0.0001);
    }

    @ParameterizedTest
    @CsvSource({
            "0, 0, ADDITION, 0",
            "8, -2, ADDITION, 6",
            "-8, -2, ADDITION, -10",
            "8, 2, ADDITION, 10",
            "1, 1, SUBTRACTION, 0",
            "-8, -2, SUBTRACTION, -6",
            "8, 2, SUBTRACTION, 6",
            "-8, 2, MULTIPLICATION, -16",
            "8, 0, MULTIPLICATION, 0",
            "-8, -2, MULTIPLICATION, 16",
            "8, 2, MULTIPLICATION, 16",
            "8, 2, DIVISION, 4",
            "5, 2, DIVISION, 2.5",
            "-8, 2, DIVISION, -4",
            "-8, -2, DIVISION, 4",
    })
    public void testCalculate(int number1, int number2, Main.ArithmeticOperation operation, double expected) {
        double actual = Main.calculate(number1, number2, operation);
        assertEquals(expected, actual, 0.0001);
    }

    @Test
    public void testCalculateDivByZero() {
        int a = 8;
        int b = 0;

        assertThrows(ArithmeticException.class, () -> {
            Main.calculate(a, b, Main.ArithmeticOperation.DIVISION);
        });
    }

    @ParameterizedTest
    @CsvSource({
            "-8, -2, -1",
            "0, 0, 0",
            "8, 2, 1",
            "2, 8, -1"
    })
    public void testCompareNumbers(int a, int b, int expected) {
        int actual = Main.compareNumbers(a, b);
        assertEquals(expected, actual);
    }
}
