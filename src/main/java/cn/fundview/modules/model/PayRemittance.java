package cn.fundview.modules.model;

import java.util.Date;

public class PayRemittance {
    private Integer id;

    private Integer payId;

    private String payCode;

    private String payCodePhone;

    private String payWay;

    private Date payDate;

    private String bankRunningNumber;

    private String payType;

    private String bankName;

    private Double money;

    private String remarks;

    private Date realPayDate;

    private PayMain payMain;

    public PayMain getPayMain() {
        return payMain;
    }

    public void setPayMain(PayMain payMain) {
        this.payMain = payMain;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPayId() {
        return payId;
    }

    public void setPayId(Integer payId) {
        this.payId = payId;
    }

    public String getPayCode() {
        return payCode;
    }

    public void setPayCode(String payCode) {
        this.payCode = payCode == null ? null : payCode.trim();
    }

    public String getPayCodePhone() {
        return payCodePhone;
    }

    public void setPayCodePhone(String payCodePhone) {
        this.payCodePhone = payCodePhone == null ? null : payCodePhone.trim();
    }

    public String getPayWay() {
        return payWay;
    }

    public void setPayWay(String payWay) {
        this.payWay = payWay == null ? null : payWay.trim();
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public String getBankRunningNumber() {
        return bankRunningNumber;
    }

    public void setBankRunningNumber(String bankRunningNumber) {
        this.bankRunningNumber = bankRunningNumber == null ? null : bankRunningNumber.trim();
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType == null ? null : payType.trim();
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public Date getRealPayDate() {
        return realPayDate;
    }

    public void setRealPayDate(Date realPayDate) {
        this.realPayDate = realPayDate;
    }
}