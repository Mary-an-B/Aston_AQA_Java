package task_2;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(3, "красный", "желтый");
        circle.showInfo();

        Rectangle rectangle = new Rectangle(7, 4, "голубой", "фиолетовый");
        rectangle.showInfo();

        Triangle triangle = new Triangle(5, 8, 12, "розовый", "зеленый");
        triangle.showInfo();
    }
}
