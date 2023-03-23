package czy.design.singleton;

import java.util.HashMap;

public class SingletonTest {
    public static void main(String[] args) {
        Singleton_07.INSTANCE.doSomething();
        Long beforeTime = System.currentTimeMillis();
        // System.out.println(Singleton_01.getInstance());
        // System.out.println(Singleton_01.getInstance());
        // System.out.println(Singleton_05.getInstance());
        // System.out.println(Singleton_05.getInstance());
        for(int i = 0; i< 1000; i++){
            new Thread(()->{
                // Singleton_02.getInstance();
                // System.out.println(Singleton_01.getInstance());
                // System.out.println(Singleton_02.getInstance());
                // System.out.println(Singleton_03.getInstance());
                Singleton_04.getInstance();
                // System.out.println(Singleton_05.getInstance());
                // System.out.println(Singleton_06.getInstance());
                // System.out.println(Singleton_08.getInstance());
                // System.out.println(Thread.currentThread().getName());
                HashMap map = new HashMap();
            }).start();
        }
        Long endTime = System.currentTimeMillis();
        System.out.println(endTime - beforeTime);
    }
}
