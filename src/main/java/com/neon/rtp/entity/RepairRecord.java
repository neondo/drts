//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.neon.rtp.entity;

import java.io.Serializable;
import java.util.Date;

public class RepairRecord implements Serializable{

    private static final long serialVersionUID = 2916326593892326384L;

    private long id;

    private String vin;

    private Date addTime;

    private String material;

    private String repairType;

    private Date repairBeginDate;

    private Date repairFinishDate;

    private int mileage;

    private double repairHour;

    private Double totalMoney;

    private String manHourName;

    private String troubleDescription;

    private String troubleReason;

    private String extend;

    public RepairRecord() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getVin() {
        return this.vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Date getAddTime() {
        return this.addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getMaterial() {
        return this.material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getRepairType() {
        return this.repairType;
    }

    public void setRepairType(String repairType) {
        this.repairType = repairType;
    }

    public Date getRepairBeginDate() {
        return this.repairBeginDate;
    }

    public void setRepairBeginDate(Date repairBeginDate) {
        this.repairBeginDate = repairBeginDate;
    }

    public Date getRepairFinishDate() {
        return this.repairFinishDate;
    }

    public void setRepairFinishDate(Date repairFinishDate) {
        this.repairFinishDate = repairFinishDate;
    }

    public int getMileage() {
        return this.mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public double getRepairHour() {
        return this.repairHour;
    }

    public void setRepairHour(double repairHour) {
        this.repairHour = repairHour;
    }

    public Double getTotalMoney() {
        return this.totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getManHourName() {
        return this.manHourName;
    }

    public void setManHourName(String manHourName) {
        this.manHourName = manHourName;
    }

    public String getTroubleDescription() {
        return this.troubleDescription;
    }

    public void setTroubleDescription(String troubleDescription) {
        this.troubleDescription = troubleDescription;
    }

    public String getTroubleReason() {
        return this.troubleReason;
    }

    public void setTroubleReason(String troubleReason) {
        this.troubleReason = troubleReason;
    }

    public String getExtend() {
        return this.extend;
    }

    public void setExtend(String extend) {
        this.extend = extend;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("RepairRecord{");
        sb.append("id=").append(this.id);
        sb.append(", vin='").append(this.vin).append('\'');
        sb.append(", addTime=").append(this.addTime);
        sb.append(", material='").append(this.material).append('\'');
        sb.append(", repairType='").append(this.repairType).append('\'');
        sb.append(", repairBeginDate=").append(this.repairBeginDate);
        sb.append(", repairFinishDate=").append(this.repairFinishDate);
        sb.append(", mileage=").append(this.mileage);
        sb.append(", repairHour=").append(this.repairHour);
        sb.append(", totalMoney=").append(this.totalMoney);
        sb.append(", manHourName='").append(this.manHourName).append('\'');
        sb.append(", troubleDescription='").append(this.troubleDescription).append('\'');
        sb.append(", troubleReason='").append(this.troubleReason).append('\'');
        sb.append(", extend='").append(this.extend).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
