public class Main {
    public static void main(String[] args) {
        String[][] array1 = {
                {"4", "5", "6"},
                {"3", "7", "15", "8"}
        };
        String[][] array2 = {
                {"4", "s", "6", "9"},
                {"3", "7", "15", "8"},
                {"4", "3", "6", "9"},
                {"3", "0", "10", "8"}
        };
        String[][] array3 = {
                {"2", "4", "6", "8"},
                {"1", "3", "5", "7"},
                {"2", "4", "6", "8"},
                {"1", "3", "5", "7"}
        };

        try {
            System.out.println(array1[1][5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(sumArray(array1));
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(sumArray(array2));
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(sumArray(array3));
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }

    static int sumArray(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        if (arr.length != 4) {
            throw new MyArraySizeException("Массив должен быть размером 4х4!");
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4) throw new MyArraySizeException("Массив должен быть размером 4х4!");
        }
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    int result = Integer.parseInt(arr[i][j]);
                    sum += result;
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Неверные данные: " + arr[i][j] + " в строке " + (i + 1) + " в столбце " + (j + 1));
                }
            }
        }
        return sum;
    }
}
