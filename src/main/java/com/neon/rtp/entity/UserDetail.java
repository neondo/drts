//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.neon.rtp.entity;






import java.io.Serializable;
import java.util.Date;



public class UserDetail implements Serializable {


    private Long id;

    private Long userId;

    private String brandIds;

    private Double dailyAverageOrder;

    private Double dailyAverageSearch;

    private Double dailyAverageCharge;

    private String backupForbiddenSupportBrand;

    private String forbiddenSupportBrand;

    private Integer cityId;

    private String limitNum;

    private Integer mobileCityId;

    private String deviceNo;

    private Integer reportDays;

    private Integer reportVinTimes;

    private Date activeTime;

    private String carBusinessConfig;

    private String detectionOrderConfig;

    private String ldSwitch;

    private Boolean detectionReportDisplaySwitch;

    private Boolean detectionReportCallSwitch;

    private Long marketShopId;

    private String reportModel;

    private String extend;

    private static final long serialVersionUID = 8007553923523039412L;

    public UserDetail() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getBrandIds() {
        return this.brandIds;
    }

    public void setBrandIds(String brandIds) {
        this.brandIds = brandIds == null ? null : brandIds.trim();
    }

    public Double getDailyAverageOrder() {
        return this.dailyAverageOrder;
    }

    public void setDailyAverageOrder(Double dailyAverageOrder) {
        this.dailyAverageOrder = dailyAverageOrder;
    }

    public Double getDailyAverageSearch() {
        return this.dailyAverageSearch;
    }

    public void setDailyAverageSearch(Double dailyAverageSearch) {
        this.dailyAverageSearch = dailyAverageSearch;
    }

    public Double getDailyAverageCharge() {
        return this.dailyAverageCharge;
    }

    public void setDailyAverageCharge(Double dailyAverageCharge) {
        this.dailyAverageCharge = dailyAverageCharge;
    }

    public String getBackupForbiddenSupportBrand() {
        return this.backupForbiddenSupportBrand;
    }

    public void setBackupForbiddenSupportBrand(String backupForbiddenSupportBrand) {
        this.backupForbiddenSupportBrand = backupForbiddenSupportBrand == null ? null : backupForbiddenSupportBrand.trim();
    }

    public String getForbiddenSupportBrand() {
        return this.forbiddenSupportBrand;
    }

    public void setForbiddenSupportBrand(String forbiddenSupportBrand) {
        this.forbiddenSupportBrand = forbiddenSupportBrand == null ? null : forbiddenSupportBrand.trim();
    }

    public Integer getCityId() {
        return this.cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getLimitNum() {
        return this.limitNum;
    }

    public void setLimitNum(String limitNum) {
        this.limitNum = limitNum == null ? null : limitNum.trim();
    }

    public Integer getMobileCityId() {
        return this.mobileCityId;
    }

    public void setMobileCityId(Integer mobileCityId) {
        this.mobileCityId = mobileCityId;
    }

    public String getDeviceNo() {
        return this.deviceNo;
    }

    public void setDeviceNo(String deviceNo) {
        this.deviceNo = deviceNo == null ? null : deviceNo.trim();
    }

    public Integer getReportDays() {
        return this.reportDays;
    }

    public void setReportDays(Integer reportDays) {
        this.reportDays = reportDays;
    }

    public Integer getReportVinTimes() {
        return this.reportVinTimes;
    }

    public void setReportVinTimes(Integer reportVinTimes) {
        this.reportVinTimes = reportVinTimes;
    }

    public Date getActiveTime() {
        return this.activeTime;
    }

    public void setActiveTime(Date activeTime) {
        this.activeTime = activeTime;
    }

    public String getCarBusinessConfig() {
        return this.carBusinessConfig;
    }

    public void setCarBusinessConfig(String carBusinessConfig) {
        this.carBusinessConfig = carBusinessConfig == null ? null : carBusinessConfig.trim();
    }

    public String getDetectionOrderConfig() {
        return this.detectionOrderConfig;
    }

    public void setDetectionOrderConfig(String detectionOrderConfig) {
        this.detectionOrderConfig = detectionOrderConfig == null ? null : detectionOrderConfig.trim();
    }

    public String getLdSwitch() {
        return this.ldSwitch;
    }

    public void setLdSwitch(String ldSwitch) {
        this.ldSwitch = ldSwitch == null ? null : ldSwitch.trim();
    }

    public Boolean getDetectionReportDisplaySwitch() {
        return this.detectionReportDisplaySwitch;
    }

    public void setDetectionReportDisplaySwitch(Boolean detectionReportDisplaySwitch) {
        this.detectionReportDisplaySwitch = detectionReportDisplaySwitch;
    }

    public Boolean getDetectionReportCallSwitch() {
        return this.detectionReportCallSwitch;
    }

    public void setDetectionReportCallSwitch(Boolean detectionReportCallSwitch) {
        this.detectionReportCallSwitch = detectionReportCallSwitch;
    }

    public Long getMarketShopId() {
        return this.marketShopId;
    }

    public void setMarketShopId(Long marketShopId) {
        this.marketShopId = marketShopId;
    }

    public String getReportModel() {
        return this.reportModel;
    }

    public void setReportModel(String reportModel) {
        this.reportModel = reportModel == null ? null : reportModel.trim();
    }

    public String getExtend() {
        return this.extend;
    }

    public void setExtend(String extend) {
        this.extend = extend == null ? null : extend.trim();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(this.hashCode());
        sb.append(", id=").append(this.id);
        sb.append(", userId=").append(this.userId);
        sb.append(", brandIds=").append(this.brandIds);
        sb.append(", dailyAverageOrder=").append(this.dailyAverageOrder);
        sb.append(", dailyAverageSearch=").append(this.dailyAverageSearch);
        sb.append(", dailyAverageCharge=").append(this.dailyAverageCharge);
        sb.append(", backupForbiddenSupportBrand=").append(this.backupForbiddenSupportBrand);
        sb.append(", forbiddenSupportBrand=").append(this.forbiddenSupportBrand);
        sb.append(", cityId=").append(this.cityId);
        sb.append(", limitNum=").append(this.limitNum);
        sb.append(", mobileCityId=").append(this.mobileCityId);
        sb.append(", deviceNo=").append(this.deviceNo);
        sb.append(", reportDays=").append(this.reportDays);
        sb.append(", reportVinTimes=").append(this.reportVinTimes);
        sb.append(", activeTime=").append(this.activeTime);
        sb.append(", carBusinessConfig=").append(this.carBusinessConfig);
        sb.append(", detectionOrderConfig=").append(this.detectionOrderConfig);
        sb.append(", ldSwitch=").append(this.ldSwitch);
        sb.append(", detectionReportDisplaySwitch=").append(this.detectionReportDisplaySwitch);
        sb.append(", detectionReportCallSwitch=").append(this.detectionReportCallSwitch);
        sb.append(", marketShopId=").append(this.marketShopId);
        sb.append(", reportModel=").append(this.reportModel);
        sb.append(", extend=").append(this.extend);
        sb.append("]");
        return sb.toString();
    }
}
