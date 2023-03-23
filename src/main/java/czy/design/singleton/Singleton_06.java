package czy.design.singleton;

/**
 * 懒汉式（静态内部类）
 */
public class Singleton_06 {
    private Singleton_06() {
    }
    private static class SingletonHolder{
        private static final Singleton_06 INSTANCE = new Singleton_06();
    }
    public static Singleton_06 getInstance(){
        return SingletonHolder.INSTANCE;
    }
}
