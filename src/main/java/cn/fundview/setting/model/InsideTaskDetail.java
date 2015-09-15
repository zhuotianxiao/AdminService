package cn.fundview.setting.model;


import java.util.Date;

public class InsideTaskDetail {
    private String id;

    private String orderId;

    private String userId;

    private Float workTime;

    private Date workDate;

    private Date createDate;

    private String description;

    private String done;

    private User user;

    private InsideTask insideTask;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Float getWorkTime() {
        return workTime;
    }

    public void setWorkTime(Float workTime) {
        this.workTime = workTime;
    }

    public Date getWorkDate() {
        return workDate;
    }

    public void setWorkDate(Date workDate) {
        this.workDate = workDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getDone() {
        return done;
    }

    public void setDone(String done) {
        this.done = done == null ? null : done.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}