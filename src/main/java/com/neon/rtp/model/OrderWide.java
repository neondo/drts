package com.neon.rtp.model;

import com.neon.rtp.entity.Order;
import com.neon.rtp.entity.OrderDetail;

import java.math.BigDecimal;

/**
 * @author Neon
 * @date 2021/5/14 11:50
 */
public class OrderWide{

    private final String carNo;

    private String orderNo;

    private BigDecimal money;

    private Long userId;

    private Long brandId;

    private Integer orderType;

    private Integer orderStatus;

    private String vin;

    private String brandName;

    private String cityName;

    private Long cityId;

    @Override public String toString() {
        return "OrderWide{" +
                "carNo='" + carNo + '\'' +
                ", orderNo='" + orderNo + '\'' +
                ", money=" + money +
                ", userId=" + userId +
                ", brandId=" + brandId +
                ", orderType=" + orderType +
                ", orderStatus=" + orderStatus +
                ", vin='" + vin + '\'' +
                ", brandName='" + brandName + '\'' +
                ", cityName='" + cityName + '\'' +
                ", cityId=" + cityId +
                '}';
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public OrderWide(Order order, OrderDetail orderDetail) {
        this.orderNo = order.getOrderNo();
        this.orderNo = order.getVin();
        this.carNo = orderDetail.getCarNo();
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getCarNo() {
        return carNo;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandName() {
        return brandName;
    }
}

