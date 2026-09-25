import java.time.LocalDate;
import java.time.LocalTime;

public class Lesson3 {
    public static void main(String[] args) {

        Product[] productsArray = new Product[5];

        productsArray[0] = new Product(
                "Ноутбук",
                LocalDate.of(2025, 3, 15),
                "Lenovo",
                "Китай",
                163000,
                false);
        productsArray[1] = new Product(
                "Смартфон",
                LocalDate.of(2026, 3, 1),
                "Samsung",
                "Корея",
                115000,
                true);
        productsArray[2] = new Product(
                "Планшет",
                LocalDate.of(2024, 6, 20),
                "Huawei",
                "Китай",
                79900,
                true);
        productsArray[3] = new Product(
                "Умные часы",
                LocalDate.of(2025, 11, 10),
                "Garmin",
                "Тайвань",
                45890,
                true);
        productsArray[4] = new Product(
                "Беспроводные наушники",
                LocalDate.of(2026, 1, 15),
                "Sony",
                "Малайзия",
                27500,
                false);

        productsArray[3].showInfo();


        Park parkCentral = new Park();
        Park.Attraction rollerCoaster = parkCentral.new Attraction("Американские горки", LocalTime.of(10, 30), LocalTime.of(21, 0), 800);

        rollerCoaster.showInfo();

    }
}