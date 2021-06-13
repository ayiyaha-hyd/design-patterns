package creationalPatterns.abstractFactoryMethod;

/**
 * 具体的产品
 * 使用抽象工厂模式创建对象
 */
public class Pizza {
    private String name;
    private Dough dough;      //面团
    private Sauce sauce;      //酱料

    public Pizza(String type) {
        name = type + "Pizza";

        //使用指定工厂创建同一产品族的产品
        PizzaIngredientFactory factory = FactoryProducer.getFactory("NY");
        dough = factory.createDough();
        sauce = factory.createSauce();
    }

    //测试
    public static void main(String[] args) {
        PizzaStore pizzaStore = new PizzaStore();
        pizzaStore.createPizza("NY");

    }

    static class PizzaStore {
        Pizza createPizza(String type) {
            Pizza pizza = new Pizza(type);
            System.out.println(pizza.getName() + "...");
            System.out.println("use " + pizza.getDough() + "...");
            System.out.println("use " + pizza.getSauce() + "...");
            return pizza;
        }
    }
    public String getName() {
        return name;
    }
    public Dough getDough() {
        return dough;
    }
    public Sauce getSauce() {
        return sauce;
    }
}
