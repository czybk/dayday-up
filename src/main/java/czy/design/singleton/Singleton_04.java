package czy.design.singleton;

/**
 * 懒汉式-4（线程安全）
 */
public class Singleton_04 {
    private Singleton_04(){
    }
    private static Singleton_04 instance;
    public static synchronized Singleton_04 getInstance(){
        if(instance == null){
            instance = new Singleton_04();
        }
        return instance;
    }
}
