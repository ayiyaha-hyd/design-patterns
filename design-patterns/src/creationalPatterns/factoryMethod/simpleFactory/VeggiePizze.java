package creationalPatterns.factoryMethod.simpleFactory;

/**
 * 素食比萨
 * 具体的产品角色，披萨产品的实现类
 */
public class VeggiePizze extends Pizza {
    @Override
    public void prepare() {
        System.out.println("prepare VeggiePizze ...");
    }

    @Override
    public void bake() {
        System.out.println("bake VeggiePizze ...");
    }

    @Override
    public void cut() {
        System.out.println("cut VeggiePizze ...");
    }

    @Override
    public void box() {
        System.out.println("box VeggiePizze ...");
    }
}
