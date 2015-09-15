package cn.fundview.modules.model;

import java.util.Date;

public class ExpertConsulation {
    private Integer id;

    private boolean isPhoneConsulation;

    private Double phoneConsulationPrice;

    private boolean isSceneConsulation;

    private Double sceneConsulationPrice;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean getIsPhoneConsulation() {
        return isPhoneConsulation;
    }

    public void setIsPhoneConsulation(boolean isPhoneConsulation) {
        this.isPhoneConsulation = isPhoneConsulation;
    }

    public Double getPhoneConsulationPrice() {
        return phoneConsulationPrice;
    }

    public void setPhoneConsulationPrice(Double phoneConsulationPrice) {
        this.phoneConsulationPrice = phoneConsulationPrice;
    }

    public boolean getIsSceneConsulation() {
        return isSceneConsulation;
    }

    public void setIsSceneConsulation(boolean isSceneConsulation) {
        this.isSceneConsulation = isSceneConsulation;
    }

    public Double getSceneConsulationPrice() {
        return sceneConsulationPrice;
    }

    public void setSceneConsulationPrice(Double sceneConsulationPrice) {
        this.sceneConsulationPrice = sceneConsulationPrice;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}