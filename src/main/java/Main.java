public class Main {
    static void main(String[] args) {

        try {
            long result = factorial(21);
            System.out.println(result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(calculate(5, -9, ArithmeticOperation.ADDITION));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }


    }

    public static long factorial(int number) {
        if (number < 0)
            throw new IllegalArgumentException("Число не должно быть отрицательным");

        if (number > 20)
            throw new IllegalArgumentException("Слишком большое число");

        if (number == 0)
            return 1;

        long result = 1;

        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        return result;
    }

    public static double areaTriangle(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0)
            throw new IllegalArgumentException("Число должно быть положительным");

        if (a >= b + c || b >= a + c || c >= a + b)
            throw new IllegalArgumentException("Такой треугольник не существует");

        double p = (a + b + c) / 2;
        double area = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        return area;
    }

    public static int compareNumbers(int a, int b) {
        return Integer.compare(a, b);
    }

    enum ArithmeticOperation {
        ADDITION,
        SUBTRACTION,
        MULTIPLICATION,
        DIVISION
    }

    public static double calculate(int number1, int number2, ArithmeticOperation operation) {
        switch (operation) {
            case ADDITION:
                return number1 + number2;
            case SUBTRACTION:
                return number1 - number2;
            case MULTIPLICATION:
                return number1 * number2;
            case DIVISION:
                if (number2 == 0)
                    throw new ArithmeticException("На ноль делить нельзя");
                return (double) number1 / number2;
            default:
                throw new IllegalArgumentException("Неизвестная операция");
        }
    }
}
