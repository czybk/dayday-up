package czy.design.singleton;

/**
 * 饿汉式-2（静态代码块方式）
 */
public class Singleton_02 {
    private Singleton_02(){
    }
    private static Singleton_02 instance;
    static {
         instance = new Singleton_02();
    }
    public static Singleton_02 getInstance(){
        return instance;
    }
}
