import java.time.LocalTime;

public class Park {
//3. Создать класс Park с внутренним классом, с помощью объектов которого можно хранить информацию об аттракционах, времени их работы и стоимости.

    public class Attraction {

        private String name;
        private LocalTime openingTime;
        private LocalTime closingTime;
        private double price;

        public Attraction(String name, LocalTime openingTime, LocalTime closingTime, double price) {
            this.name = name;
            this.openingTime = openingTime;
            this.closingTime = closingTime;
            this.price = price;
        }

        public void showInfo() {
            System.out.println("Аттракцион: " + name);
            System.out.println("Время работы: с " + openingTime + " до " + closingTime);
            System.out.println("Стоимость: " + price + " руб.");
        }
    }

}
