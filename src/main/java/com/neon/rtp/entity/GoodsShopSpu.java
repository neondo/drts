//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.neon.rtp.entity;






import java.io.Serializable;
import java.util.Date;



public class GoodsShopSpu implements Serializable {


    private Long id;

    private String shopSpuName;

    private Long shopId;

    private Long spuId;

    private Double price;

    private Date addTime;

    private Date updateTime;

    private Boolean deleted;

    private Integer shopSpuOrder;

    private Integer state;

    private Integer shopSpuType;

    private String description;

    private String thumb;

    private static final long serialVersionUID = 1L;

    public GoodsShopSpu() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShopSpuName() {
        return this.shopSpuName;
    }

    public void setShopSpuName(String shopSpuName) {
        this.shopSpuName = shopSpuName == null ? null : shopSpuName.trim();
    }

    public Long getShopId() {
        return this.shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Long getSpuId() {
        return this.spuId;
    }

    public void setSpuId(Long spuId) {
        this.spuId = spuId;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getAddTime() {
        return this.addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getDeleted() {
        return this.deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Integer getShopSpuOrder() {
        return this.shopSpuOrder;
    }

    public void setShopSpuOrder(Integer shopSpuOrder) {
        this.shopSpuOrder = shopSpuOrder;
    }

    public Integer getState() {
        return this.state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getShopSpuType() {
        return this.shopSpuType;
    }

    public void setShopSpuType(Integer shopSpuType) {
        this.shopSpuType = shopSpuType;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getThumb() {
        return this.thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb == null ? null : thumb.trim();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(this.hashCode());
        sb.append(", id=").append(this.id);
        sb.append(", shopSpuName=").append(this.shopSpuName);
        sb.append(", shopId=").append(this.shopId);
        sb.append(", spuId=").append(this.spuId);
        sb.append(", price=").append(this.price);
        sb.append(", addTime=").append(this.addTime);
        sb.append(", updateTime=").append(this.updateTime);
        sb.append(", deleted=").append(this.deleted);
        sb.append(", shopSpuOrder=").append(this.shopSpuOrder);
        sb.append(", state=").append(this.state);
        sb.append(", shopSpuType=").append(this.shopSpuType);
        sb.append(", description=").append(this.description);
        sb.append(", thumb=").append(this.thumb);
        sb.append("]");
        return sb.toString();
    }
}
