package cn.fundview.setting.model;

import cn.fundview.common.persistence.DataEntity;
import com.google.common.collect.Lists;

import java.util.Date;
import java.util.List;

public class InsideTask extends DataEntity<InsideTask> {

    private String parentId;

    private String title;

    private String description;

    private String timer;

    private String level;

    private String type;

    private Date deadline;

    private String deferTimeRemarks;

    private String taskStatus;

    private InsideTask parentTask;


    private List<String> officeIds = Lists.newArrayList();
    private List<String> userIds = Lists.newArrayList();



    //任务状态
    public static final String TASK_STATUS_OK = "0";        //正在运行
    public static final String TASK_STATUS_APPROVAL = "1";  //等待审核
    public static final String TASK_STATUS_PAUSE = "2";     //超时暂停
    public static final String TASK_STATUS_TIMEOUT = "3";   //延时执行
    public static final String TASK_STATUS_STOP = "4";      //已结束
    public static final String TASK_STATUS_CANCEL = "5";    //已取消

    public static final String TASK_TYPE_COM = "0";        //公司任务
    public static final String TASK_TYPE_OFFICE = "1";     //部门任务


    public InsideTask() {
        super();
        this.taskStatus = TASK_STATUS_OK;
        this.type = TASK_TYPE_COM;
    }

    //setter and getter

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getTimer() {
        return timer;
    }

    public void setTimer(String timer) {
        this.timer = timer == null ? null : timer.trim();
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public String getDeferTimeRemarks() {
        return deferTimeRemarks;
    }

    public void setDeferTimeRemarks(String deferTimeRemarks) {
        this.deferTimeRemarks = deferTimeRemarks == null ? null : deferTimeRemarks.trim();
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus == null ? null : taskStatus.trim();
    }

    public List<String> getOfficeIds() {
        return officeIds;
    }

    public void setOfficeIds(List<String> officeIds) {
        this.officeIds = officeIds;
    }

    public List<String> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<String> userIds) {
        this.userIds = userIds;
    }

    public InsideTask getParentTask() {
        return parentTask;
    }

    public void setParentTask(InsideTask parentTask) {
        this.parentTask = parentTask;
    }
}