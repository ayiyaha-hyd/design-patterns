package structuralPatterns.bridge;

/**
 * 扩展抽象化角色
 */
public class Circle extends Shape{
    public Circle(Color color) {
        super(color);
    }

    @Override
    public void draw() {
        color.bepaint("正方形");
    }
}
