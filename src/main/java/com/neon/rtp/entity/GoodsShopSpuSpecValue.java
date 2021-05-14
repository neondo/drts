//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.neon.rtp.entity;






import java.io.Serializable;
import java.util.Date;



public class GoodsShopSpuSpecValue implements Serializable {


    private Long id;

    private Long shopSpuId;

    private Long specId;

    private Long specValueId;

    private Date addTime;

    private Date updateTime;

    private Boolean deleted;

    private static final long serialVersionUID = 1L;

    public GoodsShopSpuSpecValue() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getShopSpuId() {
        return this.shopSpuId;
    }

    public void setShopSpuId(Long shopSpuId) {
        this.shopSpuId = shopSpuId;
    }

    public Long getSpecId() {
        return this.specId;
    }

    public void setSpecId(Long specId) {
        this.specId = specId;
    }

    public Long getSpecValueId() {
        return this.specValueId;
    }

    public void setSpecValueId(Long specValueId) {
        this.specValueId = specValueId;
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

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(this.hashCode());
        sb.append(", id=").append(this.id);
        sb.append(", shopSpuId=").append(this.shopSpuId);
        sb.append(", specValueId=").append(this.specValueId);
        sb.append(", addTime=").append(this.addTime);
        sb.append(", updateTime=").append(this.updateTime);
        sb.append(", deleted=").append(this.deleted);
        sb.append("]");
        return sb.toString();
    }
}
