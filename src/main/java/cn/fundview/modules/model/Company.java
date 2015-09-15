package cn.fundview.modules.model;

import java.util.Date;

public class Company {
    private Integer accountId;

    private String no;

    private String logo;

    private String name;

    private String addr;

    private String areaNames;

    private String areaIds;

    private Float regCapital;

    private String regTime;

    private Integer regType;

    private String tel;

    private String email;

    private String website;

    private String info;

    private String tags;

    private String tradeIds;

    private String tradeNames;

    private Integer attentNum;

    private String phone;

    private String linkman;

    private String service;

    private boolean recommend;

    private boolean hot;

    private boolean latest;

    private Integer recommendNum;

    private Integer hotNum;

    private Integer latestNum;

    private Date createTime;

    private String ltqyType;

    private String employees;

    private String mainProducts;

    private Integer valid;

    private String tradeChildIds;

    private String tradeChildNames;

    private String recommendTrade;

    private Date updateTime;

    private String mark;

    private String orgCode;

    private String businessLicence;

    private Integer compAuth;

    private String choose;

    private Integer type;

    private boolean telShow;

    private String rawMateris;
    private Account account;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no == null ? null : no.trim();
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo == null ? null : logo.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr == null ? null : addr.trim();
    }

    public String getAreaNames() {
        return areaNames;
    }

    public void setAreaNames(String areaNames) {
        this.areaNames = areaNames == null ? null : areaNames.trim();
    }

    public String getAreaIds() {
        return areaIds;
    }

    public void setAreaIds(String areaIds) {
        this.areaIds = areaIds == null ? null : areaIds.trim();
    }

    public Float getRegCapital() {
        return regCapital;
    }

    public void setRegCapital(Float regCapital) {
        this.regCapital = regCapital;
    }

    public String getRegTime() {
        return regTime;
    }

    public void setRegTime(String regTime) {
        this.regTime = regTime == null ? null : regTime.trim();
    }

    public Integer getRegType() {
        return regType;
    }

    public void setRegType(Integer regType) {
        this.regType = regType;
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

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website == null ? null : website.trim();
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags == null ? null : tags.trim();
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

    public Integer getAttentNum() {
        return attentNum;
    }

    public void setAttentNum(Integer attentNum) {
        this.attentNum = attentNum;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman == null ? null : linkman.trim();
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service == null ? null : service.trim();
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getLtqyType() {
        return ltqyType;
    }

    public void setLtqyType(String ltqyType) {
        this.ltqyType = ltqyType == null ? null : ltqyType.trim();
    }

    public String getEmployees() {
        return employees;
    }

    public void setEmployees(String employees) {
        this.employees = employees == null ? null : employees.trim();
    }

    public String getMainProducts() {
        return mainProducts;
    }

    public void setMainProducts(String mainProducts) {
        this.mainProducts = mainProducts == null ? null : mainProducts.trim();
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
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

    public String getRecommendTrade() {
        return recommendTrade;
    }

    public void setRecommendTrade(String recommendTrade) {
        this.recommendTrade = recommendTrade == null ? null : recommendTrade.trim();
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

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode == null ? null : orgCode.trim();
    }

    public String getBusinessLicence() {
        return businessLicence;
    }

    public void setBusinessLicence(String businessLicence) {
        this.businessLicence = businessLicence == null ? null : businessLicence.trim();
    }

    public Integer getCompAuth() {
        return compAuth;
    }

    public void setCompAuth(Integer compAuth) {
        this.compAuth = compAuth;
    }

    public String getChoose() {
        return choose;
    }

    public void setChoose(String choose) {
        this.choose = choose == null ? null : choose.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public boolean getTelShow() {
        return telShow;
    }

    public void setTelShow(boolean telShow) {
        this.telShow = telShow;
    }

    public String getRawMateris() {
        return rawMateris;
    }

    public void setRawMateris(String rawMateris) {
        this.rawMateris = rawMateris == null ? null : rawMateris.trim();
    }
}