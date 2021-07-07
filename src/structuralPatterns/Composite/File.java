package structuralPatterns.Composite;

public abstract class File {
    public abstract void add(File file);
    public abstract void remove(File file);
    public abstract void display();
}
