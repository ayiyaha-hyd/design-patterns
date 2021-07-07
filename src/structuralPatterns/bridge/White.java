package structuralPatterns.bridge;

/**
 * 具体实现化角色
 */
public class White implements Color{
    @Override
    public void bepaint(String shape) {
        System.out.println("白色的"+shape);
    }
}
