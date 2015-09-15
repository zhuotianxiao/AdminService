package cn.fundview.modules.web.vo;

import java.util.Date;

public class KyOrgVo implements java.io.Serializable {

	private Integer id;
	private String username;
	private String name;
	private String areaNames;
	private String phone;
	private String tel;
	private Date createTime;

	public Integer getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getName() {
		return name;
	}

	public String getAreaNames() {
		return areaNames;
	}

	public String getPhone() {
		return phone;
	}

	public String getTel() {
		return tel;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAreaNames(String areaNames) {
		this.areaNames = areaNames;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	
}