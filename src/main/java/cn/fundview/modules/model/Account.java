package cn.fundview.modules.model;

import cn.fundview.common.persistence.DataEntity;

import java.util.Date;

/**
 * 平台 账户
 *    
 * 项目名称：AdminService   
 * 类名称：Account   
 * 类描述：   
 * 创建人：lict   
 * 创建时间：2015年9月8日 上午11:40:37   
 * 修改人：lict    
 * 修改时间：2015年9月8日 上午11:40:37   
 * 修改备注：   
 * @version    
 *
 */
public class Account extends DataEntity<Account>{

    private String username;

    private String password;

    private Integer type;

    private String autoLoginCode;

    private boolean valid;

    private boolean isAuth;

    private Date lastLoginTime;

    private Integer dataId;

    private boolean emailChecked;

    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getAutoLoginCode() {
        return autoLoginCode;
    }

    public void setAutoLoginCode(String autoLoginCode) {
        this.autoLoginCode = autoLoginCode == null ? null : autoLoginCode.trim();
    }

    public boolean getValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public boolean getIsAuth() {
        return isAuth;
    }

    public void setIsAuth(boolean isAuth) {
        this.isAuth = isAuth;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }


    public Integer getDataId() {
        return dataId;
    }

    public void setDataId(Integer dataId) {
        this.dataId = dataId;
    }

    public boolean getEmailChecked() {
        return emailChecked;
    }

    public void setEmailChecked(boolean emailChecked) {
        this.emailChecked = emailChecked;
    }
}