package czy.threads;

public class RunnableTest implements Runnable{
    private volatile int index = 1;
    private final static int MAX = 50;

    @Override
    public void run() {
        while (index <= MAX){
            System.out.println(Thread.currentThread() + " 's number is:" + (index++));
        }
    }
}
