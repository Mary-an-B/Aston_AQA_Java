public class Dog extends Animal {
    private static int dogCount;
    private static final int MAX_RUN_DISTANCE = 500;
    private static final int MAX_SWIM_DISTANCE = 10;

    public Dog(String name) {
        super(name);
        dogCount++;
    }

    @Override
    public void run(int distance) {
        System.out.println(distance <= MAX_RUN_DISTANCE ? getName() + " пробежал " + distance + " метров" : getName() + " не может пробежать так много!");
    }

    @Override
    public void swim(int distance) {
        System.out.println(distance <= MAX_SWIM_DISTANCE ? getName() + " проплыл " + distance + " метров" : getName() + " не может плыть так много!");
    }

    public static int getDogCount() {
        return dogCount;
    }
}
