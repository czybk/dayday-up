package czy.threads.signal.cyclicBarrier;

import java.util.concurrent.CyclicBarrier;

/**
 * 同步屏障
 * CyclicBarrier的字面意思是可循环使用（Cyclic）的屏障（Barrier）。
 * 它要做的事情是，让一组线程到达一个屏障（也可以叫同步点）时被阻塞，直到最后一个线程到达屏障时，屏障才会开门，所有被屏障拦截的线程才会继续执行
 * 因为主线程和子线程的调度是由CPU决定的，两个线程都有可能先执行
 */
public class CyclicBarrierTest {
    //如果把new CyclicBarrier(2)修改成new CyclicBarrier(3)，则主线程和子线程会永远等待，因为没有第三个线程执行await方法，即没有第三个线程到达屏障，所以之前到达屏障的两个线程都不会继续执行。
    static CyclicBarrier c = new CyclicBarrier(2);
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    c.await();
                } catch (Exception e) {
                }
                //子线程打印
                System.out.println(1);
            }
        }).start();
        try {
            c.await();
        } catch (Exception e) {
        }
        //主线程打印
        System.out.println(2);
    }
}
