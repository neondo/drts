//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.neon.rtp.entity;






import java.io.Serializable;
import java.util.Date;



public class GoodsShop implements Serializable {


    private Long id;

    private String shopName;

    private String shopDesc;

    private Date addTime;

    private Date updateTime;

    private Boolean deleted;

    private static final long serialVersionUID = 1L;

    public GoodsShop() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShopName() {
        return this.shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopDesc() {
        return this.shopDesc;
    }

    public void setShopDesc(String shopDesc) {
        this.shopDesc = shopDesc;
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
        return "GoodsShop{id=" + this.id + ", shopName='" + this.shopName + '\'' + ", shopDesc='" + this.shopDesc + '\'' + ", addTime=" + this.addTime + ", updateTime=" + this.updateTime + ", deleted=" + this.deleted + '}';
    }
}
