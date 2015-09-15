package cn.fundview.setting.model;


public class TaskOfficeOrder {
    private String id;

    private String taskId;

    private String firstAgent;

    private Office office;

    private InsideTask insideTask;

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

    public String getFirstAgent() {
        return firstAgent;
    }

    public void setFirstAgent(String firstAgent) {
        this.firstAgent = firstAgent == null ? null : firstAgent.trim();
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public InsideTask getInsideTask() {
        return insideTask;
    }

    public void setInsideTask(InsideTask insideTask) {
        this.insideTask = insideTask;
    }
}