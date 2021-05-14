//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.neon.rtp.entity;

import com.alibaba.fastjson.annotation.JSONField;





import java.io.Serializable;
import java.util.Date;
import java.util.List;



public class CarInfo implements Serializable {

    private static final long serialVersionUID = 1L;


    private long id;

    private String vin;

    private String licensePlate;

    private String engineNo;

    private String brand;

    private String seriesName;

    private String modelName;

    private String productionArea;

    private Date buyDate;

    private Date makeDate;

    private Date licensePlateDate;

    private String licensePlateArea;

    private Integer transferOwnerTimes;

    private String effluentStandard;

    private String carUseNature;

    private String color;

    private String gearBox;

    private Date qaDate;

    private String configuration;

    private String extend;

    private String manufacturer;

    private String engineCylinder;

    private String displacement;

    private String engineModel;

    private String transmissionType;

    private String gearsNumber;

    private String driveType;

    private String fueloilNumber;

    private String fueloilType;

    private String carBodyForm;

    private String carLevel;

    private String carType;

    private Boolean disable;

    private String year;

    private Integer source;

    private List<RepairRecord> repairRecords;

    private String articleIds;

    private Date addTime;

    private Date updateTime;

    private Long supportBrandId;
    @JSONField(
        name = "thirdparty_id"
    )

    private String thirdpartId;
    @JSONField(
        name = "thirdparty_name"
    )

    private String thirdpartName;

    public CarInfo() {
    }

    public CarInfo(String vin) {
        this(vin, (String)null);
    }

    public CarInfo(String vin, String brand) {
        this(vin, brand, (String)null);
    }

    public CarInfo(String vin, String brand, String manufacturer) {
        this.vin = vin;
        this.brand = brand;
        this.manufacturer = manufacturer;
    }

    public List<RepairRecord> getRepairRecords() {
        return this.repairRecords;
    }

    public void setRepairRecords(List<RepairRecord> repairRecords) {
        this.repairRecords = repairRecords;
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

    public String getLicensePlate() {
        return this.licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getEngineNo() {
        return this.engineNo;
    }

    public void setEngineNo(String engineNo) {
        this.engineNo = engineNo;
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

    public String getProductionArea() {
        return this.productionArea;
    }

    public void setProductionArea(String productionArea) {
        this.productionArea = productionArea;
    }

    public Date getBuyDate() {
        return this.buyDate;
    }

    public void setBuyDate(Date buyDate) {
        this.buyDate = buyDate;
    }

    public Date getMakeDate() {
        return this.makeDate;
    }

    public void setMakeDate(Date makeDate) {
        this.makeDate = makeDate;
    }

    public Date getLicensePlateDate() {
        return this.licensePlateDate;
    }

    public void setLicensePlateDate(Date licensePlateDate) {
        this.licensePlateDate = licensePlateDate;
    }

    public void setLicensePlateArea(String licensePlateArea) {
        this.licensePlateArea = licensePlateArea;
    }

    public String getLicensePlateArea() {
        return this.licensePlateArea;
    }

    public Integer getTransferOwnerTimes() {
        return this.transferOwnerTimes;
    }

    public void setTransferOwnerTimes(Integer transferOwnerTimes) {
        this.transferOwnerTimes = transferOwnerTimes;
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

    public String getGearBox() {
        return this.gearBox;
    }

    public void setGearBox(String gearBox) {
        this.gearBox = gearBox;
    }

    public Date getQaDate() {
        return this.qaDate;
    }

    public void setQaDate(Date qaDate) {
        this.qaDate = qaDate;
    }

    public String getConfiguration() {
        return this.configuration;
    }

    public void setConfiguration(String configuration) {
        this.configuration = configuration;
    }

    public String getExtend() {
        return this.extend;
    }

    public void setExtend(String extend) {
        this.extend = extend;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getEngineCylinder() {
        return this.engineCylinder;
    }

    public void setEngineCylinder(String engineCylinder) {
        this.engineCylinder = engineCylinder;
    }

    public String getDisplacement() {
        return this.displacement;
    }

    public void setDisplacement(String displacement) {
        this.displacement = displacement;
    }

    public String getEngineModel() {
        return this.engineModel;
    }

    public void setEngineModel(String engineModel) {
        this.engineModel = engineModel;
    }

    public String getTransmissionType() {
        return this.transmissionType;
    }

    public void setTransmissionType(String transmissionType) {
        this.transmissionType = transmissionType;
    }

    public String getGearsNumber() {
        return this.gearsNumber;
    }

    public void setGearsNumber(String gearsNumber) {
        this.gearsNumber = gearsNumber;
    }

    public String getDriveType() {
        return this.driveType;
    }

    public void setDriveType(String driveType) {
        this.driveType = driveType;
    }

    public Boolean getDisable() {
        return this.disable;
    }

    public void setDisable(Boolean disable) {
        this.disable = disable;
    }

    public String getFueloilNumber() {
        return this.fueloilNumber;
    }

    public void setFueloilNumber(String fueloilNumber) {
        this.fueloilNumber = fueloilNumber;
    }

    public String getFueloilType() {
        return this.fueloilType;
    }

    public void setFueloilType(String fueloilType) {
        this.fueloilType = fueloilType;
    }

    public String getCarBodyForm() {
        return this.carBodyForm;
    }

    public void setCarBodyForm(String carBodyForm) {
        this.carBodyForm = carBodyForm;
    }

    public String getCarLevel() {
        return this.carLevel;
    }

    public void setCarLevel(String carLevel) {
        this.carLevel = carLevel;
    }

    public String getCarType() {
        return this.carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getYear() {
        return this.year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getArticleIds() {
        return this.articleIds;
    }

    public void setArticleIds(String articleIds) {
        this.articleIds = articleIds;
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

    public Integer getSource() {
        return this.source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public Long getSupportBrandId() {
        return this.supportBrandId;
    }

    public void setSupportBrandId(Long supportBrandId) {
        this.supportBrandId = supportBrandId;
    }

    public String getThirdpartId() {
        return this.thirdpartId;
    }

    public void setThirdpartId(String thirdpartId) {
        this.thirdpartId = thirdpartId;
    }

    public String getThirdpartName() {
        return this.thirdpartName;
    }

    public void setThirdpartName(String thirdpartName) {
        this.thirdpartName = thirdpartName;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("CarInfo{");
        sb.append("id=").append(this.id);
        sb.append(", vin='").append(this.vin).append('\'');
        sb.append(", licensePlate='").append(this.licensePlate).append('\'');
        sb.append(", engineNo='").append(this.engineNo).append('\'');
        sb.append(", brand='").append(this.brand).append('\'');
        sb.append(", seriesName='").append(this.seriesName).append('\'');
        sb.append(", modelName='").append(this.modelName).append('\'');
        sb.append(", productionArea='").append(this.productionArea).append('\'');
        sb.append(", buyDate=").append(this.buyDate);
        sb.append(", makeDate=").append(this.makeDate);
        sb.append(", licensePlateDate=").append(this.licensePlateDate);
        sb.append(", licensePlateArea='").append(this.licensePlateArea).append('\'');
        sb.append(", transferOwnerTimes=").append(this.transferOwnerTimes);
        sb.append(", effluentStandard='").append(this.effluentStandard).append('\'');
        sb.append(", carUseNature='").append(this.carUseNature).append('\'');
        sb.append(", color='").append(this.color).append('\'');
        sb.append(", gearBox='").append(this.gearBox).append('\'');
        sb.append(", qaDate=").append(this.qaDate);
        sb.append(", configuration='").append(this.configuration).append('\'');
        sb.append(", extend='").append(this.extend).append('\'');
        sb.append(", manufacturer='").append(this.manufacturer).append('\'');
        sb.append(", engineCylinder='").append(this.engineCylinder).append('\'');
        sb.append(", displacement='").append(this.displacement).append('\'');
        sb.append(", engineModel='").append(this.engineModel).append('\'');
        sb.append(", transmissionType='").append(this.transmissionType).append('\'');
        sb.append(", gearsNumber='").append(this.gearsNumber).append('\'');
        sb.append(", driveType='").append(this.driveType).append('\'');
        sb.append(", fueloilNumber='").append(this.fueloilNumber).append('\'');
        sb.append(", fueloilType='").append(this.fueloilType).append('\'');
        sb.append(", carBodyForm='").append(this.carBodyForm).append('\'');
        sb.append(", carLevel='").append(this.carLevel).append('\'');
        sb.append(", carType='").append(this.carType).append('\'');
        sb.append(", disable=").append(this.disable);
        sb.append(", year='").append(this.year).append('\'');
        sb.append(", source=").append(this.source);
        sb.append(", repairRecords=").append(this.repairRecords);
        sb.append(", articleIds='").append(this.articleIds).append('\'');
        sb.append(", addTime=").append(this.addTime);
        sb.append(", updateTime=").append(this.updateTime);
        sb.append(", supportBrandId=").append(this.supportBrandId);
        sb.append(", thirdpartId='").append(this.thirdpartId).append('\'');
        sb.append(", thirdpartName='").append(this.thirdpartName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
