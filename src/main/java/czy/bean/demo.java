package czy.bean;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.concurrent.LinkedTransferQueue;
import java.util.function.Consumer;

public class demo {
    public static void main(String[] args) throws MalformedURLException, ClassNotFoundException {

        Consumer<String> nameConsumer = s -> System.out.println("hello! ~ "+s);
        nameConsumer.accept("Mahesh");
        nameConsumer.accept("Krishna");
        LinkedTransferQueue transferQueue = new LinkedTransferQueue();
        transferQueue.add(111);
        transferQueue.offer(222);
        transferQueue.poll();
        Thread thread = new Thread();

    }
}
