package creationalPatterns.builder;

/**
 * B套餐
 * 具体建造者角色
 */
public class BuilderB extends MealBuilder {
    @Override
    public void buildFood() {
        meal.setFood("三个鸡翅");
    }

    @Override
    public void buildDrink() {
        meal.setDrink("一杯柠檬果汁");
    }
}
