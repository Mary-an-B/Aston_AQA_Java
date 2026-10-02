public class Main {
    public static void main(String[] args) {

        Dog rex = new Dog("Рекс");
        Dog bobik = new Dog("Бобик");

        Cat[] cats = new Cat[3];
        cats[0] = new Cat("Мурка");
        cats[1] = new Cat("Беляш");
        cats[2] = new Cat("Пушок");

        Bowl bowl = new Bowl();
        bowl.addFood(45);

        for (int i = 0; i < cats.length; i++) {
            cats[i].eat(bowl);
            System.out.println(cats[i].isSatiated() ? "Кот " + cats[i].getName() + " сыт" : "Кот " + cats[i].getName() +  " голоден");
        }

        rex.run(700);
        bobik.run(400);
        rex.swim(10);
        bobik.swim(50);
        cats[0].run(300);
        cats[1].run(100);
        cats[2].swim(2);

        System.out.println(Dog.getDogCount());
        System.out.println(Cat.getCatCount());
        System.out.println(Animal.getAnimalCount());

    }
}
