# 抽象工厂模式

---
在工厂方法模式中，我们使用一个工厂创建一类型产品，也就是说一个具体的工厂对应一个类型的产品。但是有时候我们需要一个工厂能够提供多个类型的产品对象，而不是单一类型的对象，这个时候我们就需要使用抽象工厂模式。

前面介绍的工厂方法模式中考虑的是一类产品的生产，如畜牧场只养动物、电视机厂只生产电视机、计算机软件学院只培养计算机软件专业的学生等。

同种类称为同等级，也就是说：工厂方法模式只考虑生产同等级的产品，但是在现实生活中许多工厂是综合型的工厂，能生产多等级（种类） 的产品，如农场里既养动物又种植物，电器厂既生产电视机又生产洗衣机或空调，大学既有软件专业又有生物专业等。

本节要介绍的抽象工厂模式将考虑多等级产品的生产，将同一个具体工厂所生产的位于不同等级的一组产品称为一个产品族，例如海尔工厂生产海尔电视，海尔空调，海尔冰箱等等，属于一个产品族

在讲解抽象工厂模式之前，我们需要厘清两个概念：

产品等级结构。产品的等级结构也就是产品的继承结构。例如一个为空调的抽象类，它有海尔空调、格力空调、美的空调等一系列的子类，那么这个抽象类空调和他的子类就构成了一个产品等级结构。

产品族。产品族是在抽象工厂模式中的。在抽象工厂模式中，产品族是指由同一个工厂生产的，位于不同产品等级结构中的一组产品。比如，海尔工厂生产海尔空调。海尔冰箱，那么海尔空调则位于空调产品族中。。

## 一、基本定义
是一种为访问类提供一个创建一组相关或相互依赖对象的接口，且访问类无须指定所要产品的具体类就能得到同族的不同等级的产品的模式结构。

抽象工厂模式提供一个接口，用于创建相关或者依赖对象的家族，而不需要明确指定具体类。

抽象工厂模式是工厂方法模式的升级版本，工厂方法模式只生产一个等级的产品，而抽象工厂模式可生产多个等级的产品。

## 二、模式结构
（1）抽象工厂（Abstract Factory）：提供了创建产品的接口，它包含多个创建产品的方法 newProduct()，可以创建多个不同等级的产品。  
（2）具体工厂（Concrete Factory）：主要是实现抽象工厂中的多个抽象方法，完成具体产品的创建。  
（3）抽象产品（Product）：定义了产品的规范，描述了产品的主要特性和功能，抽象工厂模式有多个抽象产品。  
（4）具体产品（ConcreteProduct）：实现了抽象产品角色所定义的接口，由具体工厂来创建，它同具体工厂之间是多对一的关系。

## 三、模式实现
依然是披萨店。为了要保证每家加盟店都能够生产高质量的披萨，防止使用劣质的原料。我们打算建造一家生产原料的工厂，并将原料运送到各家加盟店。但是加盟店都位于不同的区域，比如纽约、芝加哥。纽约使用一组原料，芝加哥使用另一种原料。在这里我们可以这样理解，这些不同的区域组成了原料家族，每个区域实现了一个完整的原料家族。

代码实现：  
抽象工厂类
```java
/**
 * 比萨配料厂
 * 抽象工厂角色，负责创建所有的原料
 * 在接口中，每个原料都有一个对应的方法创建该原料
 */
public interface PizzaIngredientFactory {
    public Dough createDough();     //制作面团

    public Sauce createSauce();     //制作酱汁
}
```
抽象产品类  
Dough
```java
public abstract class Dough {
    protected String name;
}
```
Sauce
```java
public abstract class Sauce {
    protected String name;
}
```
具体工厂类  
NYPizzaIngredientFactory
```java
/**
 * 纽约比萨配料厂
 * 具体的工厂角色，比萨配料厂的实现类
 */
public class NYPizzaIngredientFactory implements PizzaIngredientFactory {
    public NYPizzaIngredientFactory(){
        System.out.println("use NYPizzaIngredientFactory...");
    }
    @Override
    public Dough createDough() {
        return new NYDough();
    }

    @Override
    public Sauce createSauce() {
        return new NYSauce();
    }
}
```
ChicagoPizzaIngredientFactory
```java
/**
 * 芝加哥比萨配料厂
 * 具体工厂角色，比萨配料厂的实现类
 */
public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory {
    public ChicagoPizzaIngredientFactory() {
        System.out.println("use ChicagoPizzaIngredientFactory...");
    }

    @Override
    public Dough createDough() {
        return new ChicagoDough();
    }

    @Override
    public Sauce createSauce() {
        return new ChicagoSauce();
    }
}
```
工厂生产器类，通过传递参数获取不同工厂
```java
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
```
具体的产品
```java
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
```

## 四、模式优点和缺点
### 优点
（1）抽象工厂隔离了具体类的生成，是的客户端不需要知道什么被创建。所有的具体工厂都实现了抽象工厂中定义的公共接口，因此只需要改变具体工厂的实例，就可以在某种程度上改变整个软件系统的行为。  
（2） 当一个产品族中的多个对象被设计成一起工作时，它能够保证客户端始终只使用同一个产品族中的对象。
### 缺点
（1）添加新的行为时比较麻烦。如果需要添加一个新产品族对象时，需要更改接口及其下所有子类，这必然会带来很大的麻烦。

## 五、模式适用场景
（1）一个系统不应当依赖于产品类实例如何被创建、组合和表达的细节，这对于所有类型的工厂模式都是重要的。  
（2）系统中有多于一个的产品族，而每次只使用其中某一产品族。  
（3）属于同一个产品族的产品将在一起使用，这一约束必须在系统的设计中体现出来。  
（4）系统提供一个产品类的库，所有的产品以同样的接口出现，从而使客户端不依赖于具体实现。

## 六、总结
抽象工厂模式中主要的优点在于具体类的隔离，是的客户端不需要知道什么被创建了。其缺点在于增加新的等级产品结构比较复杂，需要修改接口及其所有子类。