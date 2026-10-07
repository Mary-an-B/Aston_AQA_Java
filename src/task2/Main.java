package task2;

public class Main {
    static void main(String[] args) {
        TelephoneDirectory telRegion = new TelephoneDirectory();
        telRegion.add("Иванов", "79009009090");
        telRegion.add("Иванов", "79009009191");
        telRegion.add("Петров", "79009002222");

        telRegion.get("Иванов");
        telRegion.get("Петров");
        telRegion.get("Сидоров");
    }
}
