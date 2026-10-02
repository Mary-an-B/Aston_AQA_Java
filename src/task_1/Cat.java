package task_1;

public class Cat extends Animal {
    private static int catCount;
    private static final int MAX_RUN_DISTANCE = 200;
    private boolean satiety = false;
    private static final int FOOD_REQUIRED = 20;


    public Cat(String name) {
        super(name);
        catCount++;
    }

    public static int getCatCount() {
        return catCount;
    }

    @Override
    public void run(int distance) {
        System.out.println(distance <= MAX_RUN_DISTANCE ? getName() + " пробежал " + distance + " метров" : getName() + " не может пробежать так много!");
    }

    @Override
    public void swim(int distance) {
        System.out.println(getName() + " не умеет плавать");
    }

    public void eat(Bowl bowl) {
        if (bowl.getFoodAmount() >= FOOD_REQUIRED) {
            satiety = true;
            bowl.reduceFood(FOOD_REQUIRED);
        }
    }

    public boolean isSatiated() {
        return satiety;
    }

}
