package cn.fundview.modules.model;

import cn.fundview.common.persistence.DataEntity;

public class Expert extends DataEntity<Expert>{
	
	private static final long serialVersionUID = -7639014525497381491L;

    private String no;
    
    private String name;

    private String logo;

    private String birthday;

    private Integer sex;

    private String addr;

    private Integer education;

    private String professionalTitle;

    private String tel;

    private String email;

    private String theUnit;

    private String tradeIds;

    private String tradeNames;

    private String tradeChildIds;

    private String tradeChildNames;

    private String areaNames;

    private String areaIds;

    private String tags;

    private Integer attentNum;

    private String specialty;

    private String phone;

    private boolean recommend;

    private boolean hot;

    private boolean latest;

    private Integer recommendNum;

    private Integer hotNum;

    private Integer latestNum;

    private Integer valid;

    private String mark;

    private String choose;

    private String department;

    private boolean telShow;

    private String wechat;

    private boolean compTariff;

    private Integer applyGuestExpertStatus;

    private Integer avgScore;

    private Integer expertType;

    private String recommendTrade;

    private String intro;

    private Account account;
    public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no == null ? null : no.trim();
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr == null ? null : addr.trim();
    }

    public Integer getEducation() {
        return education;
    }

    public void setEducation(Integer education) {
        this.education = education;
    }

    public String getProfessionalTitle() {
        return professionalTitle;
    }

    public void setProfessionalTitle(String professionalTitle) {
        this.professionalTitle = professionalTitle == null ? null : professionalTitle.trim();
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

    public String getTheUnit() {
        return theUnit;
    }

    public void setTheUnit(String theUnit) {
        this.theUnit = theUnit == null ? null : theUnit.trim();
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

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags == null ? null : tags.trim();
    }

    public Integer getAttentNum() {
        return attentNum;
    }

    public void setAttentNum(Integer attentNum) {
        this.attentNum = attentNum;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty == null ? null : specialty.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
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


    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }


    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark == null ? null : mark.trim();
    }

    public String getChoose() {
        return choose;
    }

    public void setChoose(String choose) {
        this.choose = choose == null ? null : choose.trim();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public boolean getTelShow() {
        return telShow;
    }

    public void setTelShow(boolean telShow) {
        this.telShow = telShow;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat == null ? null : wechat.trim();
    }

    public boolean getCompTariff() {
        return compTariff;
    }

    public void setCompTariff(boolean compTariff) {
        this.compTariff = compTariff;
    }

    public Integer getApplyGuestExpertStatus() {
        return applyGuestExpertStatus;
    }

    public void setApplyGuestExpertStatus(Integer applyGuestExpertStatus) {
        this.applyGuestExpertStatus = applyGuestExpertStatus;
    }

    public Integer getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(Integer avgScore) {
        this.avgScore = avgScore;
    }

    public Integer getExpertType() {
        return expertType;
    }

    public void setExpertType(Integer expertType) {
        this.expertType = expertType;
    }

    public String getRecommendTrade() {
        return recommendTrade;
    }

    public void setRecommendTrade(String recommendTrade) {
        this.recommendTrade = recommendTrade == null ? null : recommendTrade.trim();
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro == null ? null : intro.trim();
    }
}