package task_1;

public class Bowl {
    private int foodAmount = 0;

    public void addFood(int food) {
        if (food > 0) this.foodAmount += food;
    }

    public int getFoodAmount() {
        return foodAmount;
    }

    public void reduceFood(int food) {
        if (foodAmount >= food) this.foodAmount -= food;
    }
}
