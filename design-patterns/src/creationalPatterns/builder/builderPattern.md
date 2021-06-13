# 建造者模式

---
流水作业大家应该都清楚吧！在流水作业中，我们可以将一些复杂的东西给构建出来，例如汽车。我们都知道汽车内部构件比较复杂，由很多部件组成，例如车轮、车门、发动机、方向盘等等，对于我们用户来说我们并不需要知道这个汽车是如何构建出来的，它的各个部件是如何组装，我们只需要知道一点：这是一辆完整的汽车。同样KFC也是这样的，在KFC中我们吃套餐也不需要知道这个套餐是怎样做出来的，我们只需要在店里面向服务员点就可以得到相应的套餐了。对于这两个例子我们通过指定某个对象类型就可以得到一个完整的对象，而无须关心其内部的构建。

在软件开发中，也会存在一些构造非常复杂的对象，这些对象拥有一系列的成员属性，这些成员属性有些是基本数据类型，有些是引用类型，总之就是一句话，这个对象的构建比较复杂。在这里我们就将复杂对象当做汽车，成员属性当做部件，对象的构建当做汽车的组合。对于用户而言我们总是希望我们在使用对象时足够简单，如果一个复杂的对象直接丢给用户，用户会是痛苦不堪的(给你一堆部件，你来组装成一辆汽车看看)，除了这个构建的过程外，可能用户会忘记某些成员属性。所以我们就希望能够像使用汽车一样使用复杂的对象：直接告诉你我需要的对象名或者对象类型，你返回一个完成的对象实例给我。建造者返回给客户一个完整的的产品对象，而客户端无须关心该对象所包含的额属性和组建方式，这就是建造者模式的设计动机。

这类产品的创建无法用前面介绍的工厂模式描述，只有建造者模式可以很好地描述该类产品的创建。

## 一、模式定义
将一个复杂对象的构造与它的表示分离，使同样的构建过程可以创建不同的表示，这样的设计模式被称为建造者模式。

它是将一个复杂的对象分解为多个简单的对象，然后一步一步构建而成。它将变与不变分离，即产品的组成部分是不变的，但每一部分是可以灵活选择的。

## 二、模式结构
产品角色（Product）：它是包含多个组成部件的复杂对象，由具体建造者来创建其各个零部件。  
抽象建造者（Builder）：它是一个包含创建产品各个子部件的抽象方法的接口，通常还包含一个返回复杂产品的方法 getResult()。  
具体建造者(Concrete Builder）：实现 Builder 接口，完成复杂产品的各个部件的具体创建方法。  
指挥者（Director）：它调用建造者对象中的部件构造与装配方法完成复杂对象的创建，在指挥者中不涉及具体产品的信息。

## 三、模式实现
KFC里面一般都有好几种可供客户选择的套餐，它可以根据客户所点的套餐，然后在后面做这些套餐，返回给客户的事一个完整的、美好的套餐。下面我们将会模拟这个过程，我们约定套餐主要包含汉堡、薯条、可乐、鸡腿等等组成部分，使用不同的组成部分就可以构建出不同的套餐。

最后由KFC的服务员，给你一个完美的套餐。

代码实现：
产品角色
```java
/**
 * 套餐类
 * 产品角色
 */
public class Meal {
    private String food;

    private String drink;

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    @Override
    public String toString() {
        return "food= " + food + "\ndrink= " + drink;
    }
}
```
抽象建造者角色
```java
/**
 * 抽象建造者
 */
public abstract class MealBuilder {
    protected Meal meal = new Meal();

    public abstract void buildFood();

    public abstract void buildDrink();

    public Meal getMeal() {
        return meal;
    }
}
```
具体建造者角色：  
BuilderA
```java
/**
 * A套餐
 * 具体建造者角色
 */
public class BuilderA extends MealBuilder {
    @Override
    public void buildFood() {
        meal.setFood("一盒薯条");
    }

    @Override
    public void buildDrink() {
        meal.setDrink("一杯可乐");
    }
}
```
BuilderB
```java
/**
 * B套餐
 * 具体建造者角色
 */
public class BuilderB extends MealBuilder {
    @Override
    public void buildFood() {
        meal.setFood("三个鸡翅");
    }

    @Override
    public void buildDrink() {
        meal.setDrink("一杯柠檬果汁");
    }
}
```
指挥者角色
```java
/**
 * 服务员
 * 指挥者角色
 */
public class KFCWaiter {
    private MealBuilder mealBuilder;

    public KFCWaiter(MealBuilder mealBuilder) {
        this.mealBuilder = mealBuilder;
    }

    public Meal construct() {
        mealBuilder.buildFood();
        mealBuilder.buildDrink();
        return mealBuilder.getMeal();
    }
}
```
测试类
```java
/**
 * 测试类
 */
public class KFC {
    public static void main(String[] args) {
        MealBuilder builder = new BuilderA();
        KFCWaiter kfcWaiter = new KFCWaiter(builder);
        Meal meal = kfcWaiter.construct();
        System.out.println(meal);
    }
}
```

## 四、模式优点和缺点
### 优点
（1）封装性好，构建和表示分离。  
（2）扩展性好，各个具体的建造者相互独立，有利于系统的解耦。  
（3）客户端不必知道产品内部组成的细节，建造者可以对创建过程逐步细化，而不对其它模块产生任何影响，便于控制细节风险。

### 缺点
（1）产品的组成部分必须相同，这限制了其使用范围。  
（2）如果产品的内部变化复杂，如果产品内部发生变化，则建造者也要同步修改，后期维护成本较大。

## 五、模式适用场景
（1）需要生成的产品对象有复杂的内部结构，这些产品对象通常包含多个成员属性。  
（2）隔离复杂对象的创建和使用，并使得相同的创建过程可以创建不同的产品。

## 六、模式总结
（1）建造者模式是将一个复杂对象的创建过程给封装起来，客户只需要知道可以利用对象名或者类型就能够得到一个完整的对象实例，而不需要关心对象的具体创建过程。  
（2）建造者模式将对象的创建过程与对象本身隔离开了，使得细节依赖于抽象，符合依赖倒置原则。可以使用相同的创建过程来创建不同的产品对象。