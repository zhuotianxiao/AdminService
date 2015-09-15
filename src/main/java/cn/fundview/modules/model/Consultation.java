package cn.fundview.modules.model;

import java.util.Date;

/**
 * 咨询服务
 */
public class Consultation {
    private Integer id;

    private Integer compId;

    private String consulationMan;

    private String phone;

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    private String title;

    private String description;

    private Integer expertId;

    private String expertName;

    private String expertPhone;

    private Double price;

    private Date appointTime;

    private Integer status;

    private Integer cancelStatus;

    private String payId;

    private Date createDate;

    private Date updateTime;

    private Integer consulationType;

    private boolean mark;

    private String cancelCause;

    private String checkCause;

    private boolean evaluate;

    private String cancelCheckMark;

    public String getConsulationMan() {
        return consulationMan;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public Integer getExpertId() {
        return expertId;
    }

    public void setExpertId(Integer expertId) {
        this.expertId = expertId;
    }

    public String getExpertName() {
        return expertName;
    }

    public String getExpertPhone() {
        return expertPhone;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getAppointTime() {
        return appointTime;
    }

    public void setAppointTime(Date appointTime) {
        this.appointTime = appointTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCancelStatus() {
        return cancelStatus;
    }

    public void setCancelStatus(Integer cancelStatus) {
        this.cancelStatus = cancelStatus;
    }

    public String getPayId() {
        return payId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getConsulationType() {
        return consulationType;
    }

    public void setConsulationType(Integer consulationType) {
        this.consulationType = consulationType;
    }

    public boolean isMark() {
        return mark;
    }

    public void setMark(boolean mark) {
        this.mark = mark;
    }

    public String getCancelCause() {
        return cancelCause;
    }

    public String getCheckCause() {
        return checkCause;
    }

    public boolean isEvaluate() {
        return evaluate;
    }

    public void setEvaluate(boolean evaluate) {
        this.evaluate = evaluate;
    }

    public ExpertEvaluation getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(ExpertEvaluation evaluation) {
        this.evaluation = evaluation;
    }

    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }

    private ExpertEvaluation evaluation;

    private Report report;

    public void setConsulationMan(String consulationMan) {
        this.consulationMan = consulationMan == null ? null : consulationMan.trim();
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }


    public void setExpertName(String expertName) {
        this.expertName = expertName == null ? null : expertName.trim();
    }


    public void setExpertPhone(String expertPhone) {
        this.expertPhone = expertPhone == null ? null : expertPhone.trim();
    }


    public void setPayId(String payId) {
        this.payId = payId == null ? null : payId.trim();
    }


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public void setCancelCause(String cancelCause) {
        this.cancelCause = cancelCause == null ? null : cancelCause.trim();
    }

    public String getCancelCheckMark() {
        return cancelCheckMark;
    }

    public void setCancelCheckMark(String cancelCheckMark) {
        this.cancelCheckMark = cancelCheckMark;
    }

    public void setCheckCause(String checkCause) {
        this.checkCause = checkCause == null ? null : checkCause.trim();
    }

}