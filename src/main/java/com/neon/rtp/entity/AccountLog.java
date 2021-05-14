//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.neon.rtp.entity;






import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



public class AccountLog implements Serializable {


    private Long id;

    private String accountLogNo;

    private String orderNo;

    private Long userId;

    private BigDecimal beforeBalance;

    private BigDecimal afterBalance;

    private BigDecimal money;

    private Date addTime;

    private Integer costType;

    private Integer payType;

    private String payNo;

    private BigDecimal beforeRealBalance;

    private BigDecimal afterRealBalance;

    private Integer source;

    private Integer thirdpartPayWay;

    private String thirdpartAppid;

    private String extend;

    private static final long serialVersionUID = 7385999541103389065L;

    public AccountLog() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountLogNo() {
        return this.accountLogNo;
    }

    public void setAccountLogNo(String accountLogNo) {
        this.accountLogNo = accountLogNo == null ? null : accountLogNo.trim();
    }

    public String getOrderNo() {
        return this.orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public BigDecimal getBeforeBalance() {
        return this.beforeBalance;
    }

    public void setBeforeBalance(BigDecimal beforeBalance) {
        this.beforeBalance = beforeBalance;
    }

    public BigDecimal getAfterBalance() {
        return this.afterBalance;
    }

    public void setAfterBalance(BigDecimal afterBalance) {
        this.afterBalance = afterBalance;
    }

    public BigDecimal getMoney() {
        return this.money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Date getAddTime() {
        return this.addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Integer getCostType() {
        return this.costType;
    }

    public void setCostType(Integer costType) {
        this.costType = costType;
    }

    public Integer getPayType() {
        return this.payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getPayNo() {
        return this.payNo;
    }

    public void setPayNo(String payNo) {
        this.payNo = payNo == null ? null : payNo.trim();
    }

    public BigDecimal getBeforeRealBalance() {
        return this.beforeRealBalance;
    }

    public void setBeforeRealBalance(BigDecimal beforeRealBalance) {
        this.beforeRealBalance = beforeRealBalance;
    }

    public BigDecimal getAfterRealBalance() {
        return this.afterRealBalance;
    }

    public void setAfterRealBalance(BigDecimal afterRealBalance) {
        this.afterRealBalance = afterRealBalance;
    }

    public Integer getSource() {
        return this.source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public Integer getThirdpartPayWay() {
        return this.thirdpartPayWay;
    }

    public void setThirdpartPayWay(Integer thirdpartPayWay) {
        this.thirdpartPayWay = thirdpartPayWay;
    }

    public String getThirdpartAppid() {
        return this.thirdpartAppid;
    }

    public void setThirdpartAppid(String thirdpartAppid) {
        this.thirdpartAppid = thirdpartAppid == null ? null : thirdpartAppid.trim();
    }

    public String getExtend() {
        return this.extend;
    }

    public void setExtend(String extend) {
        this.extend = extend == null ? null : extend.trim();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(this.hashCode());
        sb.append(", id=").append(this.id);
        sb.append(", accountLogNo=").append(this.accountLogNo);
        sb.append(", orderNo=").append(this.orderNo);
        sb.append(", userId=").append(this.userId);
        sb.append(", beforeBalance=").append(this.beforeBalance);
        sb.append(", afterBalance=").append(this.afterBalance);
        sb.append(", money=").append(this.money);
        sb.append(", addTime=").append(this.addTime);
        sb.append(", costType=").append(this.costType);
        sb.append(", payType=").append(this.payType);
        sb.append(", payNo=").append(this.payNo);
        sb.append(", beforeRealBalance=").append(this.beforeRealBalance);
        sb.append(", afterRealBalance=").append(this.afterRealBalance);
        sb.append(", source=").append(this.source);
        sb.append(", thirdpartPayWay=").append(this.thirdpartPayWay);
        sb.append(", thirdpartAppid=").append(this.thirdpartAppid);
        sb.append(", extend=").append(this.extend);
        sb.append("]");
        return sb.toString();
    }
}
