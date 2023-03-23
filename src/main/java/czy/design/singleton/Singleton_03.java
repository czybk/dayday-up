package czy.design.singleton;

/**
 * 懒汉式-3（线程不安全）
 */
public class Singleton_03 {
    private Singleton_03(){
    }
    private static Singleton_03 instance;
    public static Singleton_03 getInstance(){
        if(instance == null){
            instance = new Singleton_03();
        }
        return instance;
    }
}
