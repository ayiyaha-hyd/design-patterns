package creationalPatterns.prototype;

import java.util.Objects;

/**
 * 访问类
 */
public class Client {
    public static void main(String[] args) {
        //创建一个Circle对象
        Circle circle = new Circle();
        circle.setX(1);
        circle.setY(2);
        circle.setColor("red");
        circle.setRadius(3);
        //克隆出两个对象
        Shape circle1 = circle.myClone();
        Shape circle2 = circle.myClone();

        //查看
        System.out.println(circle + "\n" + circle1 + "\n" + circle2);
        //调用equals()方法
        System.out.println("circle equals circle1 :" + Objects.equals(circle, circle1));
        System.out.println("circle equals circle2 :" + Objects.equals(circle, circle2));
        System.out.println("circle1 equals circle2 :" + Objects.equals(circle1, circle2));

        //判断内存地址是否相等
        System.out.println("circle == circle1 :" + (circle == circle1));
        System.out.println("circle == circle2 :" + (circle == circle2));
        System.out.println("circle1 == circle2 :" + (circle1 == circle2));

    }
}
