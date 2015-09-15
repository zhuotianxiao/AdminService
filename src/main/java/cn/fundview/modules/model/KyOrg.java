package cn.fundview.modules.model;

import cn.fundview.common.persistence.DataEntity;

public class KyOrg extends DataEntity<KyOrg>{

	private static final long serialVersionUID = -2588375545451088930L;

	private String name;

    private String logo;

    private String tel;

    private String linkman;

    private String linkmanPhone;

    private String addr;

    private String email;

    private String website;

    private String service;

    private String areaNames;

    private String areaIds;

    private Byte recommend;

    private Byte hot;

    private Byte latest;

    private Integer recommendNum;

    private Integer hotNum;

    private Integer latestNum;

    private String choose;

    private Byte telShow;

    private String collaborateComp;

    private String successfulCase;

    private String intro;

    public String getLinkmanPosition() {
        return linkmanPosition;
    }

    public void setLinkmanPosition(String linkmanPosition) {
        this.linkmanPosition = linkmanPosition;
    }

    private String linkmanPosition;
    
    private Account account;
    
    public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo == null ? null : logo.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman == null ? null : linkman.trim();
    }

    public String getLinkmanPhone() {
        return linkmanPhone;
    }

    public void setLinkmanPhone(String linkmanPhone) {
        this.linkmanPhone = linkmanPhone == null ? null : linkmanPhone.trim();
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr == null ? null : addr.trim();
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

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service == null ? null : service.trim();
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


    public Byte getRecommend() {
        return recommend;
    }

    public void setRecommend(Byte recommend) {
        this.recommend = recommend;
    }

    public Byte getHot() {
        return hot;
    }

    public void setHot(Byte hot) {
        this.hot = hot;
    }

    public Byte getLatest() {
        return latest;
    }

    public void setLatest(Byte latest) {
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

    public String getChoose() {
        return choose;
    }

    public void setChoose(String choose) {
        this.choose = choose == null ? null : choose.trim();
    }

    public Byte getTelShow() {
        return telShow;
    }

    public void setTelShow(Byte telShow) {
        this.telShow = telShow;
    }

    public String getCollaborateComp() {
        return collaborateComp;
    }

    public void setCollaborateComp(String collaborateComp) {
        this.collaborateComp = collaborateComp == null ? null : collaborateComp.trim();
    }

    public String getSuccessfulCase() {
        return successfulCase;
    }

    public void setSuccessfulCase(String successfulCase) {
        this.successfulCase = successfulCase == null ? null : successfulCase.trim();
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro == null ? null : intro.trim();
    }
}