package czy.threads.observable.test;

import czy.threads.observable.Observable;
import czy.threads.observable.ObservableThread;
import czy.threads.observable.TaskLifecycle;

import java.util.concurrent.TimeUnit;

public class observableThreadTest2 {
    public static void main(String[] args){
        final TaskLifecycle<String> lifecycle = new TaskLifecycle.EmptyLifecycle<String>()
        {
            public void onFinish(Thread thread, String result)
            {
                System.out.println("The result is " + result);
            }
        };
        Observable observableThread = new ObservableThread<>(lifecycle, () ->
        {
            try
            {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            System.out.println(" finished done.");
            return "Hello Observer";
        });
        observableThread.start();
    }
}
