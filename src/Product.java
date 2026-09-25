import java.time.LocalDate;

public class Product {

    private String name;
    private LocalDate manufactureDate;
    private String manufacturer;
    private String countryOfOrigin;
    private double price;
    private boolean isReserved;

    public Product(String name, LocalDate manufactureDate, String manufacturer, String countryOfOrigin, double price, boolean isReserved) {
        this.name = name;
        this.manufactureDate = manufactureDate;
        this.manufacturer = manufacturer;
        this.countryOfOrigin = countryOfOrigin;
        this.price = price;
        this.isReserved = isReserved;
    }

    public void showInfo() {
        System.out.println("Наименование: " + name);
        System.out.println("Дата производства: " + manufactureDate);
        System.out.println("Производитель: " + manufacturer);
        System.out.println("Страна происхождения: " + countryOfOrigin);
        System.out.println("Цена: " + price + " руб.");
        System.out.println("Забронирован: " + (isReserved ? "Да" : "Нет"));
    }


}
