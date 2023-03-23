package czy.design.singleton;

/**
 * 饿汉式-1（静态变量方式）
 */
public class Singleton_01 {
    private Singleton_01(){
    }
    private static Singleton_01 instance = new Singleton_01();
    public static Singleton_01 getInstance(){
        return instance;
    }
}
