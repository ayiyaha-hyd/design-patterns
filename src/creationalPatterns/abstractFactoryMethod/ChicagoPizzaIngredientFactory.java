package creationalPatterns.abstractFactoryMethod;

/**
 * 芝加哥比萨配料厂
 * 具体工厂角色，比萨配料厂的实现类
 */
public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory {
    public ChicagoPizzaIngredientFactory() {
        System.out.println("use ChicagoPizzaIngredientFactory...");
    }

    @Override
    public Dough createDough() {
        return new ChicagoDough();
    }

    @Override
    public Sauce createSauce() {
        return new ChicagoSauce();
    }
}
