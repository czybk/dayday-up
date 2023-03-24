package czy.threads.pool;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * CountDownLatch允许一个或多个线程等待其他线程完成操作。
 * 假如有这样一个需求：我们需要解析一个Excel里多个sheet的数据，此时可以考虑使用多线程，每个线程解析一个sheet里的数据，
 * 等到所有的sheet都解析完之后，程序需要提示解析完成。在这个需求中，要实现主线程等待所有线程完成sheet的解析操作，最简单的做法是使用join()方法。
 * 在JDK 1.5之后的并发包中提供的CountDownLatch也可以实现join的功能，并且比join的功能更多，
 * CountDownLatch的构造函数接收一个int类型的参数作为计数器，如果你想等待N个点完成，这里就传入N。
 * 当我们调用CountDownLatch的countDown方法时，N就会减1，CountDownLatch的await方法会阻塞当前线程，直到N变成零。
 * 由于countDown方法可以用在任何地方，所以这里说的N个点，可以是N个线程，也可以是1个线程里的N个执行步骤。用在多个线程时，
 * 只需要把这个CountDownLatch的引用传递到线程里即可。
 *
 *
 */
public class TestCountDownLatch {

    private static AtomicInteger id = new AtomicInteger();

    private static ExecutorService executorService = new ThreadPoolExecutor(4, 10, 0,
            TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(10), new ThreadPoolExecutor.DiscardPolicy());

    public static void main(String[] args) throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(4);
        for (int i = 0; i < 8; i++) {
            int result = i + 5;
            System.out.println("outside of the pool's result is: "+result);
            executorService.submit(() -> {
                //这一句用来看一下多线程效果
                System.out.println("inside of the thread pool's result is: "+result);
                //刚好4个线程，每个线程执行一个任务
                System.out.println(Thread.currentThread());
                    System.out.println("the thread " + id.getAndIncrement() + " is comming!");
                    //countDownLatch做减法
                    countDownLatch.countDown();
            });
        }
        System.out.println("all threads is comming");
        //直到计数器减为0之前主线程等待
        countDownLatch.await();
        // countDownLatch.await(3000, TimeUnit.MICROSECONDS);    //避免主线程无法执行到可以用这句
        executorService.shutdown();
        System.out.println("ok the task is over!");
    }
}
