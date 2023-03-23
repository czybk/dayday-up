package czy.design.singleton;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 懒汉式-CAS方式
 */
public class Singleton_08 {

    private static final AtomicReference<Singleton_08> INSTANCE = new AtomicReference<Singleton_08>();
    private Singleton_08() {
    }
    public static final Singleton_08 getInstance() {
        Singleton_08 instance = INSTANCE.get();
        if (null != instance) return instance;
        INSTANCE.compareAndSet(null, new Singleton_08());
        return INSTANCE.get();
    }

}
