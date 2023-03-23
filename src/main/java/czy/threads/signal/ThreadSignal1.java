package czy.threads.signal;

public class ThreadSignal1 extends Thread{

    private String threadName;
    public ThreadSignal1(String threadName){
        this.threadName = threadName;
    }
    @Override
    public void run() {
        System.out.println("I'm running");
        while(true){
            if(this.isInterrupted()){
                System.out.println("I'll quit!");
                break;
            }
        }
        System.out.println("I'll over");
    }
}
