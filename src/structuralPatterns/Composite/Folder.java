package structuralPatterns.Composite;

import java.util.ArrayList;
import java.util.List;

public class Folder extends File{
    private List<File> files = new ArrayList<>();
    @Override
    public void add(File file) {
        files.add(file);
    }

    @Override
    public void remove(File file) {
        file.remove(file);
    }

    @Override
    public void display() {
        for (File file : files) {
            file.display();
        }
    }
}
