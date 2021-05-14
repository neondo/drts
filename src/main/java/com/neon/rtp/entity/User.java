//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.neon.rtp.entity;






import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



public class User implements Serializable {


    private Long id;

    private Integer sex;

    private String userName;

    private Date birthday;

    private String nickName;

    private String keySecret;

    private String password;

    private Integer userStatus;

    private Date regTime;

    private String email;

    private String mobile;

    private String companyName;

    private Integer userType;

    private Integer userLevel;

    private Integer passwordSafetyFlag;

    private Integer payType;

    private Boolean bindseller;

    private Long inviteUserId;

    private Integer inviteUserType;

    private Integer unmeetDays;

    private String pid;

    private BigDecimal costStandard;

    private Integer registWay;

    private Integer registSource;

    private Long carMarketId;

    private Boolean carDealer;

    private Integer ageGroup;

    private Boolean messageable;

    private String appKey;

    private String mobileAlias;

    private Integer newUserType;

    private Date beMemberTime;

    private Integer userSubType;

    private String extend;

    private static final long serialVersionUID = -4113686581576359516L;

    public User() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSex() {
        return this.sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Date getBirthday() {
        return this.birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getNickName() {
        return this.nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public String getKeySecret() {
        return this.keySecret;
    }

    public void setKeySecret(String keySecret) {
        this.keySecret = keySecret == null ? null : keySecret.trim();
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getUserStatus() {
        return this.userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public Date getRegTime() {
        return this.regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public Integer getUserType() {
        return this.userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Integer getUserLevel() {
        return this.userLevel;
    }

    public void setUserLevel(Integer userLevel) {
        this.userLevel = userLevel;
    }

    public Integer getPasswordSafetyFlag() {
        return this.passwordSafetyFlag;
    }

    public void setPasswordSafetyFlag(Integer passwordSafetyFlag) {
        this.passwordSafetyFlag = passwordSafetyFlag;
    }

    public Integer getPayType() {
        return this.payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Boolean getBindseller() {
        return this.bindseller;
    }

    public void setBindseller(Boolean bindseller) {
        this.bindseller = bindseller;
    }

    public Long getInviteUserId() {
        return this.inviteUserId;
    }

    public void setInviteUserId(Long inviteUserId) {
        this.inviteUserId = inviteUserId;
    }

    public Integer getInviteUserType() {
        return this.inviteUserType;
    }

    public void setInviteUserType(Integer inviteUserType) {
        this.inviteUserType = inviteUserType;
    }

    public Integer getUnmeetDays() {
        return this.unmeetDays;
    }

    public void setUnmeetDays(Integer unmeetDays) {
        this.unmeetDays = unmeetDays;
    }

    public String getPid() {
        return this.pid;
    }

    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    public BigDecimal getCostStandard() {
        return this.costStandard;
    }

    public void setCostStandard(BigDecimal costStandard) {
        this.costStandard = costStandard;
    }

    public Integer getRegistWay() {
        return this.registWay;
    }

    public void setRegistWay(Integer registWay) {
        this.registWay = registWay;
    }

    public Integer getRegistSource() {
        return this.registSource;
    }

    public void setRegistSource(Integer registSource) {
        this.registSource = registSource;
    }

    public Long getCarMarketId() {
        return this.carMarketId;
    }

    public void setCarMarketId(Long carMarketId) {
        this.carMarketId = carMarketId;
    }

    public Boolean getCarDealer() {
        return this.carDealer;
    }

    public void setCarDealer(Boolean carDealer) {
        this.carDealer = carDealer;
    }

    public Integer getAgeGroup() {
        return this.ageGroup;
    }

    public void setAgeGroup(Integer ageGroup) {
        this.ageGroup = ageGroup;
    }

    public Boolean getMessageable() {
        return this.messageable;
    }

    public void setMessageable(Boolean messageable) {
        this.messageable = messageable;
    }

    public String getAppKey() {
        return this.appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey == null ? null : appKey.trim();
    }

    public String getMobileAlias() {
        return this.mobileAlias;
    }

    public void setMobileAlias(String mobileAlias) {
        this.mobileAlias = mobileAlias == null ? null : mobileAlias.trim();
    }

    public Integer getNewUserType() {
        return this.newUserType;
    }

    public void setNewUserType(Integer newUserType) {
        this.newUserType = newUserType;
    }

    public Date getBeMemberTime() {
        return this.beMemberTime;
    }

    public void setBeMemberTime(Date beMemberTime) {
        this.beMemberTime = beMemberTime;
    }

    public Integer getUserSubType() {
        return this.userSubType;
    }

    public void setUserSubType(Integer userSubType) {
        this.userSubType = userSubType;
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
        sb.append(", sex=").append(this.sex);
        sb.append(", userName=").append(this.userName);
        sb.append(", birthday=").append(this.birthday);
        sb.append(", nickName=").append(this.nickName);
        sb.append(", keySecret=").append(this.keySecret);
        sb.append(", password=").append(this.password);
        sb.append(", userStatus=").append(this.userStatus);
        sb.append(", regTime=").append(this.regTime);
        sb.append(", email=").append(this.email);
        sb.append(", mobile=").append(this.mobile);
        sb.append(", companyName=").append(this.companyName);
        sb.append(", userType=").append(this.userType);
        sb.append(", userLevel=").append(this.userLevel);
        sb.append(", passwordSafetyFlag=").append(this.passwordSafetyFlag);
        sb.append(", payType=").append(this.payType);
        sb.append(", bindseller=").append(this.bindseller);
        sb.append(", inviteUserId=").append(this.inviteUserId);
        sb.append(", inviteUserType=").append(this.inviteUserType);
        sb.append(", unmeetDays=").append(this.unmeetDays);
        sb.append(", pid=").append(this.pid);
        sb.append(", costStandard=").append(this.costStandard);
        sb.append(", registWay=").append(this.registWay);
        sb.append(", registSource=").append(this.registSource);
        sb.append(", carMarketId=").append(this.carMarketId);
        sb.append(", carDealer=").append(this.carDealer);
        sb.append(", ageGroup=").append(this.ageGroup);
        sb.append(", messageable=").append(this.messageable);
        sb.append(", appKey=").append(this.appKey);
        sb.append(", mobileAlias=").append(this.mobileAlias);
        sb.append(", newUserType=").append(this.newUserType);
        sb.append(", beMemberTime=").append(this.beMemberTime);
        sb.append(", userSubType=").append(this.userSubType);
        sb.append(", extend=").append(this.extend);
        sb.append("]");
        return sb.toString();
    }
}
