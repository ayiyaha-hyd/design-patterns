package creationalPatterns.abstractFactoryMethod;

/**
 * 比萨配料厂
 * 抽象工厂角色，负责创建所有的原料
 * 在接口中，每个原料都有一个对应的方法创建该原料
 */
public interface PizzaIngredientFactory {
    public Dough createDough();     //制作面团

    public Sauce createSauce();     //制作酱汁
}
