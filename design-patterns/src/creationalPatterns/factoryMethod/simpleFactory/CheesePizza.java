package creationalPatterns.factoryMethod.simpleFactory;

/**
 * 芝士披萨
 * 具体的产品角色，披萨产品的实现类
 */
public class CheesePizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("prepare CheesePizza ...");
    }

    @Override
    public void bake() {
        System.out.println("bake CheesePizza ...");
    }

    @Override
    public void cut() {
        System.out.println("cut CheesePizza ...");
    }

    @Override
    public void box() {
        System.out.println("box CheesePizza ...");
    }
}
