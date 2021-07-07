package structuralPatterns.bridge;

/**
 * 抽象化角色
 */
public abstract class Shape {
    protected Color color;
    public Shape(Color color){
        this.color = color;
    }
    public abstract void draw();
}
