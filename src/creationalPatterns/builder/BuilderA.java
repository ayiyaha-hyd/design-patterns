package creationalPatterns.builder;

/**
 * A套餐
 * 具体建造者角色
 */
public class BuilderA extends MealBuilder {
    @Override
    public void buildFood() {
        meal.setFood("一盒薯条");
    }

    @Override
    public void buildDrink() {
        meal.setDrink("一杯可乐");
    }
}
