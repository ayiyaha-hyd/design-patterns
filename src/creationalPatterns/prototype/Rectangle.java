package creationalPatterns.prototype;

import java.util.Objects;
import java.util.StringJoiner;

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
