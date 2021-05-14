package com.neon.rtp.entity;







import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



public class WarrantyDetail implements Serializable {
    public WarrantyDetail() {
    }

    public WarrantyDetail(String orderNo) {
        this.orderNo = orderNo;
    }

    public WarrantyDetail(String orderNo, String vin) {
        this.orderNo = orderNo;
        this.vin = vin;
    }
    /**
     * 主键id
     */


    private Long id;

    /**
     * 订单号
     */

    private String orderNo;

    /**
     * 订单子状态，1000110-待确认, 1000120-待检测,1000130-检测中，1000210-待付款,1000310-已付款,1000320-投保中,1000330-待签字,1000340-核保中,1000410-已投保,1000420-已到期,1000510-投保失败,1000520-已取消,1000610-已退保
     */

    private Integer status;

    /**
     * 车架号
     */

    private String vin;

    /**
     * 车型id
     */

    private Long carModelId;

    /**
     * 初次登记日期
     */

    private Date firstRegTime;

    /**
     * 用户输入的表显里程 （单位：万公里）
     */

    private BigDecimal watchMiles;

    /**
     * 调检测系统的订单号
     */

    private String insurenceOrderno;

    /**
     * 子产品类型：1-A套餐 ，2-B套餐，3-C套餐，4-D套餐 ，5-庞大延保一年，6-庞大延保两年
     */

    private String subType;

    /**
     * 检测结果： 通过 or 不通过
     */

    private Boolean detectionResult;

    /**
     * 检测回调时间
     */

    private Date detectionCallbackTime;

    /**
     * 添加时间
     */

    private Date addTime;

    /**
     * 更新时间
     */

    private Date updateTime;

    /**
     * 是否需要检测：0-不需要检测 ； 1-需要检测  ； 2-不保
     */

    private Integer needCheck;

    /**
     * 是否白名单：0-否  ； 1-是
     */

    private Boolean isSuper;

    /**
     * 邀请人userId
     */

    private Long inviteUserId;

    /**
     * 延保年限： 1-延保1年； 2-延保2年；
     */

    private Integer warrantyYear;

    /**
     * 一车一价的订单价格
     */

    private BigDecimal orderPrice;

    /**
     * 检测联系人
     */

    private String detectionName;

    /**
     * 检测联系电话
     */

    private String detectionMobile;

    /**
     * 检测城市
     */

    private Integer detectionCityId;

    /**
     * 检测地址
     */

    private String detectionAddress;

    /**
     * 是否补充信息： 0-否； 1-是
     */

    private Boolean isAddInfo;

    /**
     * 支付类型： 1-前置付款 ； 2-后置付款
     */

    private Integer payType;

    /**
     * 套餐类型：10-常用部件保修，11-核心部件保修，12-重要部件保修，13-全车保修
     */

    private Integer packageType;

    /**
     * 用户下单时的等级
     */

    private Integer userLevel;

    /**
     * 类型：1-二手车 ; 2-新车,3-进口车,4-在用车
     */

    private Integer carType;

    /**
     * 行驶本照片
     */

    private String drivingPhoto;

    /**
     * 里程表照片
     */

    private String odometerPhoto;

    /**
     * 发证日期
     */

    private Date licenceIssued;

    /**
     * 过户后行驶本照片
     */

    private String afterTransferDrivingPhoto;

    /**
     * 车主姓名
     */

    private String carOwnerName;

    /**
     * 车牌号
     */

    private String carNo;

    /**
     * 车辆发动机号
     */

    private String carEngineNo;

    /**
     * 车辆豪华等级：1-A ; 2-B ; 3-C ; 5-D(最豪华)
     */

    private Integer carLevel;

    /**
     * 用户id
     */

    private Long userId;

    /**
     * 活动返优惠卷金额
     */

    private BigDecimal couponMoney;

    /**
     * 用户上传的照片
     */

    private String ocrPhoto;

    /**
     * 审核状态：0-未审核，1-审核通过，2-审核失败，3-不可承保
     */

    private Integer auditStatus;

    /**
     * 审核未通过原因
     */

    private String auditFailRemark;

    /**
     * 用户列表展示优先级: 0-默认； 1-优先 (值越大优先级越高)
     */

    private Integer displayPriority;

    /**
     * 状态变更时间
     */

    private Date statusChangeTime;

    /**
     * 扩展字段
     */

    private String extend;

    /**
     * 特批类型 0-否，1-特批免检，2-特批必检，3-特批不保
     */

    private Integer approveType;

    /**
     * 检测报告等级(A/B/C/D/E)
     */

    private String detectionCarLevel;

    /**
     * t_warranty_detail
     */

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     * @return id 主键id
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键id
     * @param id 主键id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 订单号
     * @return order_no 订单号
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * 订单号
     * @param orderNo 订单号
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    /**
     * 订单子状态，1000110-待确认, 1000120-待检测,1000130-检测中，1000210-待付款,1000310-已付款,1000320-投保中,1000330-待签字,1000340-核保中,1000410-已投保,1000420-已到期,1000510-投保失败,1000520-已取消,1000610-已退保
     * @return status 订单子状态，1000110-待确认, 1000120-待检测,1000130-检测中，1000210-待付款,1000310-已付款,1000320-投保中,1000330-待签字,1000340-核保中,1000410-已投保,1000420-已到期,1000510-投保失败,1000520-已取消,1000610-已退保
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 订单子状态，1000110-待确认, 1000120-待检测,1000130-检测中，1000210-待付款,1000310-已付款,1000320-投保中,1000330-待签字,1000340-核保中,1000410-已投保,1000420-已到期,1000510-投保失败,1000520-已取消,1000610-已退保
     * @param status 订单子状态，1000110-待确认, 1000120-待检测,1000130-检测中，1000210-待付款,1000310-已付款,1000320-投保中,1000330-待签字,1000340-核保中,1000410-已投保,1000420-已到期,1000510-投保失败,1000520-已取消,1000610-已退保
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 车架号
     * @return vin 车架号
     */
    public String getVin() {
        return vin;
    }

    /**
     * 车架号
     * @param vin 车架号
     */
    public void setVin(String vin) {
        this.vin = vin == null ? null : vin.trim();
    }

    /**
     * 车型id
     * @return car_model_id 车型id
     */
    public Long getCarModelId() {
        return carModelId;
    }

    /**
     * 车型id
     * @param carModelId 车型id
     */
    public void setCarModelId(Long carModelId) {
        this.carModelId = carModelId;
    }

    /**
     * 初次登记日期
     * @return first_reg_time 初次登记日期
     */
    public Date getFirstRegTime() {
        return firstRegTime;
    }

    /**
     * 初次登记日期
     * @param firstRegTime 初次登记日期
     */
    public void setFirstRegTime(Date firstRegTime) {
        this.firstRegTime = firstRegTime;
    }

    /**
     * 用户输入的表显里程 （单位：万公里）
     * @return watch_miles 用户输入的表显里程 （单位：万公里）
     */
    public BigDecimal getWatchMiles() {
        return watchMiles;
    }

    /**
     * 用户输入的表显里程 （单位：万公里）
     * @param watchMiles 用户输入的表显里程 （单位：万公里）
     */
    public void setWatchMiles(BigDecimal watchMiles) {
        this.watchMiles = watchMiles;
    }

    /**
     * 调检测系统的订单号
     * @return insurence_orderno 调检测系统的订单号
     */
    public String getInsurenceOrderno() {
        return insurenceOrderno;
    }

    /**
     * 调检测系统的订单号
     * @param insurenceOrderno 调检测系统的订单号
     */
    public void setInsurenceOrderno(String insurenceOrderno) {
        this.insurenceOrderno = insurenceOrderno == null ? null : insurenceOrderno.trim();
    }

    /**
     * 子产品类型：1-A套餐 ，2-B套餐，3-C套餐，4-D套餐 ，5-庞大延保一年，6-庞大延保两年
     * @return sub_type 子产品类型：1-A套餐 ，2-B套餐，3-C套餐，4-D套餐 ，5-庞大延保一年，6-庞大延保两年
     */
    public String getSubType() {
        return subType;
    }

    /**
     * 子产品类型：1-A套餐 ，2-B套餐，3-C套餐，4-D套餐 ，5-庞大延保一年，6-庞大延保两年
     * @param subType 子产品类型：1-A套餐 ，2-B套餐，3-C套餐，4-D套餐 ，5-庞大延保一年，6-庞大延保两年
     */
    public void setSubType(String subType) {
        this.subType = subType == null ? null : subType.trim();
    }

    /**
     * 检测结果： 通过 or 不通过
     * @return detection_result 检测结果： 通过 or 不通过
     */
    public Boolean getDetectionResult() {
        return detectionResult;
    }

    /**
     * 检测结果： 通过 or 不通过
     * @param detectionResult 检测结果： 通过 or 不通过
     */
    public void setDetectionResult(Boolean detectionResult) {
        this.detectionResult = detectionResult;
    }

    /**
     * 检测回调时间
     * @return detection_callback_time 检测回调时间
     */
    public Date getDetectionCallbackTime() {
        return detectionCallbackTime;
    }

    /**
     * 检测回调时间
     * @param detectionCallbackTime 检测回调时间
     */
    public void setDetectionCallbackTime(Date detectionCallbackTime) {
        this.detectionCallbackTime = detectionCallbackTime;
    }

    /**
     * 添加时间
     * @return add_time 添加时间
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * 添加时间
     * @param addTime 添加时间
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    /**
     * 更新时间
     * @return update_time 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 更新时间
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 是否需要检测：0-不需要检测 ； 1-需要检测  ； 2-不保
     * @return need_check 是否需要检测：0-不需要检测 ； 1-需要检测  ； 2-不保
     */
    public Integer getNeedCheck() {
        return needCheck;
    }

    /**
     * 是否需要检测：0-不需要检测 ； 1-需要检测  ； 2-不保
     * @param needCheck 是否需要检测：0-不需要检测 ； 1-需要检测  ； 2-不保
     */
    public void setNeedCheck(Integer needCheck) {
        this.needCheck = needCheck;
    }

    /**
     * 是否白名单：0-否  ； 1-是
     * @return is_super 是否白名单：0-否  ； 1-是
     */
    public Boolean getIsSuper() {
        return isSuper;
    }

    /**
     * 是否白名单：0-否  ； 1-是
     * @param isSuper 是否白名单：0-否  ； 1-是
     */
    public void setIsSuper(Boolean isSuper) {
        this.isSuper = isSuper;
    }

    /**
     * 邀请人userId
     * @return invite_user_id 邀请人userId
     */
    public Long getInviteUserId() {
        return inviteUserId;
    }

    /**
     * 邀请人userId
     * @param inviteUserId 邀请人userId
     */
    public void setInviteUserId(Long inviteUserId) {
        this.inviteUserId = inviteUserId;
    }

    /**
     * 延保年限： 1-延保1年； 2-延保2年；
     * @return warranty_year 延保年限： 1-延保1年； 2-延保2年；
     */
    public Integer getWarrantyYear() {
        return warrantyYear;
    }

    /**
     * 延保年限： 1-延保1年； 2-延保2年；
     * @param warrantyYear 延保年限： 1-延保1年； 2-延保2年；
     */
    public void setWarrantyYear(Integer warrantyYear) {
        this.warrantyYear = warrantyYear;
    }

    /**
     * 一车一价的订单价格
     * @return order_price 一车一价的订单价格
     */
    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    /**
     * 一车一价的订单价格
     * @param orderPrice 一车一价的订单价格
     */
    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }

    /**
     * 检测联系人
     * @return detection_name 检测联系人
     */
    public String getDetectionName() {
        return detectionName;
    }

    /**
     * 检测联系人
     * @param detectionName 检测联系人
     */
    public void setDetectionName(String detectionName) {
        this.detectionName = detectionName == null ? null : detectionName.trim();
    }

    /**
     * 检测联系电话
     * @return detection_mobile 检测联系电话
     */
    public String getDetectionMobile() {
        return detectionMobile;
    }

    /**
     * 检测联系电话
     * @param detectionMobile 检测联系电话
     */
    public void setDetectionMobile(String detectionMobile) {
        this.detectionMobile = detectionMobile == null ? null : detectionMobile.trim();
    }

    /**
     * 检测城市
     * @return detection_city_id 检测城市
     */
    public Integer getDetectionCityId() {
        return detectionCityId;
    }

    /**
     * 检测城市
     * @param detectionCityId 检测城市
     */
    public void setDetectionCityId(Integer detectionCityId) {
        this.detectionCityId = detectionCityId;
    }

    /**
     * 检测地址
     * @return detection_address 检测地址
     */
    public String getDetectionAddress() {
        return detectionAddress;
    }

    /**
     * 检测地址
     * @param detectionAddress 检测地址
     */
    public void setDetectionAddress(String detectionAddress) {
        this.detectionAddress = detectionAddress == null ? null : detectionAddress.trim();
    }

    /**
     * 是否补充信息： 0-否； 1-是
     * @return is_add_info 是否补充信息： 0-否； 1-是
     */
    public Boolean getIsAddInfo() {
        return isAddInfo;
    }

    /**
     * 是否补充信息： 0-否； 1-是
     * @param isAddInfo 是否补充信息： 0-否； 1-是
     */
    public void setIsAddInfo(Boolean isAddInfo) {
        this.isAddInfo = isAddInfo;
    }

    /**
     * 支付类型： 1-前置付款 ； 2-后置付款
     * @return pay_type 支付类型： 1-前置付款 ； 2-后置付款
     */
    public Integer getPayType() {
        return payType;
    }

    /**
     * 支付类型： 1-前置付款 ； 2-后置付款
     * @param payType 支付类型： 1-前置付款 ； 2-后置付款
     */
    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    /**
     * 套餐类型：10-常用部件保修，11-核心部件保修，12-重要部件保修，13-全车保修
     * @return package_type 套餐类型：10-常用部件保修，11-核心部件保修，12-重要部件保修，13-全车保修
     */
    public Integer getPackageType() {
        return packageType;
    }

    /**
     * 套餐类型：10-常用部件保修，11-核心部件保修，12-重要部件保修，13-全车保修
     * @param packageType 套餐类型：10-常用部件保修，11-核心部件保修，12-重要部件保修，13-全车保修
     */
    public void setPackageType(Integer packageType) {
        this.packageType = packageType;
    }

    /**
     * 用户下单时的等级
     * @return user_level 用户下单时的等级
     */
    public Integer getUserLevel() {
        return userLevel;
    }

    /**
     * 用户下单时的等级
     * @param userLevel 用户下单时的等级
     */
    public void setUserLevel(Integer userLevel) {
        this.userLevel = userLevel;
    }

    /**
     * 类型：1-二手车 ; 2-新车,3-进口车,4-在用车
     * @return car_type 类型：1-二手车 ; 2-新车,3-进口车,4-在用车
     */
    public Integer getCarType() {
        return carType;
    }

    /**
     * 类型：1-二手车 ; 2-新车,3-进口车,4-在用车
     * @param carType 类型：1-二手车 ; 2-新车,3-进口车,4-在用车
     */
    public void setCarType(Integer carType) {
        this.carType = carType;
    }

    /**
     * 行驶本照片
     * @return driving_photo 行驶本照片
     */
    public String getDrivingPhoto() {
        return drivingPhoto;
    }

    /**
     * 行驶本照片
     * @param drivingPhoto 行驶本照片
     */
    public void setDrivingPhoto(String drivingPhoto) {
        this.drivingPhoto = drivingPhoto == null ? null : drivingPhoto.trim();
    }

    /**
     * 里程表照片
     * @return odometer_photo 里程表照片
     */
    public String getOdometerPhoto() {
        return odometerPhoto;
    }

    /**
     * 里程表照片
     * @param odometerPhoto 里程表照片
     */
    public void setOdometerPhoto(String odometerPhoto) {
        this.odometerPhoto = odometerPhoto == null ? null : odometerPhoto.trim();
    }

    /**
     * 发证日期
     * @return licence_issued 发证日期
     */
    public Date getLicenceIssued() {
        return licenceIssued;
    }

    /**
     * 发证日期
     * @param licenceIssued 发证日期
     */
    public void setLicenceIssued(Date licenceIssued) {
        this.licenceIssued = licenceIssued;
    }

    /**
     * 过户后行驶本照片
     * @return after_transfer_driving_photo 过户后行驶本照片
     */
    public String getAfterTransferDrivingPhoto() {
        return afterTransferDrivingPhoto;
    }

    /**
     * 过户后行驶本照片
     * @param afterTransferDrivingPhoto 过户后行驶本照片
     */
    public void setAfterTransferDrivingPhoto(String afterTransferDrivingPhoto) {
        this.afterTransferDrivingPhoto = afterTransferDrivingPhoto == null ? null : afterTransferDrivingPhoto.trim();
    }

    /**
     * 车主姓名
     * @return car_owner_name 车主姓名
     */
    public String getCarOwnerName() {
        return carOwnerName;
    }

    /**
     * 车主姓名
     * @param carOwnerName 车主姓名
     */
    public void setCarOwnerName(String carOwnerName) {
        this.carOwnerName = carOwnerName == null ? null : carOwnerName.trim();
    }

    /**
     * 车牌号
     * @return car_no 车牌号
     */
    public String getCarNo() {
        return carNo;
    }

    /**
     * 车牌号
     * @param carNo 车牌号
     */
    public void setCarNo(String carNo) {
        this.carNo = carNo == null ? null : carNo.trim();
    }

    /**
     * 车辆发动机号
     * @return car_engine_no 车辆发动机号
     */
    public String getCarEngineNo() {
        return carEngineNo;
    }

    /**
     * 车辆发动机号
     * @param carEngineNo 车辆发动机号
     */
    public void setCarEngineNo(String carEngineNo) {
        this.carEngineNo = carEngineNo == null ? null : carEngineNo.trim();
    }

    /**
     * 车辆豪华等级：1-A ; 2-B ; 3-C ; 5-D(最豪华)
     * @return car_level 车辆豪华等级：1-A ; 2-B ; 3-C ; 5-D(最豪华)
     */
    public Integer getCarLevel() {
        return carLevel;
    }

    /**
     * 车辆豪华等级：1-A ; 2-B ; 3-C ; 5-D(最豪华)
     * @param carLevel 车辆豪华等级：1-A ; 2-B ; 3-C ; 5-D(最豪华)
     */
    public void setCarLevel(Integer carLevel) {
        this.carLevel = carLevel;
    }

    /**
     * 用户id
     * @return user_id 用户id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 用户id
     * @param userId 用户id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 活动返优惠卷金额
     * @return coupon_money 活动返优惠卷金额
     */
    public BigDecimal getCouponMoney() {
        return couponMoney;
    }

    /**
     * 活动返优惠卷金额
     * @param couponMoney 活动返优惠卷金额
     */
    public void setCouponMoney(BigDecimal couponMoney) {
        this.couponMoney = couponMoney;
    }

    /**
     * 用户上传的照片
     * @return ocr_photo 用户上传的照片
     */
    public String getOcrPhoto() {
        return ocrPhoto;
    }

    /**
     * 用户上传的照片
     * @param ocrPhoto 用户上传的照片
     */
    public void setOcrPhoto(String ocrPhoto) {
        this.ocrPhoto = ocrPhoto == null ? null : ocrPhoto.trim();
    }

    /**
     * 审核状态：0-未审核，1-审核通过，2-审核失败，3-不可承保
     * @return audit_status 审核状态：0-未审核，1-审核通过，2-审核失败，3-不可承保
     */
    public Integer getAuditStatus() {
        return auditStatus;
    }

    /**
     * 审核状态：0-未审核，1-审核通过，2-审核失败，3-不可承保
     * @param auditStatus 审核状态：0-未审核，1-审核通过，2-审核失败，3-不可承保
     */
    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    /**
     * 审核未通过原因
     * @return audit_fail_remark 审核未通过原因
     */
    public String getAuditFailRemark() {
        return auditFailRemark;
    }

    /**
     * 审核未通过原因
     * @param auditFailRemark 审核未通过原因
     */
    public void setAuditFailRemark(String auditFailRemark) {
        this.auditFailRemark = auditFailRemark == null ? null : auditFailRemark.trim();
    }

    /**
     * 用户列表展示优先级: 0-默认； 1-优先 (值越大优先级越高)
     * @return display_priority 用户列表展示优先级: 0-默认； 1-优先 (值越大优先级越高)
     */
    public Integer getDisplayPriority() {
        return displayPriority;
    }

    /**
     * 用户列表展示优先级: 0-默认； 1-优先 (值越大优先级越高)
     * @param displayPriority 用户列表展示优先级: 0-默认； 1-优先 (值越大优先级越高)
     */
    public void setDisplayPriority(Integer displayPriority) {
        this.displayPriority = displayPriority;
    }

    /**
     * 状态变更时间
     * @return status_change_time 状态变更时间
     */
    public Date getStatusChangeTime() {
        return statusChangeTime;
    }

    /**
     * 状态变更时间
     * @param statusChangeTime 状态变更时间
     */
    public void setStatusChangeTime(Date statusChangeTime) {
        this.statusChangeTime = statusChangeTime;
    }

    /**
     * 扩展字段
     * @return extend 扩展字段
     */
    public String getExtend() {
        return extend;
    }

    /**
     * 扩展字段
     * @param extend 扩展字段
     */
    public void setExtend(String extend) {
        this.extend = extend == null ? null : extend.trim();
    }

    /**
     * 特批等级 0-否，1-特批免检，2-特批必检，3-特批不保
     * @return approveType
     */
    public Integer getApproveType() {
        return approveType;
    }

    /**
     * 特批等级
     * @param approveType 特批等级 0-否，1-特批免检，2-特批必检，3-特批不保
     */
    public void setApproveType(Integer approveType) {
        this.approveType = approveType;
    }

    /**
     * 检测报告等级
     * @return detectionCarLevel 检测报告等级 (A/B/C/D/E)
     */
    public String getDetectionCarLevel() {
        return detectionCarLevel;
    }

    /**
     * 检测报告等级
     * @param detectionCarLevel 检测报告等级 (A/B/C/D/E)
     */
    public void setDetectionCarLevel(String detectionCarLevel) {
        this.detectionCarLevel = detectionCarLevel;
    }

    /**
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", orderNo=").append(orderNo);
        sb.append(", status=").append(status);
        sb.append(", vin=").append(vin);
        sb.append(", carModelId=").append(carModelId);
        sb.append(", firstRegTime=").append(firstRegTime);
        sb.append(", watchMiles=").append(watchMiles);
        sb.append(", insurenceOrderno=").append(insurenceOrderno);
        sb.append(", subType=").append(subType);
        sb.append(", detectionResult=").append(detectionResult);
        sb.append(", detectionCallbackTime=").append(detectionCallbackTime);
        sb.append(", addTime=").append(addTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", needCheck=").append(needCheck);
        sb.append(", isSuper=").append(isSuper);
        sb.append(", inviteUserId=").append(inviteUserId);
        sb.append(", warrantyYear=").append(warrantyYear);
        sb.append(", orderPrice=").append(orderPrice);
        sb.append(", detectionName=").append(detectionName);
        sb.append(", detectionMobile=").append(detectionMobile);
        sb.append(", detectionCityId=").append(detectionCityId);
        sb.append(", detectionAddress=").append(detectionAddress);
        sb.append(", isAddInfo=").append(isAddInfo);
        sb.append(", payType=").append(payType);
        sb.append(", packageType=").append(packageType);
        sb.append(", userLevel=").append(userLevel);
        sb.append(", carType=").append(carType);
        sb.append(", drivingPhoto=").append(drivingPhoto);
        sb.append(", odometerPhoto=").append(odometerPhoto);
        sb.append(", licenceIssued=").append(licenceIssued);
        sb.append(", afterTransferDrivingPhoto=").append(afterTransferDrivingPhoto);
        sb.append(", carOwnerName=").append(carOwnerName);
        sb.append(", carNo=").append(carNo);
        sb.append(", carEngineNo=").append(carEngineNo);
        sb.append(", carLevel=").append(carLevel);
        sb.append(", userId=").append(userId);
        sb.append(", couponMoney=").append(couponMoney);
        sb.append(", ocrPhoto=").append(ocrPhoto);
        sb.append(", auditStatus=").append(auditStatus);
        sb.append(", auditFailRemark=").append(auditFailRemark);
        sb.append(", displayPriority=").append(displayPriority);
        sb.append(", statusChangeTime=").append(statusChangeTime);
        sb.append(", extend=").append(extend);
        sb.append(", approveType=").append(approveType);
        sb.append(", detectionCarLevel=").append(detectionCarLevel);
        sb.append("]");
        return sb.toString();
    }
}