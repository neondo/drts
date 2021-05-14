//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.neon.rtp.entity;






import java.io.Serializable;
import java.util.Date;



public class GoodsSpecValue implements Serializable {


    private Long id;

    private Long specId;

    private String specValue;

    private String sysValue1;

    private String sysValue2;

    private String sysValue3;

    private Date addTime;

    private Date updateTime;

    private Boolean deleted;

    private Boolean sysOption;

    private static final long serialVersionUID = 1L;

    public GoodsSpecValue() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSpecId() {
        return this.specId;
    }

    public void setSpecId(Long specId) {
        this.specId = specId;
    }

    public String getSpecValue() {
        return this.specValue;
    }

    public void setSpecValue(String specValue) {
        this.specValue = specValue == null ? null : specValue.trim();
    }

    public String getSysValue1() {
        return this.sysValue1;
    }

    public void setSysValue1(String sysValue1) {
        this.sysValue1 = sysValue1 == null ? null : sysValue1.trim();
    }

    public String getSysValue2() {
        return this.sysValue2;
    }

    public void setSysValue2(String sysValue2) {
        this.sysValue2 = sysValue2 == null ? null : sysValue2.trim();
    }

    public String getSysValue3() {
        return this.sysValue3;
    }

    public void setSysValue3(String sysValue3) {
        this.sysValue3 = sysValue3 == null ? null : sysValue3.trim();
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

    public Boolean getSysOption() {
        return this.sysOption;
    }

    public void setSysOption(Boolean sysOption) {
        this.sysOption = sysOption;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(this.hashCode());
        sb.append(", id=").append(this.id);
        sb.append(", specId=").append(this.specId);
        sb.append(", specValue=").append(this.specValue);
        sb.append(", sysValue1=").append(this.sysValue1);
        sb.append(", sysValue2=").append(this.sysValue2);
        sb.append(", sysValue3=").append(this.sysValue3);
        sb.append(", addTime=").append(this.addTime);
        sb.append(", updateTime=").append(this.updateTime);
        sb.append(", deleted=").append(this.deleted);
        sb.append(", sysOption=").append(this.sysOption);
        sb.append("]");
        return sb.toString();
    }
}
