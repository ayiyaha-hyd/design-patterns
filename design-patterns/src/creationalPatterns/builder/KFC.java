package creationalPatterns.builder;

/**
 * 测试类
 */
public class KFC {
    public static void main(String[] args) {
        MealBuilder builder = new BuilderA();
        KFCWaiter kfcWaiter = new KFCWaiter(builder);
        Meal meal = kfcWaiter.construct();
        System.out.println(meal);
    }
}
