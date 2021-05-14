//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.neon.rtp.entity;






import java.io.Serializable;
import java.util.Date;
import java.util.List;



public class CarReport implements Serializable {

    private static final long serialVersionUID = 1L;


    private long id;

    private String reportNo;

    private String vin;

    private Date licensePlateDate;

    private String carOwner;

    private Integer transferOwnerTimes;

    private int breakRules;

    private String engineNo;

    private String productionArea;

    private String effluentStandard;

    private String carUseNature;

    private String color;

    private String canMoveArea;

    private int accidentRisk;

    private int burnRisk;

    private int bubbleRisk;

    private int pledgeRisk;

    private int stealRisk;

    private long lastMileage;

    private long maximumMileage;

    private long maintainTimes;

    private int inDangerTimes;

    private long normalRepairTimes;

    private long accidentRepairTimes;

    private String recallRecord;

    private String maintainRecord;

    private String normalRepairRecord;

    private String sprayRepairRecord;

    private Date makeReportDate;

    private Date addTime;

    private String brand;

    private String seriesName;

    private String modelName;

    private String gearBox;

    private Date makeDate;

    private Date qaDate;

    private String extend;

    private List<RepairRecord> repairRecords;

    public CarReport() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getReportNo() {
        return this.reportNo;
    }

    public void setReportNo(String reportNo) {
        this.reportNo = reportNo;
    }

    public String getVin() {
        return this.vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Date getLicensePlateDate() {
        return this.licensePlateDate;
    }

    public void setLicensePlateDate(Date licensePlateDate) {
        this.licensePlateDate = licensePlateDate;
    }

    public String getCarOwner() {
        return this.carOwner;
    }

    public void setCarOwner(String carOwner) {
        this.carOwner = carOwner;
    }

    public Integer getTransferOwnerTimes() {
        return this.transferOwnerTimes;
    }

    public void setTransferOwnerTimes(Integer transferOwnerTimes) {
        this.transferOwnerTimes = transferOwnerTimes;
    }

    public int getBreakRules() {
        return this.breakRules;
    }

    public void setBreakRules(int breakRules) {
        this.breakRules = breakRules;
    }

    public String getEngineNo() {
        return this.engineNo;
    }

    public void setEngineNo(String engineNo) {
        this.engineNo = engineNo;
    }

    public String getProductionArea() {
        return this.productionArea;
    }

    public void setProductionArea(String productionArea) {
        this.productionArea = productionArea;
    }

    public String getEffluentStandard() {
        return this.effluentStandard;
    }

    public void setEffluentStandard(String effluentStandard) {
        this.effluentStandard = effluentStandard;
    }

    public String getCarUseNature() {
        return this.carUseNature;
    }

    public void setCarUseNature(String carUseNature) {
        this.carUseNature = carUseNature;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCanMoveArea() {
        return this.canMoveArea;
    }

    public void setCanMoveArea(String canMoveArea) {
        this.canMoveArea = canMoveArea;
    }

    public int getAccidentRisk() {
        return this.accidentRisk;
    }

    public void setAccidentRisk(int accidentRisk) {
        this.accidentRisk = accidentRisk;
    }

    public int getBurnRisk() {
        return this.burnRisk;
    }

    public void setBurnRisk(int burnRisk) {
        this.burnRisk = burnRisk;
    }

    public int getBubbleRisk() {
        return this.bubbleRisk;
    }

    public void setBubbleRisk(int bubbleRisk) {
        this.bubbleRisk = bubbleRisk;
    }

    public int getPledgeRisk() {
        return this.pledgeRisk;
    }

    public void setPledgeRisk(int pledgeRisk) {
        this.pledgeRisk = pledgeRisk;
    }

    public int getStealRisk() {
        return this.stealRisk;
    }

    public void setStealRisk(int stealRisk) {
        this.stealRisk = stealRisk;
    }

    public long getLastMileage() {
        return this.lastMileage;
    }

    public void setLastMileage(long lastMileage) {
        this.lastMileage = lastMileage;
    }

    public long getMaximumMileage() {
        return this.maximumMileage;
    }

    public void setMaximumMileage(long maximumMileage) {
        this.maximumMileage = maximumMileage;
    }

    public long getMaintainTimes() {
        return this.maintainTimes;
    }

    public void setMaintainTimes(long maintainTimes) {
        this.maintainTimes = maintainTimes;
    }

    public int getInDangerTimes() {
        return this.inDangerTimes;
    }

    public void setInDangerTimes(int inDangerTimes) {
        this.inDangerTimes = inDangerTimes;
    }

    public long getNormalRepairTimes() {
        return this.normalRepairTimes;
    }

    public void setNormalRepairTimes(long normalRepairTimes) {
        this.normalRepairTimes = normalRepairTimes;
    }

    public long getAccidentRepairTimes() {
        return this.accidentRepairTimes;
    }

    public void setAccidentRepairTimes(long accidentRepairTimes) {
        this.accidentRepairTimes = accidentRepairTimes;
    }

    public String getRecallRecord() {
        return this.recallRecord;
    }

    public void setRecallRecord(String recallRecord) {
        this.recallRecord = recallRecord;
    }

    public String getMaintainRecord() {
        return this.maintainRecord;
    }

    public void setMaintainRecord(String maintainRecord) {
        this.maintainRecord = maintainRecord;
    }

    public String getNormalRepairRecord() {
        return this.normalRepairRecord;
    }

    public void setNormalRepairRecord(String normalRepairRecord) {
        this.normalRepairRecord = normalRepairRecord;
    }

    public String getSprayRepairRecord() {
        return this.sprayRepairRecord;
    }

    public void setSprayRepairRecord(String sprayRepairRecord) {
        this.sprayRepairRecord = sprayRepairRecord;
    }

    public Date getMakeReportDate() {
        return this.makeReportDate;
    }

    public void setMakeReportDate(Date makeReportDate) {
        this.makeReportDate = makeReportDate;
    }

    public Date getAddTime() {
        return this.addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSeriesName() {
        return this.seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public String getModelName() {
        return this.modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getGearBox() {
        return this.gearBox;
    }

    public void setGearBox(String gearBox) {
        this.gearBox = gearBox;
    }

    public Date getMakeDate() {
        return this.makeDate;
    }

    public void setMakeDate(Date makeDate) {
        this.makeDate = makeDate;
    }

    public Date getQaDate() {
        return this.qaDate;
    }

    public void setQaDate(Date qaDate) {
        this.qaDate = qaDate;
    }

    public String getExtend() {
        return this.extend;
    }

    public void setExtend(String extend) {
        this.extend = extend;
    }

    public List<RepairRecord> getRepairRecords() {
        return this.repairRecords;
    }

    public void setRepairRecords(List<RepairRecord> repairRecords) {
        this.repairRecords = repairRecords;
    }
}
