package czy.threads.threadlocal;

import java.util.ArrayList;
import java.util.List;

public class ThreadLocaDemo {
    private static ThreadLocal<List<String>> localVar = new ThreadLocal<>();

    static void print(String str) {
        //打印当前线程中本地内存中本地变量的值
        System.out.println(str + " :" + localVar.get());
        //清除本地内存中的本地变量
        localVar.remove();
    }
    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {
            localVar.set(new ArrayList<>(){{
                add("local_A");
                add("local_A1");
                add("local_A2");
            }});
            System.out.println(localVar.get());
            print("A");
            //打印本地变量
            System.out.println("after remove : " + localVar.get());
        },"A").start();

        Thread.sleep(1000);

        new Thread(new Runnable() {
            public void run() {
                localVar.set(new ArrayList<>(){{
                    add("local_B");
                    add("local_B1");
                    add("local_B2");
                }});
                print("B");
                System.out.println("after remove : " + localVar.get());

            }
        },"B").start();
    }
}
