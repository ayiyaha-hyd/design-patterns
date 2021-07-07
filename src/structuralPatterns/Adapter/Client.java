package structuralPatterns.Adapter;

/**
 * 对象适配器
 * 为什么没有将类适配器呢？因为类适配器需要使用多重继承，这个在java中没有办法实现的。但是当我们遇到可以使用多重继承语言的时候，还是可能会遇到这种需求
 */
public class Client {
    public static void main(String[] args) {
        Phone phone = new Phone();
//        phone.charge(new Voltage5V());

        //通过适配器，使用220V电压，提供5V充电
        VoltageAdapter adapter = new VoltageAdapter(new Voltage220V());
        phone.charge(adapter);

    }
}
