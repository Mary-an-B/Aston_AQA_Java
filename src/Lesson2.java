import java.util.Arrays;

public class Lesson2 {
    public static void main(String[] args) {
        //printThreeWords();
        //checkSumSign();
        //printColor();
        //compareNumbers();
        //System.out.println(checkSumRange(-7, 25));
        //checkNumIsPositive(15);
        //System.out.println(checkNumberIsNegative(-56));
        //printString("Hello", 3);
        //System.out.println(isLeap(2024));
        //invertArray();
        //fillArray();
        //changeArray();
        //fillDiagonalArray();
        System.out.println(Arrays.toString(createArray(4, 7)));

    }

//1. Создайте метод printThreeWords(), который при вызове должен отпечатать в столбец три слова: Orange, Banana, Apple
    static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

//2. Создайте метод checkSumSign(), в теле которого объявите две int переменные a и b, и инициализируйте их любыми значениями, которыми захотите. Далее метод должен просуммировать эти переменные, и если их сумма больше или равна 0, то вывести в консоль сообщение “Сумма положительная”, в противном случае - “Сумма отрицательная”;
    static void checkSumSign() {
        int a = 5;
        int b = -15;
        int sum = a + b;
        System.out.println((sum >= 0) ? "Сумма положительная" : "Сумма отрицательная");
    }

// 3. Создайте метод printColor() в теле которого задайте int переменную value и инициализируйте ее любым значением. Если value меньше 0 (0 включительно), то в консоль метод должен вывести сообщение “Красный”, если лежит в пределах от 0 (0 исключительно) до 100 (100 включительно), то “Желтый”, если больше 100 (100 исключительно) - “Зеленый”
    static void printColor() {
        int value = 120;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

//4. Создайте метод compareNumbers(), в теле которого объявите две int переменные a и b, и инициализируйте их любыми значениями, которыми захотите. Если a больше или равно b, то необходимо вывести в консоль сообщение “a >= b”, в противном случае “a < b”
    static void compareNumbers() {
        int a = 18;
        int b = 32;
        System.out.println((a >= b) ? "a >= b" : "a < b");
    }

//5. Напишите метод, принимающий на вход два целых числа и проверяющий, что их сумма лежит в пределах от 10 до 20 (включительно), если да – вернуть true, в противном случае – false.
    static boolean checkSumRange(int num_1, int num_2) {
        int sum = num_1 + num_2;
        boolean check = sum >= 10 && sum <= 20;
        return check;
    }

//6. Напишите метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль, положительное ли число передали или отрицательное. Замечание: ноль считаем положительным числом.
    static void checkNumIsPositive(int number) {
        System.out.println(number >= 0 ? "positive" : "negative");
    }

//7. Напишите метод, которому в качестве параметра передается целое число. Метод должен вернуть true, если число отрицательное, и вернуть false если положительное. Замечание: ноль считаем положительным числом.
    static boolean checkNumberIsNegative(int numb) {
        return numb < 0;
    }

//8. Напишите метод, которому в качестве аргументов передается строка и число, метод должен отпечатать в консоль указанную строку, указанное количество раз;
    static void printString(String str, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(str);
        }
    }

//9. Напишите метод, который определяет, является ли год високосным, и возвращает boolean (високосный - true, не високосный - false). Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
    static boolean isLeap(int year) {
        return year%4 == 0 && year%100 != 0 || year%400 == 0;
    }

//10. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
    static void invertArray() {
        int[] binaryArr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

        for (int i = 0; i < binaryArr.length; i++) {
            binaryArr[i] = (binaryArr[i] == 0) ? 1 : 0;
            System.out.print(binaryArr[i] + " ");
        }
    }

//11. Задать пустой целочисленный массив длиной 100. С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 ... 100;
    static void fillArray() {
        int[] arr = new int [100];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
            System.out.print(arr[i] + " ");
        }
    }

//12. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
    static void changeArray() {
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i]  *= 2;
            }
            System.out.print(array[i]  + " ");
        }
    }

//13. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами (можно только одну из диагоналей, если обе сложно). Определить элементы одной из диагоналей можно по следующему принципу: индексы таких элементов равны, то есть [0][0], [1][1], [2][2], ..., [n][n];
    static void fillDiagonalArray() {
        int[][] array = new int[4][4];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (i == j || j == array.length-1-i)
                    array[i][j] = 1;
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

//14. Написать метод, принимающий на вход два аргумента: len и initialValue, и возвращающий одномерный массив типа int длиной len, каждая ячейка которого равна initialValue.
    static  int[] createArray(int len, int initialValue) {
        int[] arr = new int[len];

        for (int i = 0; i < len; i++) {
            arr[i] = initialValue;
        }
        return arr;
    }
}
