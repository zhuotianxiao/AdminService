package cn.fundview.setting.model;

import com.google.common.collect.Lists;

import java.util.List;

public class TaskUserOrder {
    private String id;

    private String taskId;

    private String consumer;

    private InsideTask insideTask;

    private User user;

    private List<InsideTaskDetail> insideTaskDetails = Lists.newArrayList();

    private float countTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId == null ? null : taskId.trim();
    }

    public String getConsumer() {
        return consumer;
    }

    public void setConsumer(String consumer) {
        this.consumer = consumer == null ? null : consumer.trim();
    }

    public InsideTask getInsideTask() {
        return insideTask;
    }

    public void setInsideTask(InsideTask insideTask) {
        this.insideTask = insideTask;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<InsideTaskDetail> getInsideTaskDetails() {
        return insideTaskDetails;
    }

    public void setInsideTaskDetails(List<InsideTaskDetail> insideTaskDetails) {
        this.insideTaskDetails = insideTaskDetails;
    }

    public float getCountTime() {
        return countTime;
    }

    public void setCountTime(float countTime) {
        this.countTime = countTime;
    }
}