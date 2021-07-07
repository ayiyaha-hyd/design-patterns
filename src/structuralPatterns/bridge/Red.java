package structuralPatterns.bridge;

/**
 * 具体实现化角色
 */
public class Red implements Color{
    @Override
    public void bepaint(String shape) {
        System.out.println("红色的"+shape);
    }
}
