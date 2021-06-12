package creationalPatterns.factoryMethod.simpleFactory;

/**
 * 披萨店
 * 使用简单工厂模式，创建具体披萨对象
 */
public class PizzaStore {
    public Pizza orderPizza(String type) {
        Pizza pizza;
        //使用工厂对象的创建方法，而不是直接new。这里不再使用具体实例化
        pizza = SimplyPizzaFactory.createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }

    /**
     * 测试 简单工厂模式
     */
    public static void main(String[] args) {
        PizzaStore pizzaStore = new PizzaStore();
        Pizza pizza = pizzaStore.orderPizza("cheese");
    }
}
