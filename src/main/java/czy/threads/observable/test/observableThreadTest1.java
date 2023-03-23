package czy.threads.observable.test;

import czy.threads.observable.Observable;
import czy.threads.observable.ObservableThread;

import java.util.concurrent.TimeUnit;

public class observableThreadTest1 {
    public static void main(String[] args)
    {
        Observable observableThread = new ObservableThread<>(() ->
        {
            try
            {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            System.out.println(" finished done.");
            return null;
        });
        observableThread.start();
    }
}
