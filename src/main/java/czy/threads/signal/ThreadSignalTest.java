package czy.threads.signal;

public class ThreadSignalTest {

    public static void main(String[] args) {
        Thread t1 = new ThreadSignal1();
        t1.setName("thread1");
        t1.start();
        t1.interrupt();
    }
}
