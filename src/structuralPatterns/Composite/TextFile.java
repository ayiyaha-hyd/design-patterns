package structuralPatterns.Composite;

public class TextFile extends File{
    private String name;
    public TextFile(String name){
        this.name = name;
    }
    @Override
    public void add(File file) {

    }

    @Override
    public void remove(File file) {

    }

    @Override
    public void display() {
        System.out.println("树叶 "+name+" 被访问..");
    }
}
