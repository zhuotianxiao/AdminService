package cn.fundview.modules.model;

import java.util.Date;

import cn.fundview.common.persistence.DataEntity;

public class TechRequ extends DataEntity<TechRequ>{

    private Integer compId;

    private String name;

    private String intro;

    private String tradeIds;

    private String tradeNames;

    private Integer status;

    private boolean recommend;

    private boolean hot;

    private boolean latest;

    private Integer recommendNum;

    private Integer hotNum;

    private Integer latestNum;

    private String hzfs;

    private String otherHzfs;

    private boolean valid;

    private Date updateTime;

    private String mark;

    private boolean isDelegate;

    private boolean isShow;

    private String delegateInfo;

    private String endTime;

    private Double finPlan;

    private boolean ynkt;

    private String requHj;

    private String otherRequHj;

    private String target;

    private String limAddress;

    private Integer lowReq;

    private String techMan;

    private String phone;

    private String tel;

    private String email;

    private boolean deleteMark;

    private Date publishDate;

    private String tags;

    private String choose;

    private String duty;

    private boolean allmoney;

    private Double allmoneyMoney;

    private Double developMoney;

    private String hzfsIntro;

    private boolean iaddress;

    private String materialIds;

    private String materialNames;

    private String achvInnovate;

    private boolean alonePer;

    private Double alonePerMoney;

    private boolean rejectPer;

    private Double rejectPerMoney;

    private boolean entrustOrg;

    private Double entrustOrgMoney;

    private boolean collOrg;

    private Double collOrgMoney;

    private boolean uniteExpertCompany;

    private boolean scene;

    private String otherRequ;

    private boolean expertConsult;

    private String expertConsultIntro;

    private Double serveMoney;

    private String materialTypeIds;

    private String materialTypeNames;

    private String productIds;

    private String productNames;

    private String prodTypeIds;

    private String prodTypeNames;

    private String recommendTrade;


    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro == null ? null : intro.trim();
    }

    public String getTradeIds() {
        return tradeIds;
    }

    public void setTradeIds(String tradeIds) {
        this.tradeIds = tradeIds == null ? null : tradeIds.trim();
    }

    public String getTradeNames() {
        return tradeNames;
    }

    public void setTradeNames(String tradeNames) {
        this.tradeNames = tradeNames == null ? null : tradeNames.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public boolean getRecommend() {
        return recommend;
    }

    public void setRecommend(boolean recommend) {
        this.recommend = recommend;
    }

    public boolean getHot() {
        return hot;
    }

    public void setHot(boolean hot) {
        this.hot = hot;
    }

    public boolean getLatest() {
        return latest;
    }

    public void setLatest(boolean latest) {
        this.latest = latest;
    }

    public Integer getRecommendNum() {
        return recommendNum;
    }

    public void setRecommendNum(Integer recommendNum) {
        this.recommendNum = recommendNum;
    }

    public Integer getHotNum() {
        return hotNum;
    }

    public void setHotNum(Integer hotNum) {
        this.hotNum = hotNum;
    }

    public Integer getLatestNum() {
        return latestNum;
    }

    public void setLatestNum(Integer latestNum) {
        this.latestNum = latestNum;
    }

    public String getHzfs() {
        return hzfs;
    }

    public void setHzfs(String hzfs) {
        this.hzfs = hzfs == null ? null : hzfs.trim();
    }

    public String getOtherHzfs() {
        return otherHzfs;
    }

    public void setOtherHzfs(String otherHzfs) {
        this.otherHzfs = otherHzfs == null ? null : otherHzfs.trim();
    }

    public boolean getValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark == null ? null : mark.trim();
    }

    public boolean getIsDelegate() {
        return isDelegate;
    }

    public void setIsDelegate(boolean isDelegate) {
        this.isDelegate = isDelegate;
    }

    public boolean getIsShow() {
        return isShow;
    }

    public void setIsShow(boolean isShow) {
        this.isShow = isShow;
    }

    public String getDelegateInfo() {
        return delegateInfo;
    }

    public void setDelegateInfo(String delegateInfo) {
        this.delegateInfo = delegateInfo == null ? null : delegateInfo.trim();
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime == null ? null : endTime.trim();
    }

    public Double getFinPlan() {
        return finPlan;
    }

    public void setFinPlan(Double finPlan) {
        this.finPlan = finPlan;
    }

    public boolean getYnkt() {
        return ynkt;
    }

    public void setYnkt(boolean ynkt) {
        this.ynkt = ynkt;
    }

    public String getRequHj() {
        return requHj;
    }

    public void setRequHj(String requHj) {
        this.requHj = requHj == null ? null : requHj.trim();
    }

    public String getOtherRequHj() {
        return otherRequHj;
    }

    public void setOtherRequHj(String otherRequHj) {
        this.otherRequHj = otherRequHj == null ? null : otherRequHj.trim();
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target == null ? null : target.trim();
    }

    public String getLimAddress() {
        return limAddress;
    }

    public void setLimAddress(String limAddress) {
        this.limAddress = limAddress == null ? null : limAddress.trim();
    }

    public Integer getLowReq() {
        return lowReq;
    }

    public void setLowReq(Integer lowReq) {
        this.lowReq = lowReq;
    }

    public String getTechMan() {
        return techMan;
    }

    public void setTechMan(String techMan) {
        this.techMan = techMan == null ? null : techMan.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public boolean getDeleteMark() {
        return deleteMark;
    }

    public void setDeleteMark(boolean deleteMark) {
        this.deleteMark = deleteMark;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags == null ? null : tags.trim();
    }

    public String getChoose() {
        return choose;
    }

    public void setChoose(String choose) {
        this.choose = choose == null ? null : choose.trim();
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty == null ? null : duty.trim();
    }

    public boolean getAllmoney() {
        return allmoney;
    }

    public void setAllmoney(boolean allmoney) {
        this.allmoney = allmoney;
    }

    public Double getAllmoneyMoney() {
        return allmoneyMoney;
    }

    public void setAllmoneyMoney(Double allmoneyMoney) {
        this.allmoneyMoney = allmoneyMoney;
    }

    public Double getDevelopMoney() {
        return developMoney;
    }

    public void setDevelopMoney(Double developMoney) {
        this.developMoney = developMoney;
    }

    public String getHzfsIntro() {
        return hzfsIntro;
    }

    public void setHzfsIntro(String hzfsIntro) {
        this.hzfsIntro = hzfsIntro == null ? null : hzfsIntro.trim();
    }

    public boolean getIaddress() {
        return iaddress;
    }

    public void setIaddress(boolean iaddress) {
        this.iaddress = iaddress;
    }

    public String getMaterialIds() {
        return materialIds;
    }

    public void setMaterialIds(String materialIds) {
        this.materialIds = materialIds == null ? null : materialIds.trim();
    }

    public String getMaterialNames() {
        return materialNames;
    }

    public void setMaterialNames(String materialNames) {
        this.materialNames = materialNames == null ? null : materialNames.trim();
    }

    public String getAchvInnovate() {
        return achvInnovate;
    }

    public void setAchvInnovate(String achvInnovate) {
        this.achvInnovate = achvInnovate == null ? null : achvInnovate.trim();
    }

    public boolean getAlonePer() {
        return alonePer;
    }

    public void setAlonePer(boolean alonePer) {
        this.alonePer = alonePer;
    }

    public Double getAlonePerMoney() {
        return alonePerMoney;
    }

    public void setAlonePerMoney(Double alonePerMoney) {
        this.alonePerMoney = alonePerMoney;
    }

    public boolean getRejectPer() {
        return rejectPer;
    }

    public void setRejectPer(boolean rejectPer) {
        this.rejectPer = rejectPer;
    }

    public Double getRejectPerMoney() {
        return rejectPerMoney;
    }

    public void setRejectPerMoney(Double rejectPerMoney) {
        this.rejectPerMoney = rejectPerMoney;
    }

    public boolean getEntrustOrg() {
        return entrustOrg;
    }

    public void setEntrustOrg(boolean entrustOrg) {
        this.entrustOrg = entrustOrg;
    }

    public Double getEntrustOrgMoney() {
        return entrustOrgMoney;
    }

    public void setEntrustOrgMoney(Double entrustOrgMoney) {
        this.entrustOrgMoney = entrustOrgMoney;
    }

    public boolean getCollOrg() {
        return collOrg;
    }

    public void setCollOrg(boolean collOrg) {
        this.collOrg = collOrg;
    }

    public Double getCollOrgMoney() {
        return collOrgMoney;
    }

    public void setCollOrgMoney(Double collOrgMoney) {
        this.collOrgMoney = collOrgMoney;
    }

    public boolean getUniteExpertCompany() {
        return uniteExpertCompany;
    }

    public void setUniteExpertCompany(boolean uniteExpertCompany) {
        this.uniteExpertCompany = uniteExpertCompany;
    }

    public boolean getScene() {
        return scene;
    }

    public void setScene(boolean scene) {
        this.scene = scene;
    }

    public String getOtherRequ() {
        return otherRequ;
    }

    public void setOtherRequ(String otherRequ) {
        this.otherRequ = otherRequ == null ? null : otherRequ.trim();
    }

    public boolean getExpertConsult() {
        return expertConsult;
    }

    public void setExpertConsult(boolean expertConsult) {
        this.expertConsult = expertConsult;
    }

    public String getExpertConsultIntro() {
        return expertConsultIntro;
    }

    public void setExpertConsultIntro(String expertConsultIntro) {
        this.expertConsultIntro = expertConsultIntro == null ? null : expertConsultIntro.trim();
    }

    public Double getServeMoney() {
        return serveMoney;
    }

    public void setServeMoney(Double serveMoney) {
        this.serveMoney = serveMoney;
    }

    public String getMaterialTypeIds() {
        return materialTypeIds;
    }

    public void setMaterialTypeIds(String materialTypeIds) {
        this.materialTypeIds = materialTypeIds == null ? null : materialTypeIds.trim();
    }

    public String getMaterialTypeNames() {
        return materialTypeNames;
    }

    public void setMaterialTypeNames(String materialTypeNames) {
        this.materialTypeNames = materialTypeNames == null ? null : materialTypeNames.trim();
    }

    public String getProductIds() {
        return productIds;
    }

    public void setProductIds(String productIds) {
        this.productIds = productIds == null ? null : productIds.trim();
    }

    public String getProductNames() {
        return productNames;
    }

    public void setProductNames(String productNames) {
        this.productNames = productNames == null ? null : productNames.trim();
    }

    public String getProdTypeIds() {
        return prodTypeIds;
    }

    public void setProdTypeIds(String prodTypeIds) {
        this.prodTypeIds = prodTypeIds == null ? null : prodTypeIds.trim();
    }

    public String getProdTypeNames() {
        return prodTypeNames;
    }

    public void setProdTypeNames(String prodTypeNames) {
        this.prodTypeNames = prodTypeNames == null ? null : prodTypeNames.trim();
    }

    public String getRecommendTrade() {
        return recommendTrade;
    }

    public void setRecommendTrade(String recommendTrade) {
        this.recommendTrade = recommendTrade == null ? null : recommendTrade.trim();
    }
}