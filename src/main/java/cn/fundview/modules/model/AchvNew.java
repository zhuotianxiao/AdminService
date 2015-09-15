package cn.fundview.modules.model;

import java.util.Date;

import cn.fundview.common.persistence.DataEntity;

public class AchvNew extends DataEntity<AchvNew>{

	private static final long serialVersionUID = -7639014525497381491L;

    private String name;

    private String tradeIds;

    private String tradeNames;

    private String gyiHjie;

    private String otherGyiHjie;

    private Integer techJd;

    private Integer zlStatus;

    private String zlNo;

    private String zlUrl;

    private String dept;

    private String ownerName;

    private String phone;

    private String email;

    private String zrWay;

    private Double ptxkPrice;

    private Double zrPrice;

    private Integer publisherId;

    private Date publishDate;

    private String tags;

    private boolean recommend;

    private boolean hot;

    private boolean latest;

    private Integer recommendNum;

    private Integer hotNum;

    private Integer latestNum;

    private Integer status;

    private String no;

    private boolean valid;

    private Date updateTime;

    private boolean isPublish;

    private boolean isDelete;

    private Double ckPrice;

    private String applyCompName;

    private boolean isApply;

    private boolean isJd;

    private String jdUrl;

    private String materiIds;

    private String materiNames;

    private String prodTypeIds;

    private String prodTypeNames;

    private String majorProblemKey;

    private String evaluateOrgName;

    private String otherHzType;

    private String achvInventor;

    private Double unPtxkPrice;

    private Double delegatePrice;

    private Double unionPrice;

    private boolean alliance;

    private String acceptNo;

    private String acceptUrl;

    private boolean isAcceptAsk;

    private String askType;

    private Double servicePrice;

    private String materiTypeIds;

    private String materiTypeNames;

    private String prodIds;

    private String prodNames;

    private String recommendTrade;

    private String tradeChildIds;

    private String tradeChildNames;

    private String gyiHjieDesc;

    private String investGs;

    private String hardwareDesc;

    private String economyDesc;

    private String majorProblemIntro;

    private String otherHzDesc;

    private String achvCxInfo;
    
    private Expert expert;
    
    
    public Expert getExpert() {
		return expert;
	}

	public void setExpert(Expert expert) {
		this.expert = expert;
	}

	public String getGyiHjieDesc() {
        return gyiHjieDesc;
    }

    public void setGyiHjieDesc(String gyiHjieDesc) {
        this.gyiHjieDesc = gyiHjieDesc == null ? null : gyiHjieDesc.trim();
    }

    public String getInvestGs() {
        return investGs;
    }

    public void setInvestGs(String investGs) {
        this.investGs = investGs == null ? null : investGs.trim();
    }

    public String getHardwareDesc() {
        return hardwareDesc;
    }

    public void setHardwareDesc(String hardwareDesc) {
        this.hardwareDesc = hardwareDesc == null ? null : hardwareDesc.trim();
    }

    public String getEconomyDesc() {
        return economyDesc;
    }

    public void setEconomyDesc(String economyDesc) {
        this.economyDesc = economyDesc == null ? null : economyDesc.trim();
    }

    public String getMajorProblemIntro() {
        return majorProblemIntro;
    }

    public void setMajorProblemIntro(String majorProblemIntro) {
        this.majorProblemIntro = majorProblemIntro == null ? null : majorProblemIntro.trim();
    }

    public String getOtherHzDesc() {
        return otherHzDesc;
    }

    public void setOtherHzDesc(String otherHzDesc) {
        this.otherHzDesc = otherHzDesc == null ? null : otherHzDesc.trim();
    }

    public String getAchvCxInfo() {
        return achvCxInfo;
    }

    public void setAchvCxInfo(String achvCxInfo) {
        this.achvCxInfo = achvCxInfo == null ? null : achvCxInfo.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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

    public String getGyiHjie() {
        return gyiHjie;
    }

    public void setGyiHjie(String gyiHjie) {
        this.gyiHjie = gyiHjie == null ? null : gyiHjie.trim();
    }

    public String getOtherGyiHjie() {
        return otherGyiHjie;
    }

    public void setOtherGyiHjie(String otherGyiHjie) {
        this.otherGyiHjie = otherGyiHjie == null ? null : otherGyiHjie.trim();
    }

    public Integer getTechJd() {
        return techJd;
    }

    public void setTechJd(Integer techJd) {
        this.techJd = techJd;
    }

    public Integer getZlStatus() {
        return zlStatus;
    }

    public void setZlStatus(Integer zlStatus) {
        this.zlStatus = zlStatus;
    }

    public String getZlNo() {
        return zlNo;
    }

    public void setZlNo(String zlNo) {
        this.zlNo = zlNo == null ? null : zlNo.trim();
    }

    public String getZlUrl() {
        return zlUrl;
    }

    public void setZlUrl(String zlUrl) {
        this.zlUrl = zlUrl == null ? null : zlUrl.trim();
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept == null ? null : dept.trim();
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName == null ? null : ownerName.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getZrWay() {
        return zrWay;
    }

    public void setZrWay(String zrWay) {
        this.zrWay = zrWay == null ? null : zrWay.trim();
    }

    public Double getPtxkPrice() {
        return ptxkPrice;
    }

    public void setPtxkPrice(Double ptxkPrice) {
        this.ptxkPrice = ptxkPrice;
    }

    public Double getZrPrice() {
        return zrPrice;
    }

    public void setZrPrice(Double zrPrice) {
        this.zrPrice = zrPrice;
    }

    public Integer getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Integer publisherId) {
        this.publisherId = publisherId;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no == null ? null : no.trim();
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

    public boolean getIsPublish() {
        return isPublish;
    }

    public void setIsPublish(boolean isPublish) {
        this.isPublish = isPublish;
    }

    public boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }

    public Double getCkPrice() {
        return ckPrice;
    }

    public void setCkPrice(Double ckPrice) {
        this.ckPrice = ckPrice;
    }

    public String getApplyCompName() {
        return applyCompName;
    }

    public void setApplyCompName(String applyCompName) {
        this.applyCompName = applyCompName == null ? null : applyCompName.trim();
    }

    public boolean getIsApply() {
        return isApply;
    }

    public void setIsApply(boolean isApply) {
        this.isApply = isApply;
    }

    public boolean getIsJd() {
        return isJd;
    }

    public void setIsJd(boolean isJd) {
        this.isJd = isJd;
    }

    public String getJdUrl() {
        return jdUrl;
    }

    public void setJdUrl(String jdUrl) {
        this.jdUrl = jdUrl == null ? null : jdUrl.trim();
    }

    public String getMateriIds() {
        return materiIds;
    }

    public void setMateriIds(String materiIds) {
        this.materiIds = materiIds == null ? null : materiIds.trim();
    }

    public String getMateriNames() {
        return materiNames;
    }

    public void setMateriNames(String materiNames) {
        this.materiNames = materiNames == null ? null : materiNames.trim();
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

    public String getMajorProblemKey() {
        return majorProblemKey;
    }

    public void setMajorProblemKey(String majorProblemKey) {
        this.majorProblemKey = majorProblemKey == null ? null : majorProblemKey.trim();
    }

    public String getEvaluateOrgName() {
        return evaluateOrgName;
    }

    public void setEvaluateOrgName(String evaluateOrgName) {
        this.evaluateOrgName = evaluateOrgName == null ? null : evaluateOrgName.trim();
    }

    public String getOtherHzType() {
        return otherHzType;
    }

    public void setOtherHzType(String otherHzType) {
        this.otherHzType = otherHzType == null ? null : otherHzType.trim();
    }

    public String getAchvInventor() {
        return achvInventor;
    }

    public void setAchvInventor(String achvInventor) {
        this.achvInventor = achvInventor == null ? null : achvInventor.trim();
    }

    public Double getUnPtxkPrice() {
        return unPtxkPrice;
    }

    public void setUnPtxkPrice(Double unPtxkPrice) {
        this.unPtxkPrice = unPtxkPrice;
    }

    public Double getDelegatePrice() {
        return delegatePrice;
    }

    public void setDelegatePrice(Double delegatePrice) {
        this.delegatePrice = delegatePrice;
    }

    public Double getUnionPrice() {
        return unionPrice;
    }

    public void setUnionPrice(Double unionPrice) {
        this.unionPrice = unionPrice;
    }

    public boolean getAlliance() {
        return alliance;
    }

    public void setAlliance(boolean alliance) {
        this.alliance = alliance;
    }

    public String getAcceptNo() {
        return acceptNo;
    }

    public void setAcceptNo(String acceptNo) {
        this.acceptNo = acceptNo == null ? null : acceptNo.trim();
    }

    public String getAcceptUrl() {
        return acceptUrl;
    }

    public void setAcceptUrl(String acceptUrl) {
        this.acceptUrl = acceptUrl == null ? null : acceptUrl.trim();
    }

    public boolean getIsAcceptAsk() {
        return isAcceptAsk;
    }

    public void setIsAcceptAsk(boolean isAcceptAsk) {
        this.isAcceptAsk = isAcceptAsk;
    }

    public String getAskType() {
        return askType;
    }

    public void setAskType(String askType) {
        this.askType = askType == null ? null : askType.trim();
    }

    public Double getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(Double servicePrice) {
        this.servicePrice = servicePrice;
    }

    public String getMateriTypeIds() {
        return materiTypeIds;
    }

    public void setMateriTypeIds(String materiTypeIds) {
        this.materiTypeIds = materiTypeIds == null ? null : materiTypeIds.trim();
    }

    public String getMateriTypeNames() {
        return materiTypeNames;
    }

    public void setMateriTypeNames(String materiTypeNames) {
        this.materiTypeNames = materiTypeNames == null ? null : materiTypeNames.trim();
    }

    public String getProdIds() {
        return prodIds;
    }

    public void setProdIds(String prodIds) {
        this.prodIds = prodIds == null ? null : prodIds.trim();
    }

    public String getProdNames() {
        return prodNames;
    }

    public void setProdNames(String prodNames) {
        this.prodNames = prodNames == null ? null : prodNames.trim();
    }

    public String getRecommendTrade() {
        return recommendTrade;
    }

    public void setRecommendTrade(String recommendTrade) {
        this.recommendTrade = recommendTrade == null ? null : recommendTrade.trim();
    }

    public String getTradeChildIds() {
        return tradeChildIds;
    }

    public void setTradeChildIds(String tradeChildIds) {
        this.tradeChildIds = tradeChildIds == null ? null : tradeChildIds.trim();
    }

    public String getTradeChildNames() {
        return tradeChildNames;
    }

    public void setTradeChildNames(String tradeChildNames) {
        this.tradeChildNames = tradeChildNames == null ? null : tradeChildNames.trim();
    }
}