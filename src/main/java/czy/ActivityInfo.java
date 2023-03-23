package czy;

import java.util.Date;

public class ActivityInfo {

    private String activityId;    // 活动ID
    private String activityName;  // 活动名称
    private Date beginTime;       // 开始时间
    private Date endTime;         // 结束时间
    public ActivityInfo(){

    }
    public ActivityInfo(String activityId,String activityName, Date beginTime, Date endTime){
        this.activityId = activityId;
        this.activityName = activityName;
        this.beginTime = beginTime;
        this.endTime = endTime;
    }
    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }



    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
