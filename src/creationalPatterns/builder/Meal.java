package creationalPatterns.builder;

/**
 * 套餐类
 * 产品角色
 */
public class Meal {
    private String food;

    private String drink;

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    @Override
    public String toString() {
        return "food= " + food + "\ndrink= " + drink;
    }
}
