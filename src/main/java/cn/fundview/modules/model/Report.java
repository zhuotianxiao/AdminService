package cn.fundview.modules.model;

import java.util.Date;

/**
 * 企业上传的咨询服务报告
 */
public class Report {
    private Integer id;

    private String problemManifest;

    private String analyse;

    private String adverse;

    private String docPath;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProblemManifest() {
        return problemManifest;
    }

    public void setProblemManifest(String problemManifest) {
        this.problemManifest = problemManifest == null ? null : problemManifest.trim();
    }

    public String getAnalyse() {
        return analyse;
    }

    public void setAnalyse(String analyse) {
        this.analyse = analyse == null ? null : analyse.trim();
    }

    public String getAdverse() {
        return adverse;
    }

    public void setAdverse(String adverse) {
        this.adverse = adverse == null ? null : adverse.trim();
    }

    public String getDocPath() {
        return docPath;
    }

    public void setDocPath(String docPath) {
        this.docPath = docPath == null ? null : docPath.trim();
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