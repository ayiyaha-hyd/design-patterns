package creationalPatterns.factoryMethod.factoryMethod;

/**
 * 芝加哥风味奶酪披萨
 * 具体产品角色，披萨产品的实现类
 */
public class ChicagoStyleCheesePizza extends Pizza {
    public ChicagoStyleCheesePizza() {
        name = "Chicago Style Deep Dish Cheese Pizza";
        dough = "Extra Thick Crust Dough";
        sause = "Plum Tomato Sauce";
        toppings.add("Shredded Mozzarella Cheese");
    }

    @Override
    public void cut() {
        System.out.println("Cutting the Pizza into square slices");
    }
}
