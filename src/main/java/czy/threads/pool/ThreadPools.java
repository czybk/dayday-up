package czy.threads.pool;

import java.util.concurrent.*;

public class ThreadPools {

    /**
     * 调用ExecutorService生成线程池
     */
    private void executorServiceTest(){
        //创建固定线程池大小
        ExecutorService executorService = Executors.newFixedThreadPool(8);
        /**
         * newWorkStealingPool 是Java8添加的线程池。和别的4种不同，它用的是ForkJoinPool。
         * 使用ForkJoinPool的好处是，把1个任务拆分成多个“小任务”，把这些“小任务”分发到多个线程上执行。这些“小任务”都执行完成后，再将结果合并。
         * 之前的线程池中，多个线程共有一个阻塞队列，而newWorkStealingPool 中每一个线程都有一个自己的队列。
         * 当线程发现自己的队列没有任务了，就会到别的线程的队列里获取任务执行。可以简单理解为”窃取“。
         * 一般是自己的本地队列采取LIFO(后进先出)，窃取时采用FIFO(先进先出)，一个从头开始执行，一个从尾部开始执行，由于偷取的动作十分快速，会大量降低这种冲突，也是一种优化方式。
         */
        ExecutorService executorService1 = Executors.newWorkStealingPool(8);
        //计数器（循环次数）
        CountDownLatch countDownLatch = new CountDownLatch(8);
        for(int i=0;i<8;i++){
            executorService.execute(()->{
                try{
                    //....具体业务
                } catch(Exception e){
                    e.printStackTrace();
                }
                //完成线程
                countDownLatch.countDown();
            });
        }
        //阻塞线程，直到调用N次，countDown()方法才释放线程
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    /**
     * ThreadPool 自定义一个线程池
     */
    private static final ThreadPoolExecutor EXECUTOR = new ThreadPoolExecutor(2, 4, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(60000));

    public static void main(String[] args) {
        //自己的数组或集合,这里不再进行填充
        String[] ids = new String[10];

        for (String id : ids) {
            EXECUTOR.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        //需要执行的业务逻辑
                        System.out.println("业务逻辑正在执行");
                    } catch (Exception e) {
                        //todo
                    }
                }
            });
        }
    }
}
