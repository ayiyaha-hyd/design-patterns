package creationalPatterns.factoryMethod.factoryMethod;

/**
 * 测试 工厂方法模式
 */
public class PizzaTestDrive {
    public static void main(String[] args) {
        System.out.println("---------Joel 需要的芝加哥的深盘披萨---------");
        PizzaStore chicagoPizzaStore = new ChicagoPizzaStore();       //建立芝加哥的披萨店
        Pizza joelPizza = chicagoPizzaStore.orderPizza("cheese");             //下订单
        System.out.println("Joel ordered a " + joelPizza.getName() + "\n");

        System.out.println("---------Ethan 需要的纽约风味的披萨---------");
        PizzaStore nyPizzaStore = new NYPizzaStore();
        Pizza ethanPizza = nyPizzaStore.orderPizza("cheese");
        System.out.println("Ethan ordered a " + ethanPizza.getName() + "\n");
    }
}
