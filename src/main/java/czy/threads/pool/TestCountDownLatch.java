package czy.threads.pool;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

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
                    System.out.println("inside of the thread pool's result is: "+result);   //这一句用来看一下多线程效果
                    System.out.println(Thread.currentThread());  //刚好4个线程，每个线程执行一个任务
                    System.out.println("the thread " + id.getAndIncrement() + " is comming!");
                    countDownLatch.countDown();
                }
            );
        }
        System.out.println("all threads is comming");
        countDownLatch.await();
        countDownLatch.await(3000, TimeUnit.MICROSECONDS);    //避免主线程无法执行到可以用这句
        executorService.shutdown();
        System.out.println("ok the task is over!");
    }
}
