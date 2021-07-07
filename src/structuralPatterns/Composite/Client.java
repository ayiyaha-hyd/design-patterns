package structuralPatterns.Composite;

/**
 * 组合模式
 * （方式一：透明模式）
 * http://c.biancheng.net/view/1373.html
 */
public class Client {
    public static void main(String[] args) {
        Folder folder = new Folder();
        TextFile file1 = new TextFile("text1");
        ImageFile file2 = new ImageFile("image2");
        VideoFile file3 = new VideoFile("video3");
        folder.add(file1);
        folder.add(file2);
        folder.add(file3);

        folder.display();

    }
}
