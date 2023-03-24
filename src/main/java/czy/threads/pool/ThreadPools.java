package czy.threads.pool;

import java.util.concurrent.*;

public class ThreadPools {

    /**
     * 调用ExecutorService生成线程池
     */
    private void executorServiceTest(){
        //创建固定线程池大小
        ExecutorService executorService = Executors.newFixedThreadPool(8);
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
