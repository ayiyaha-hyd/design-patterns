package creationalPatterns.Singleton;

public class SingletonDemo {

}

/*
 * 一般情况下，不建议使用懒汉方式，建议使用饿汉方式。
 * 只有在要明确实现 lazy loading 效果时，才会使用静态内部类方式。
 * 如果涉及到反序列化创建对象时，可以尝试使用枚举方式。
 * 如果有其他特殊的需求，可以考虑使用双检锁方式。
 */
/**
 * 懒汉式（线程不安全）
 * 调用时初始化
 * 严格意义上它并不算单例模式
 */
class Singleton1{
    //静态变量，记录内存中唯一实例
    private static Singleton1 instance;
    private Singleton1(){}
    public static Singleton1 getInstance(){
        if(instance == null){
            instance = new Singleton1();
        }
        return instance;
    }

}

/**
 * 懒汉式（线程安全）
 * 懒加载，第一次调用才初始化，避免资源浪费
 * 效率低
 */
class Singleton2{
    private static Singleton2 instance;
    private Singleton2(){}
    public synchronized static Singleton2 getInstance(){
        if(instance == null){
            instance = new Singleton2();
        }
        return instance;
    }
}

/**
 * 饿汉式（线程安全）
 * 没有加锁，执行效率会提高
 * 类加载时就初始化，浪费内存，容易产生垃圾对象
 *
 */
class Singleton3{
    private static Singleton3 instance = new Singleton3();
    private Singleton3(){}
    public static Singleton3 getInstance(){
        return instance;
    }
}

/**
 * 双重校验锁（线程安全）
 */
class Singleton4{
    //可见性，禁止指令重排序（instance = new Singleton4();）
    private volatile static Singleton4 instance;
    private Singleton4(){}
    public static Singleton4 getInstance(){
        if(instance == null){
            synchronized (Singleton4.class){
                if(instance == null){
                    //虚拟机的指令重排序，可能123，也可能312
                    //1.给singleton分配内存；
                    //2.调用 Singleton 的构造函数来初始化成员变量；
                    //3.将给singleton对象指向分配的内存空间（此时singleton才不为null）
                    instance = new Singleton4();
                }
            }
        }
        return instance;
    }
}

/**
 * 静态内部类（线程安全）
 * 这种方式只适用于静态域的情况，双检锁方式可在实例域需要延迟初始化时使用
 * 外部无法传递参数
 * 当外部内被访问时，并不会加载内部类，只有调用内部类属性时，才会实例化
 */
class Singleton5{
    private static class SingletonHolder {
        private static Singleton5 instance = new Singleton5();
    }
    private Singleton5(){}
    public static Singleton5 getInstance(){
        return SingletonHolder.instance;
    }
}

/**
 * 枚举类（线程安全）
 * 天生单例，
 * 不仅能避免多线程同步问题，而且还自动支持序列化机制，防止反序列化重新创建新的对象，绝对防止多次实例化。
 * （Effective Java 作者 Josh Bloch 提倡的方式）
 *
 */
enum Singleton6{
   INSTANCE;
   public void method(){
       //do something;
   }
}
