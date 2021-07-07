package structuralPatterns.bridge;

/**
 * 扩展抽象化角色
 */
public class Square extends Shape{
    public Square(Color color) {
        super(color);
    }

    @Override
    public void draw() {
        color.bepaint("正方形");
    }
}
