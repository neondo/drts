//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.neon.rtp.entity;






import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



public class GoodsSku implements Serializable {


    private Long id;

    private String skuNo;

    private String sysNo;

    private String skuName;

    private BigDecimal price;

    private Integer stock;

    private Long shopId;

    private Long shopSpuId;

    private Date addTime;

    private Date updateTime;

    private Boolean deleted;

    private Boolean defaultSku;

    private Boolean state;

    private Integer skuLevel;

    private String content;

    private static final long serialVersionUID = 1L;

    public GoodsSku() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSkuNo() {
        return this.skuNo;
    }

    public void setSkuNo(String skuNo) {
        this.skuNo = skuNo == null ? null : skuNo.trim();
    }

    public String getSysNo() {
        return this.sysNo;
    }

    public void setSysNo(String sysNo) {
        this.sysNo = sysNo == null ? null : sysNo.trim();
    }

    public String getSkuName() {
        return this.skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName == null ? null : skuName.trim();
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStock() {
        return this.stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Long getShopId() {
        return this.shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Long getShopSpuId() {
        return this.shopSpuId;
    }

    public void setShopSpuId(Long shopSpuId) {
        this.shopSpuId = shopSpuId;
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

    public Boolean getDefaultSku() {
        return this.defaultSku;
    }

    public void setDefaultSku(Boolean defaultSku) {
        this.defaultSku = defaultSku;
    }

    public Boolean getState() {
        return this.state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public Integer getSkuLevel() {
        return this.skuLevel;
    }

    public void setSkuLevel(Integer skuLevel) {
        this.skuLevel = skuLevel;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(this.hashCode());
        sb.append(", id=").append(this.id);
        sb.append(", skuNo=").append(this.skuNo);
        sb.append(", sysNo=").append(this.sysNo);
        sb.append(", skuName=").append(this.skuName);
        sb.append(", price=").append(this.price);
        sb.append(", stock=").append(this.stock);
        sb.append(", shopId=").append(this.shopId);
        sb.append(", shopSpuId=").append(this.shopSpuId);
        sb.append(", addTime=").append(this.addTime);
        sb.append(", updateTime=").append(this.updateTime);
        sb.append(", deleted=").append(this.deleted);
        sb.append(", defaultSku=").append(this.defaultSku);
        sb.append(", state=").append(this.state);
        sb.append(", skuLevel=").append(this.skuLevel);
        sb.append(", content=").append(this.content);
        sb.append("]");
        return sb.toString();
    }
}
