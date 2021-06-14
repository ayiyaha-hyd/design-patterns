# 原型模式

---
对象拷贝的概念  
* 浅拷贝  
  创建一个新对象，新对象的属性和原来对象完全相同，对于非基本类型属性，仍指向原有属性所指向的对象的内存地址。  
  使用一个已知实例对新创建实例的成员变量逐个赋值。
* 深拷贝  
  创建一个新对象，属性中引用的其他对象也会被克隆，不再指向原有对象地址。  
  当一个类的拷贝构造方法，不仅要复制对象的所有非引用成员变量值，还要为引用类型的成员变量创建新的实例，并且初始化为形式参数实例值。

## 一、模式定义

## 二、模式结构
（1）抽象原型类：规定了具体原型对象必须实现的接口。  
（2）具体原型类：实现抽象原型类的 clone() 方法，它是可被复制的对象。  
（3）访问类：使用具体原型类中的 clone() 方法来复制新的对象。

## 三、模式实现

代码实现：  
抽象原型类
```java
/**
 * 抽象原型类
 * 形状
 */
public abstract class Shape {
    private int x;
    private int y;
    private String color;

    public Shape() {
    }

    /**
     * 原型构造函数
     */
    public Shape(Shape shape) {
        if (Objects.nonNull(shape)) {
            this.x = shape.x;
            this.y = shape.y;
            this.color = shape.color;
        }
    }

    /**
     * myClone()克隆方法，待子类实现
     */
    public abstract Shape myClone();

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Shape shape = (Shape) o;
        return x == shape.x && y == shape.y && color.equals(shape.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, color);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Shape.class.getSimpleName() + "[", "]")
                .add("x=" + x)
                .add("y=" + y)
                .add("color='" + color + "'")
                .toString();
    }
}
```
具体原型类  
Circle
```java
/**
 * 具体原型类
 * 圆形
 */
public class Circle extends Shape {
    private int radius;

    public Circle() {
    }

    /**
     * 原型构造函数。使用已有对象的数值来初始化一个新对象。
     */
    public Circle(Circle circle) {
        super(circle);
        if (Objects.nonNull(circle)) {
            this.radius = circle.radius;
        }
    }

    /**
     * clone（克隆）操作会返回一个圆形类
     */
    @Override
    public Circle myClone() {
        //调用原型构造函数初始化新对象
        return new Circle(this);
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Circle circle = (Circle) o;
        return radius == circle.radius;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), radius);
    }

    @Override
    public String toString() {
        return super.toString() + new StringJoiner(", ", Circle.class.getSimpleName() + "[", "]")
                .add("radius=" + radius)
                .toString();
    }
}
```
Rectangle
```java
/**
 * 具体原型类
 * 长方形
 */
public class Rectangle extends Shape {
    private int width;
    private int height;

    public Rectangle() {
    }

    /**
     * 原型构造函数。使用已有对象的数值来初始化一个新对象。
     */
    public Rectangle(Rectangle rectangle) {
        super(rectangle);
        if (Objects.nonNull(rectangle)) {
            this.width = rectangle.width;
            this.height = rectangle.height;
        }
    }

    /**
     * myClone（克隆）操作会返回一个长方形类
     */
    @Override
    public Shape myClone() {
        return new Rectangle(this);
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Rectangle rectangle = (Rectangle) o;
        return width == rectangle.width && height == rectangle.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), width, height);
    }

    @Override
    public String toString() {
        return super.toString() + new StringJoiner(", ", Rectangle.class.getSimpleName() + "[", "]")
                .add("width=" + width)
                .add("height=" + height)
                .toString();
    }
}
```
访问类
```java
/**
 * 访问类
 */
public class Client {
    public static void main(String[] args) {
        //创建一个Circle对象
        Circle circle = new Circle();
        circle.setX(1);
        circle.setY(2);
        circle.setColor("red");
        circle.setRadius(3);
        //克隆出两个对象
        Shape circle1 = circle.myClone();
        Shape circle2 = circle.myClone();

        //查看
        System.out.println(circle + "\n" + circle1 + "\n" + circle2);
        //调用equals()方法
        System.out.println("circle equals circle1 :" + Objects.equals(circle, circle1));
        System.out.println("circle equals circle2 :" + Objects.equals(circle, circle2));
        System.out.println("circle1 equals circle2 :" + Objects.equals(circle1, circle2));

        //判断内存地址是否相等
        System.out.println("circle == circle1 :" + (circle == circle1));
        System.out.println("circle == circle2 :" + (circle == circle2));
        System.out.println("circle1 == circle2 :" + (circle1 == circle2));
    }
}
```

## 四、模式优缺点
### 优点
（1）如果创建新的对象比较复杂时，可以利用原型模式简化对象的创建过程，同时也能够提高效率。  
（2）可以使用深克隆保持对象的状态。  
（3）原型模式提供了简化的创建结构。  
（4）Java 自带的原型模式基于内存二进制流的复制，在性能上比直接 new 一个对象更加优良。
### 缺点
（5）在实现深克隆的时候可能需要比较复杂的代码。  
（6）需要为每一个类配备一个克隆方法，而且这个克隆方法需要对类的功能进行通盘考虑，这对全新的类来说不是很难，但对已有的类进行改造时，不一定是件容易的事，必须修改其源代码，违背了“开闭原则”。

## 五、模式适用场景
（1）如果创建新对象成本较大，我们可以利用已有的对象进行复制来获得。  
（2）如果系统要保存对象的状态，而对象的状态变化很小，或者对象本身占内存不大的时候，也可以使用原型模式配合备忘录模式来应用。相反，如果对象的状态变化很大，或者对象占用的内存很大，那么采用状态模式会比原型模式更好。  
（3）需要避免使用分层次的工厂类来创建分层次的对象，并且类的实例对象只有一个或很少的几个组合状态，通过复制原型对象得到新实例可能比使用构造函数创建一个新实例更加方便。

## 六、总结
（1）原型模式向客户隐藏了创建对象的复杂性。客户只需要知道要创建对象的类型，然后通过请求就可以获得和该对象一模一样的新对象，无须知道具体的创建过程。  
（2）克隆分为浅克隆和深克隆两种。  
（3）我们虽然可以利用原型模式来获得一个新对象，但有时对象的复制可能会相当的复杂，比如深克隆。

---