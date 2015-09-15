package cn.fundview.modules.model;

import java.util.Date;

/**
 * 专家评价
 */
public class ExpertEvaluation {
    private Integer id;

    private Integer serviceId;

    private Integer expertId;

    private Integer companyId;

    private Date createTime;

    private Integer satisfaction;

    private Byte timeliness;

    private Byte solvingDegree;

    private String evalutionTagIds;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public Integer getExpertId() {
        return expertId;
    }

    public void setExpertId(Integer expertId) {
        this.expertId = expertId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getSatisfaction() {
        return satisfaction;
    }

    public void setSatisfaction(Integer satisfaction) {
        this.satisfaction = satisfaction;
    }

    public Byte getTimeliness() {
        return timeliness;
    }

    public void setTimeliness(Byte timeliness) {
        this.timeliness = timeliness;
    }

    public Byte getSolvingDegree() {
        return solvingDegree;
    }

    public void setSolvingDegree(Byte solvingDegree) {
        this.solvingDegree = solvingDegree;
    }

    public String getEvalutionTagIds() {
        return evalutionTagIds;
    }

    public void setEvalutionTagIds(String evalutionTagIds) {
        this.evalutionTagIds = evalutionTagIds == null ? null : evalutionTagIds.trim();
    }
}