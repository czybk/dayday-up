package czy.design.singleton;

/**
 * 懒汉式（双重检查锁）
 */
public class Singleton_05 {

    private static volatile Singleton_05 instance;

    private Singleton_05() {
    }
    public static Singleton_05 getInstance(){
       if(null != instance) return instance;
        if (null == instance){
            synchronized (Singleton_05.class){
                if(null == instance){
                    instance = new Singleton_05();
                }
           }
       }
       return instance;
    }

}
