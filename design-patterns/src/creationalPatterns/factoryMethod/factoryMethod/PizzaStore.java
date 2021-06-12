package creationalPatterns.factoryMethod.factoryMethod;

/**
 * 披萨店
 * 抽象工厂角色
 */
public abstract class PizzaStore {
    public Pizza orderPizza(String type) {
        Pizza pizza;
        pizza = createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }

    abstract Pizza createPizza(String type);        //创建pizza的方法交给子类去实现
}
