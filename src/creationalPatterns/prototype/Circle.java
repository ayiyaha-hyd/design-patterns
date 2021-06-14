package creationalPatterns.prototype;

import java.util.Objects;
import java.util.StringJoiner;

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
