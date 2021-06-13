package creationalPatterns.factoryMethod.simpleFactory;

/**
 * 意大利辣香肠比萨
 * 具体的产品角色，披萨产品的实现类
 */
public class PepperoniPizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("prepare PepperoniPizza ...");
    }

    @Override
    public void bake() {
        System.out.println("bake PepperoniPizza ...");
    }

    @Override
    public void cut() {
        System.out.println("cut PepperoniPizza ...");
    }

    @Override
    public void box() {
        System.out.println("box PepperoniPizza ...");
    }
}
