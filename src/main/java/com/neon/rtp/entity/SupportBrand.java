//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.neon.rtp.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class SupportBrand implements Serializable{

    private Long id;

    private String brandName;

    private String brandNamePinyin;

    private String manufacturer;

    private Integer platform;

    private String msnQueue;

    private Date addTime;

    private Integer timeout;

    private Integer status;

    private Date startTime;

    private Date endTime;

    private Integer apiStatus;

    private String logoGray;

    private String logoLight;

    private Integer require;

    private Integer limitNum;

    private String reportTip;

    private Boolean pangda;

    private Integer blackListUserType;

    private Integer backupBlackListUserType;

    private BigDecimal brandPrice;

    private String limitNumConfig;

    private String filter;

    private Boolean deleted;

    private String middleAgentPrice;

    private Boolean valuable;

    private Long brand58Id;

    private Long manufacturer58Id;

    private Integer brandVersion;

    private Integer source;

    private String brand58Ids;

    private Integer defaultProductType;

    private Boolean isSpecialBrand;

    private String brand58Name;

    private String brandInitials;

    private String brandNameEn;

    private String brandAlias;

    private String country;

    private Boolean label;

    private Integer requireLicense;

    private String extend;

    private String logo;

    private static final long serialVersionUID = 1L;

    public SupportBrand() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrandName() {
        return this.brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName == null ? null : brandName.trim();
    }

    public String getBrandNamePinyin() {
        return this.brandNamePinyin;
    }

    public void setBrandNamePinyin(String brandNamePinyin) {
        this.brandNamePinyin = brandNamePinyin == null ? null : brandNamePinyin.trim();
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer == null ? null : manufacturer.trim();
    }

    public Integer getPlatform() {
        return this.platform;
    }

    public void setPlatform(Integer platform) {
        this.platform = platform;
    }

    public String getMsnQueue() {
        return this.msnQueue;
    }

    public void setMsnQueue(String msnQueue) {
        this.msnQueue = msnQueue == null ? null : msnQueue.trim();
    }

    public Date getAddTime() {
        return this.addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Integer getTimeout() {
        return this.timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getStartTime() {
        return this.startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return this.endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getApiStatus() {
        return this.apiStatus;
    }

    public void setApiStatus(Integer apiStatus) {
        this.apiStatus = apiStatus;
    }

    public String getLogoGray() {
        return this.logoGray;
    }

    public void setLogoGray(String logoGray) {
        this.logoGray = logoGray == null ? null : logoGray.trim();
    }

    public String getLogoLight() {
        return this.logoLight;
    }

    public void setLogoLight(String logoLight) {
        this.logoLight = logoLight == null ? null : logoLight.trim();
    }

    public Integer getRequire() {
        return this.require;
    }

    public void setRequire(Integer require) {
        this.require = require;
    }

    public Integer getLimitNum() {
        return this.limitNum;
    }

    public void setLimitNum(Integer limitNum) {
        this.limitNum = limitNum;
    }

    public String getReportTip() {
        return this.reportTip;
    }

    public void setReportTip(String reportTip) {
        this.reportTip = reportTip == null ? null : reportTip.trim();
    }

    public Boolean getPangda() {
        return this.pangda;
    }

    public void setPangda(Boolean pangda) {
        this.pangda = pangda;
    }

    public Integer getBlackListUserType() {
        return this.blackListUserType;
    }

    public void setBlackListUserType(Integer blackListUserType) {
        this.blackListUserType = blackListUserType;
    }

    public Integer getBackupBlackListUserType() {
        return this.backupBlackListUserType;
    }

    public void setBackupBlackListUserType(Integer backupBlackListUserType) {
        this.backupBlackListUserType = backupBlackListUserType;
    }

    public BigDecimal getBrandPrice() {
        return this.brandPrice;
    }

    public void setBrandPrice(BigDecimal brandPrice) {
        this.brandPrice = brandPrice;
    }

    public String getLimitNumConfig() {
        return this.limitNumConfig;
    }

    public void setLimitNumConfig(String limitNumConfig) {
        this.limitNumConfig = limitNumConfig == null ? null : limitNumConfig.trim();
    }

    public String getFilter() {
        return this.filter;
    }

    public void setFilter(String filter) {
        this.filter = filter == null ? null : filter.trim();
    }

    public Boolean getDeleted() {
        return this.deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public String getMiddleAgentPrice() {
        return this.middleAgentPrice;
    }

    public void setMiddleAgentPrice(String middleAgentPrice) {
        this.middleAgentPrice = middleAgentPrice == null ? null : middleAgentPrice.trim();
    }

    public Boolean getValuable() {
        return this.valuable;
    }

    public void setValuable(Boolean valuable) {
        this.valuable = valuable;
    }

    public Long getBrand58Id() {
        return this.brand58Id;
    }

    public void setBrand58Id(Long brand58Id) {
        this.brand58Id = brand58Id;
    }

    public Long getManufacturer58Id() {
        return this.manufacturer58Id;
    }

    public void setManufacturer58Id(Long manufacturer58Id) {
        this.manufacturer58Id = manufacturer58Id;
    }

    public Integer getBrandVersion() {
        return this.brandVersion;
    }

    public void setBrandVersion(Integer brandVersion) {
        this.brandVersion = brandVersion;
    }

    public Integer getSource() {
        return this.source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public String getBrand58Ids() {
        return this.brand58Ids;
    }

    public void setBrand58Ids(String brand58Ids) {
        this.brand58Ids = brand58Ids == null ? null : brand58Ids.trim();
    }

    public Integer getDefaultProductType() {
        return this.defaultProductType;
    }

    public void setDefaultProductType(Integer defaultProductType) {
        this.defaultProductType = defaultProductType;
    }

    public Boolean getIsSpecialBrand() {
        return this.isSpecialBrand;
    }

    public void setIsSpecialBrand(Boolean isSpecialBrand) {
        this.isSpecialBrand = isSpecialBrand;
    }

    public String getBrand58Name() {
        return this.brand58Name;
    }

    public void setBrand58Name(String brand58Name) {
        this.brand58Name = brand58Name == null ? null : brand58Name.trim();
    }

    public String getBrandInitials() {
        return this.brandInitials;
    }

    public void setBrandInitials(String brandInitials) {
        this.brandInitials = brandInitials == null ? null : brandInitials.trim();
    }

    public String getBrandNameEn() {
        return this.brandNameEn;
    }

    public void setBrandNameEn(String brandNameEn) {
        this.brandNameEn = brandNameEn == null ? null : brandNameEn.trim();
    }

    public String getBrandAlias() {
        return this.brandAlias;
    }

    public void setBrandAlias(String brandAlias) {
        this.brandAlias = brandAlias == null ? null : brandAlias.trim();
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public Boolean getLabel() {
        return this.label;
    }

    public void setLabel(Boolean label) {
        this.label = label;
    }

    public Integer getRequireLicense() {
        return this.requireLicense;
    }

    public void setRequireLicense(Integer requireLicense) {
        this.requireLicense = requireLicense;
    }

    public String getExtend() {
        return this.extend;
    }

    public void setExtend(String extend) {
        this.extend = extend == null ? null : extend.trim();
    }

    public String getLogo() {
        return this.logo;
    }

    public void setLogo(String logo) {
        this.logo = logo == null ? null : logo.trim();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(this.hashCode());
        sb.append(", id=").append(this.id);
        sb.append(", brandName=").append(this.brandName);
        sb.append(", brandNamePinyin=").append(this.brandNamePinyin);
        sb.append(", manufacturer=").append(this.manufacturer);
        sb.append(", platform=").append(this.platform);
        sb.append(", msnQueue=").append(this.msnQueue);
        sb.append(", addTime=").append(this.addTime);
        sb.append(", timeout=").append(this.timeout);
        sb.append(", status=").append(this.status);
        sb.append(", startTime=").append(this.startTime);
        sb.append(", endTime=").append(this.endTime);
        sb.append(", apiStatus=").append(this.apiStatus);
        sb.append(", logoGray=").append(this.logoGray);
        sb.append(", logoLight=").append(this.logoLight);
        sb.append(", require=").append(this.require);
        sb.append(", limitNum=").append(this.limitNum);
        sb.append(", reportTip=").append(this.reportTip);
        sb.append(", pangda=").append(this.pangda);
        sb.append(", blackListUserType=").append(this.blackListUserType);
        sb.append(", backupBlackListUserType=").append(this.backupBlackListUserType);
        sb.append(", brandPrice=").append(this.brandPrice);
        sb.append(", limitNumConfig=").append(this.limitNumConfig);
        sb.append(", filter=").append(this.filter);
        sb.append(", deleted=").append(this.deleted);
        sb.append(", middleAgentPrice=").append(this.middleAgentPrice);
        sb.append(", valuable=").append(this.valuable);
        sb.append(", brand58Id=").append(this.brand58Id);
        sb.append(", manufacturer58Id=").append(this.manufacturer58Id);
        sb.append(", brandVersion=").append(this.brandVersion);
        sb.append(", source=").append(this.source);
        sb.append(", brand58Ids=").append(this.brand58Ids);
        sb.append(", defaultProductType=").append(this.defaultProductType);
        sb.append(", isSpecialBrand=").append(this.isSpecialBrand);
        sb.append(", brand58Name=").append(this.brand58Name);
        sb.append(", brandInitials=").append(this.brandInitials);
        sb.append(", brandNameEn=").append(this.brandNameEn);
        sb.append(", brandAlias=").append(this.brandAlias);
        sb.append(", country=").append(this.country);
        sb.append(", label=").append(this.label);
        sb.append(", requireLicense=").append(this.requireLicense);
        sb.append(", extend=").append(this.extend);
        sb.append(", logo=").append(this.logo);
        sb.append("]");
        return sb.toString();
    }
}
