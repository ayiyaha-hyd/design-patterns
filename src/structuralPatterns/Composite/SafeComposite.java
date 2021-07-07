package structuralPatterns.Composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合模式之安全模式
 * 待实现方法放在树枝
 */
public class SafeComposite {
    public static void main(String[] args) {
        Branch branch = new Branch();
        Leaf01 leaf01 = new Leaf01("leaf01");
        Leaf02 leaf02 = new Leaf02("leaf02");
        branch.add(leaf01);
        branch.add(leaf02);
        branch.display();
    }
}

/**
 * 抽象构件
 */
abstract class Component{
    public abstract void display();
}

/**
 * 树叶构件
 */
class Leaf01 extends Component{
    private String name;
    public Leaf01(String name){
        this.name = name;
    }
    @Override
    public void display() {
        System.out.println("树叶 "+name+" 被访问..");
    }
}

class Leaf02 extends Component{
    private String name;
    public Leaf02(String name){
        this.name = name;
    }
    @Override
    public void display() {
        System.out.println("树叶 "+name+" 被访问..");
    }
}

class Branch extends Component{
    private List<Component> leaves = new ArrayList<>();
    public void add(Component c){
        leaves.add(c);
    }
    public void remove(Component c){
        leaves.remove(c);
    }
    @Override
    public void display() {
        for (Component leaf : leaves) {
            leaf.display();
        }
    }
}