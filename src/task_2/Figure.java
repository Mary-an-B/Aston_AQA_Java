package task_2;

public interface Figure {

    double calculatePerimeter();

    double calculateArea();

    String getFillColor();

    String getBorderColor();

    String getFigureName();

    default void showInfo() {
        System.out.printf("%s: периметр = %.2f, площадь = %.2f, цвет фона - %s, цвет границ - %s.%n",
                getFigureName(), calculatePerimeter(), calculateArea(), getFillColor(), getBorderColor());
    }
}
