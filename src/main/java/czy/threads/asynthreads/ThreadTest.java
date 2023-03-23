package czy.threads.asynthreads;

import czy.bean.ActivityInfo;

import java.util.List;

public class ThreadTest extends Thread {

    private List<ActivityInfo> activityInfos;

    public ThreadTest(List<ActivityInfo> activityInfos){
        this.activityInfos = activityInfos;
    }

    @Override
    public void run() {
    //    doSomeThing
        int i =0;
        for (ActivityInfo activityInfo : activityInfos) {
            activityInfo.setActivityName(""+i);
            i++;
            System.out.println(i);
            System.out.println(activityInfo);
        }
    }
}
