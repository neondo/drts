package com.neon.rtp.model;

/**
 * @author Neon
 * @date 2021/5/14 17:00
 */
public class OrderInfo{

    private String orderNo;

    private Integer orderType;

    private Integer orderStatus;

    private String brandName;

    private Long total;

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
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

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    @Override public String toString() {
        return "OrderInfo{" +
                "brandName='" + brandName + '\'' +
                ", orderNo='" + orderNo + '\'' +
                ", orderStatus=" + orderStatus +
                ", orderType=" + orderType +
                ", total=" + total +
                '}';
    }
}
