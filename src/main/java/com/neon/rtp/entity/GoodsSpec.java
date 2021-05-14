//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.neon.rtp.entity;






import java.io.Serializable;
import java.util.Date;



public class GoodsSpec implements Serializable {


    private Long id;

    private String specNo;

    private String specName;

    private Integer specType;

    private Integer fillType;

    private String specValues;

    private Date addTime;

    private Date updateTime;

    private Boolean deleted;

    private String remark;

    private static final long serialVersionUID = 1L;

    public GoodsSpec() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpecNo() {
        return this.specNo;
    }

    public void setSpecNo(String specNo) {
        this.specNo = specNo == null ? null : specNo.trim();
    }

    public String getSpecName() {
        return this.specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName == null ? null : specName.trim();
    }

    public Integer getSpecType() {
        return this.specType;
    }

    public void setSpecType(Integer specType) {
        this.specType = specType;
    }

    public Integer getFillType() {
        return this.fillType;
    }

    public void setFillType(Integer fillType) {
        this.fillType = fillType;
    }

    public String getSpecValues() {
        return this.specValues;
    }

    public void setSpecValues(String specValues) {
        this.specValues = specValues == null ? null : specValues.trim();
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

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(this.hashCode());
        sb.append(", id=").append(this.id);
        sb.append(", specNo=").append(this.specNo);
        sb.append(", specName=").append(this.specName);
        sb.append(", specType=").append(this.specType);
        sb.append(", fillType=").append(this.fillType);
        sb.append(", specValues=").append(this.specValues);
        sb.append(", addTime=").append(this.addTime);
        sb.append(", updateTime=").append(this.updateTime);
        sb.append(", deleted=").append(this.deleted);
        sb.append(", remark=").append(this.remark);
        sb.append("]");
        return sb.toString();
    }
}
