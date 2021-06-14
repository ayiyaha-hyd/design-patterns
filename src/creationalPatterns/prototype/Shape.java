package creationalPatterns.prototype;

import java.util.Objects;
import java.util.StringJoiner;

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
