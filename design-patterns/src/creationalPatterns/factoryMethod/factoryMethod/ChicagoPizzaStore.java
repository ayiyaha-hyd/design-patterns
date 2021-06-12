package creationalPatterns.factoryMethod.factoryMethod;

/**
 * 芝加哥比萨店
 * 具体工厂角色，披萨工厂的实现类
 */
public class ChicagoPizzaStore extends PizzaStore {
    @Override
    Pizza createPizza(String type) {
        Pizza pizza = null;
        if ("cheese".equals(type)) {
            pizza = new ChicagoStyleCheesePizza();
        } else if ("clam".equals(type)) {
            pizza = new ChicagoStyleClamPizza();
        } else if ("pepperoni".equals(type)) {
            pizza = new ChicagoStylePepperoniPizza();
        } else if ("veggie".equals(type)) {
            pizza = new ChicagoStyleVeggiePizza();
        }
        return pizza;
    }
}
