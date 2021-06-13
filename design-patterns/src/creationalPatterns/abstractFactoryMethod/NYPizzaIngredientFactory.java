package creationalPatterns.abstractFactoryMethod;

/**
 * 纽约比萨配料厂
 * 具体的工厂角色，比萨配料厂的实现类
 */
public class NYPizzaIngredientFactory implements PizzaIngredientFactory {
    public NYPizzaIngredientFactory(){
        System.out.println("use NYPizzaIngredientFactory...");
    }
    @Override
    public Dough createDough() {
        return new NYDough();
    }

    @Override
    public Sauce createSauce() {
        return new NYSauce();
    }
}
