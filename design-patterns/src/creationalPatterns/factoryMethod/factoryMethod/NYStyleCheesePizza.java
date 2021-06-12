package creationalPatterns.factoryMethod.factoryMethod;

/**
 * 纽约风味奶酪比萨
 * 具体产品角色，披萨产品实现类
 */
public class NYStyleCheesePizza extends Pizza {
    public NYStyleCheesePizza() {
        name = "Ny Style Sauce and Cheese Pizza";
        dough = "Thin Crust Dough";
        sause = "Marinara Sauce";
        toppings.add("Crated Reggiano Cheese");
    }
}
