package com.neon.rtp.entity;







import java.io.Serializable;
import java.util.Date;



public class GpsDetail implements Serializable {

    public GpsDetail(Long userId) {
        this(userId, null);
    }

    public GpsDetail(Long userId, String vin) {
        this.userId = userId;
        this.vin = vin;
    }

    public GpsDetail() {
    }

    /**
     *
     */


    private Long id;

    /**
     * 用户id
     */

    private Long userId;

    /**
     * 城市id
     */

    private Integer cityId;

    /**
     * vin码
     */

    private String vin;

    /**
     * 车型id
     */

    private Long supportBrandModelId;

    /**
     * 状态：1000110-待分配、1000120-待安装、1000410-已完成、1000510-已取消
     */

    private Integer status;

    /**
     * 联系人手机号
     */

    private String mobile;

    /**
     * 联系人姓名
     */

    private String username;

    /**
     * 联系地址
     */

    private String address;

    /**
     * 安装类型：0-初装、1-更换、2-加装、3-拆除(仅后台工单可创建),4-检修
     */

    private Integer type;

    /**
     * 主管id
     */

    private Long ownUserId;

    /**
     * 检测师id
     */

    private Long ownUserCheckId;

    /**
     * 客服id
     */

    private Long ownUserCreateId;

    /**
     *
     */

    private String extend;

    /**
     * 备注
     */

    private String remark;

    /**
     *
     */

    private Date addTime;

    /**
     *
     */

    private Date updateTime;

    /**
     * 工单创建平台：0-OMS ;  1-App
     */

    private Integer source;

    /**
     * 工单类型：0-58 1-测试；
     */

    private Integer billType;

    /**
     * 服务类型： 2-两年期  ； 3-三年期；
     */

    private Double serviceType;

    /**
     * 车主姓名
     */

    private String carOwnerName;

    /**
     * 车主电话
     */

    private String carOwnerMobile;

    /**
     * 品牌id
     */

    private Long supportBrandId;

    /**
     * 是否删除：0-未删除 ； 1-已删除
     */

    private Boolean deleted;

    /**
     * 设备安装时间
     */

    private Date installTime;

    /**
     * 安装的设备数
     */

    private Integer deviceNums;

    /**
     * 安装结束时间
     */

    private Date finishTime;

    /**
     * 拍照时间
     */

    private Date photoTime;

    /**
     * 仪表盘图片的UUID
     */

    private String dashboardImg;

    /**
     * t_gps_package表的id
     */

    private Long packageId;

    /**
     * 订单号
     */

    private String orderNo;

    /**
     * 工单图片：JSON格式（新逻辑）
     */

    private String image;

    /**
     * 修理厂用户id，t_fix_user表的id
     */

    private Long fixUserId;

    /**
     * 价格类型：1-高价位 ; 2—低价位
     */

    private Integer priceType;

    /**
     * 销售类型: 0-无； 1-直销； 2-中介
     */

    private Integer partment;

    /**
     * t_gps_detail
     */

    private static final long serialVersionUID = 1L;

    /**
     *
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
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
     * 城市id
     * @return city_id 城市id
     */
    public Integer getCityId() {
        return cityId;
    }

    /**
     * 城市id
     * @param cityId 城市id
     */
    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    /**
     * vin码
     * @return vin vin码
     */
    public String getVin() {
        return vin;
    }

    /**
     * vin码
     * @param vin vin码
     */
    public void setVin(String vin) {
        this.vin = vin == null ? null : vin.trim();
    }

    /**
     * 车型id
     * @return support_brand_model_id 车型id
     */
    public Long getSupportBrandModelId() {
        return supportBrandModelId;
    }

    /**
     * 车型id
     * @param supportBrandModelId 车型id
     */
    public void setSupportBrandModelId(Long supportBrandModelId) {
        this.supportBrandModelId = supportBrandModelId;
    }

    /**
     * 状态：1000110-待分配、1000120-待安装、1000410-已完成、1000510-已取消
     * @return status 状态：1000110-待分配、1000120-待安装、1000410-已完成、1000510-已取消
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态：1000110-待分配、1000120-待安装、1000410-已完成、1000510-已取消
     * @param status 状态：1000110-待分配、1000120-待安装、1000410-已完成、1000510-已取消
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 联系人手机号
     * @return mobile 联系人手机号
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 联系人手机号
     * @param mobile 联系人手机号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * 联系人姓名
     * @return username 联系人姓名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 联系人姓名
     * @param username 联系人姓名
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * 联系地址
     * @return address 联系地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 联系地址
     * @param address 联系地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 安装类型：0-初装、1-更换、2-加装、3-拆除(仅后台工单可创建),4-检修
     * @return type 安装类型：0-初装、1-更换、2-加装、3-拆除(仅后台工单可创建),4-检修
     */
    public Integer getType() {
        return type;
    }

    /**
     * 安装类型：0-初装、1-更换、2-加装、3-拆除(仅后台工单可创建),4-检修
     * @param type 安装类型：0-初装、1-更换、2-加装、3-拆除(仅后台工单可创建),4-检修
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 主管id
     * @return own_user_id 主管id
     */
    public Long getOwnUserId() {
        return ownUserId;
    }

    /**
     * 主管id
     * @param ownUserId 主管id
     */
    public void setOwnUserId(Long ownUserId) {
        this.ownUserId = ownUserId;
    }

    /**
     * 检测师id
     * @return own_user_check_id 检测师id
     */
    public Long getOwnUserCheckId() {
        return ownUserCheckId;
    }

    /**
     * 检测师id
     * @param ownUserCheckId 检测师id
     */
    public void setOwnUserCheckId(Long ownUserCheckId) {
        this.ownUserCheckId = ownUserCheckId;
    }

    /**
     * 客服id
     * @return own_user_create_id 客服id
     */
    public Long getOwnUserCreateId() {
        return ownUserCreateId;
    }

    /**
     * 客服id
     * @param ownUserCreateId 客服id
     */
    public void setOwnUserCreateId(Long ownUserCreateId) {
        this.ownUserCreateId = ownUserCreateId;
    }

    /**
     *
     * @return extend
     */
    public String getExtend() {
        return extend;
    }

    /**
     *
     * @param extend
     */
    public void setExtend(String extend) {
        this.extend = extend == null ? null : extend.trim();
    }

    /**
     * 备注
     * @return remark 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     *
     * @return add_time
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     *
     * @param addTime
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    /**
     *
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     *
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 工单创建平台：0-OMS ;  1-App
     * @return source 工单创建平台：0-OMS ;  1-App
     */
    public Integer getSource() {
        return source;
    }

    /**
     * 工单创建平台：0-OMS ;  1-App
     * @param source 工单创建平台：0-OMS ;  1-App
     */
    public void setSource(Integer source) {
        this.source = source;
    }

    /**
     * 工单类型：0-58 1-测试；
     * @return bill_type 工单类型：0-58 1-测试；
     */
    public Integer getBillType() {
        return billType;
    }

    /**
     * 工单类型：0-58 1-测试；
     * @param billType 工单类型：0-58 1-测试；
     */
    public void setBillType(Integer billType) {
        this.billType = billType;
    }

    /**
     * 服务类型： 2-两年期  ； 3-三年期；
     * @return service_type 服务类型： 2-两年期  ； 3-三年期；
     */
    public Double getServiceType() {
        return serviceType;
    }

    /**
     * 服务类型： 2-两年期  ； 3-三年期；
     * @param serviceType 服务类型： 2-两年期  ； 3-三年期；
     */
    public void setServiceType(Double serviceType) {
        this.serviceType = serviceType;
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
     * 车主电话
     * @return car_owner_mobile 车主电话
     */
    public String getCarOwnerMobile() {
        return carOwnerMobile;
    }

    /**
     * 车主电话
     * @param carOwnerMobile 车主电话
     */
    public void setCarOwnerMobile(String carOwnerMobile) {
        this.carOwnerMobile = carOwnerMobile == null ? null : carOwnerMobile.trim();
    }

    /**
     * 品牌id
     * @return support_brand_id 品牌id
     */
    public Long getSupportBrandId() {
        return supportBrandId;
    }

    /**
     * 品牌id
     * @param supportBrandId 品牌id
     */
    public void setSupportBrandId(Long supportBrandId) {
        this.supportBrandId = supportBrandId;
    }

    /**
     * 是否删除：0-未删除 ； 1-已删除
     * @return deleted 是否删除：0-未删除 ； 1-已删除
     */
    public Boolean getDeleted() {
        return deleted;
    }

    /**
     * 是否删除：0-未删除 ； 1-已删除
     * @param deleted 是否删除：0-未删除 ； 1-已删除
     */
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    /**
     * 设备安装时间
     * @return install_time 设备安装时间
     */
    public Date getInstallTime() {
        return installTime;
    }

    /**
     * 设备安装时间
     * @param installTime 设备安装时间
     */
    public void setInstallTime(Date installTime) {
        this.installTime = installTime;
    }

    /**
     * 安装的设备数
     * @return device_nums 安装的设备数
     */
    public Integer getDeviceNums() {
        return deviceNums;
    }

    /**
     * 安装的设备数
     * @param deviceNums 安装的设备数
     */
    public void setDeviceNums(Integer deviceNums) {
        this.deviceNums = deviceNums;
    }

    /**
     * 安装结束时间
     * @return finish_time 安装结束时间
     */
    public Date getFinishTime() {
        return finishTime;
    }

    /**
     * 安装结束时间
     * @param finishTime 安装结束时间
     */
    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    /**
     * 拍照时间
     * @return photo_time 拍照时间
     */
    public Date getPhotoTime() {
        return photoTime;
    }

    /**
     * 拍照时间
     * @param photoTime 拍照时间
     */
    public void setPhotoTime(Date photoTime) {
        this.photoTime = photoTime;
    }

    /**
     * 仪表盘图片的UUID
     * @return dashboard_img 仪表盘图片的UUID
     */
    public String getDashboardImg() {
        return dashboardImg;
    }

    /**
     * 仪表盘图片的UUID
     * @param dashboardImg 仪表盘图片的UUID
     */
    public void setDashboardImg(String dashboardImg) {
        this.dashboardImg = dashboardImg == null ? null : dashboardImg.trim();
    }

    /**
     * t_gps_package表的id
     * @return package_id t_gps_package表的id
     */
    public Long getPackageId() {
        return packageId;
    }

    /**
     * t_gps_package表的id
     * @param packageId t_gps_package表的id
     */
    public void setPackageId(Long packageId) {
        this.packageId = packageId;
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
     * 工单图片：JSON格式（新逻辑）
     * @return image 工单图片：JSON格式（新逻辑）
     */
    public String getImage() {
        return image;
    }

    /**
     * 工单图片：JSON格式（新逻辑）
     * @param image 工单图片：JSON格式（新逻辑）
     */
    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    /**
     * 修理厂用户id，t_fix_user表的id
     * @return fix_user_id 修理厂用户id，t_fix_user表的id
     */
    public Long getFixUserId() {
        return fixUserId;
    }

    /**
     * 修理厂用户id，t_fix_user表的id
     * @param fixUserId 修理厂用户id，t_fix_user表的id
     */
    public void setFixUserId(Long fixUserId) {
        this.fixUserId = fixUserId;
    }

    /**
     * 价格类型：1-高价位 ; 2—低价位
     * @return price_type 价格类型：1-高价位 ; 2—低价位
     */
    public Integer getPriceType() {
        return priceType;
    }

    /**
     * 价格类型：1-高价位 ; 2—低价位
     * @param priceType 价格类型：1-高价位 ; 2—低价位
     */
    public void setPriceType(Integer priceType) {
        this.priceType = priceType;
    }

    /**
     * 销售类型: 0-无； 1-直销； 2-中介
     * @return partment 销售类型: 0-无； 1-直销； 2-中介
     */
    public Integer getPartment() {
        return partment;
    }

    /**
     * 销售类型: 0-无； 1-直销； 2-中介
     * @param partment 销售类型: 0-无； 1-直销； 2-中介
     */
    public void setPartment(Integer partment) {
        this.partment = partment;
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
        sb.append(", userId=").append(userId);
        sb.append(", cityId=").append(cityId);
        sb.append(", vin=").append(vin);
        sb.append(", supportBrandModelId=").append(supportBrandModelId);
        sb.append(", status=").append(status);
        sb.append(", mobile=").append(mobile);
        sb.append(", username=").append(username);
        sb.append(", address=").append(address);
        sb.append(", type=").append(type);
        sb.append(", ownUserId=").append(ownUserId);
        sb.append(", ownUserCheckId=").append(ownUserCheckId);
        sb.append(", ownUserCreateId=").append(ownUserCreateId);
        sb.append(", extend=").append(extend);
        sb.append(", remark=").append(remark);
        sb.append(", addTime=").append(addTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", source=").append(source);
        sb.append(", billType=").append(billType);
        sb.append(", serviceType=").append(serviceType);
        sb.append(", carOwnerName=").append(carOwnerName);
        sb.append(", carOwnerMobile=").append(carOwnerMobile);
        sb.append(", supportBrandId=").append(supportBrandId);
        sb.append(", deleted=").append(deleted);
        sb.append(", installTime=").append(installTime);
        sb.append(", deviceNums=").append(deviceNums);
        sb.append(", finishTime=").append(finishTime);
        sb.append(", photoTime=").append(photoTime);
        sb.append(", dashboardImg=").append(dashboardImg);
        sb.append(", packageId=").append(packageId);
        sb.append(", orderNo=").append(orderNo);
        sb.append(", image=").append(image);
        sb.append(", fixUserId=").append(fixUserId);
        sb.append(", priceType=").append(priceType);
        sb.append(", partment=").append(partment);
        sb.append("]");
        return sb.toString();
    }
}