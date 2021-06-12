package creationalPatterns.factoryMethod.simpleFactory;

/**
 * 披萨
 * 抽象产品角色。为所有产品的父类
 * 定义披萨具有的抽象方法，供子类实现具体方法
 */
public abstract class Pizza {
    public abstract void prepare();//准备

    public abstract void bake();//烤

    public abstract void cut();//切

    public abstract void box();//打包
}
