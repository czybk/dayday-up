package czy;

import com.design.singleton.*;
import czy.threads.RunnableTest;

import java.util.concurrent.locks.Lock;

public class test {
    public static void main(String[] args) {
        final RunnableTest runnableTest = new RunnableTest();
        Thread thread1 = new Thread(runnableTest,"first window");
        // Thread thread2 = new Thread(runnableTest,"second window");
        // Thread thread3 = new Thread(runnableTest,"third window");
        // Thread thread4 = new Thread(runnableTest,"fourth window");
        thread1.start();
        // thread2.start();
        // thread3.start();
        // thread4.start();

        // Map<String, Object> testMap = new HashMap<>();
        // testMap.put("111","333");
        // Object testkey = testMap.put("111","222");
        // System.out.println(testkey);
    }

}
