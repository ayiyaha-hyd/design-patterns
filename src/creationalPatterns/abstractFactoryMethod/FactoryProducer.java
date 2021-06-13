package creationalPatterns.abstractFactoryMethod;

/**
 * 工厂创造器/生成器类
 * 通过传递参数获取不同工厂
 */
public class FactoryProducer {
    public static PizzaIngredientFactory getFactory(String type) {
        if ("NY".equals(type)) {
            return new NYPizzaIngredientFactory();
        } else if ("Chicago".equals(type)) {
            return new ChicagoPizzaIngredientFactory();
        }
        return null;
    }
}
