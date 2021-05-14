package com.neon.rtp.model;

import java.math.BigDecimal;

/**
 * @author Neon
 * @date 2021/5/11 23:00
 */
public class OrderInfo{

    private Long orderId;

    private String orderNo;

    private BigDecimal realMoney;

    private BigDecimal standardMoney;

    private String couponNo;

    private String vin;

    private String orderType;

    private Integer orderStatus;

    private Long userId;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public BigDecimal getRealMoney() {
        return realMoney;
    }

    public void setRealMoney(BigDecimal realMoney) {
        this.realMoney = realMoney;
    }

    public BigDecimal getStandardMoney() {
        return standardMoney;
    }

    public void setStandardMoney(BigDecimal standardMoney) {
        this.standardMoney = standardMoney;
    }

    public String getCouponNo() {
        return couponNo;
    }

    public void setCouponNo(String couponNo) {
        this.couponNo = couponNo;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
