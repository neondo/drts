//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.neon.rtp.entity;






import java.io.Serializable;
import java.util.Date;



public class GoodsCategory implements Serializable {


    private Long id;

    private String categoryName;

    private Date addTime;

    private Date updateTime;

    private Boolean deleted;

    private static final long serialVersionUID = 1L;

    public GoodsCategory() {
    }

    public Boolean getDeleted() {
        return this.deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
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

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(this.hashCode());
        sb.append(", id=").append(this.id);
        sb.append(", categoryName=").append(this.categoryName);
        sb.append(", addTime=").append(this.addTime);
        sb.append(", updateTime=").append(this.updateTime);
        sb.append("]");
        return sb.toString();
    }
}
