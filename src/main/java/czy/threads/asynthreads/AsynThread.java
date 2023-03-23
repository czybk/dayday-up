package czy.threads.asynthreads;

import czy.bean.ActivityInfo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class AsynThread {
    public static void main(String[] args) {
        List<ActivityInfo> activityInfoList = new ArrayList<ActivityInfo>(){{
            add(new ActivityInfo("","",new Date(),new Date()));
            add(new ActivityInfo("","",new Date(),new Date()));
            add(new ActivityInfo("","",new Date(),new Date()));
            add(new ActivityInfo("","",new Date(),new Date()));
            add(new ActivityInfo("","",new Date(),new Date()));
            add(new ActivityInfo("","",new Date(),new Date()));
            add(new ActivityInfo("","",new Date(),new Date()));
            add(new ActivityInfo("","",new Date(),new Date()));
            add(new ActivityInfo("","",new Date(),new Date()));
            add(new ActivityInfo("","",new Date(),new Date()));
            add(new ActivityInfo("","",new Date(),new Date()));
            add(new ActivityInfo("","",new Date(),new Date()));
            add(new ActivityInfo("","",new Date(),new Date()));
        }};
        CompletableFuture<String> future = CompletableFuture.supplyAsync(()->{
            ThreadTest threadTest = new ThreadTest(activityInfoList);
            threadTest.start();
            return "test";
        });
        try {
            future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        for (ActivityInfo activityInfo : activityInfoList) {
            System.out.println(activityInfo.getActivityId());
            System.out.println(activityInfo.getActivityName());
        }
    }
}
