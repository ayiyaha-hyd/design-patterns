package creationalPatterns.factoryMethod.simpleFactory;

/**
 * Pizza制造工厂
 * 工厂角色。专门用于创建实例类的工厂，
 * 提供一个方法，该方法根据传递的参数不同返回不同类的具体实例
 */
public class SimplyPizzaFactory {
    //在简单工厂模式中创建实例的方法通常为静态（static）方法
    public static Pizza createPizza(String type) {
        Pizza pizza = null;
        if ("cheese".equals(type)) {
            pizza = new CheesePizza();
        } else if ("clam".equals(type)) {
            pizza = new ClamPizza();
        } else if ("pepperoni".equals(type)) {
            pizza = new PepperoniPizza();
        } else if ("veggie".equals(type)) {
            pizza = new VeggiePizze();
        }
        return pizza;
    }
}
