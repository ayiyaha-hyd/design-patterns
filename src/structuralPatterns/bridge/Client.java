package structuralPatterns.bridge;

/**
 * 桥接模式
 */
public class Client {
    public static void main(String[] args) {
        Red red = new Red();
        White white = new White();

        Circle circle = new Circle(red);
        Square square = new Square(white);

        circle.draw();
        square.draw();
    }
}
