package com.neon.rtp.entity;

import java.io.Serializable;
import java.util.Date;









public class GpsDetailRecord implements Serializable {
    /**
     *
     */
    public GpsDetailRecord() {
    }

    public GpsDetailRecord(Long gpsDetailId) {
        this.gpsDetailId = gpsDetailId;
    }

    /**
     *
     */


    private Long id;

    /**
     *
     */

    private Long gpsDetailId;

    /**
     *
     */

    private Date gpsDetailAddTime;

    /**
     * IMEI号
     */

    private String imei;

    /**
     *
     */

    private String vin;

    /**
     * 工单类型
     */

    private Integer billType;

    /**
     * 操作类型（0增加，1减少）
     */

    private String type;

    /**
     * 操作员
     */

    private Long operatorId;

    /**
     * 操作员
     */

    private String operatorName;

    /**
     *
     */

    private Date addTime;

    /**
     * 设备类型（0无线 1有线）
     */

    private Integer deviceType;

    /**
     * （T100等）
     */

    private String deviceName;

    /**
     *
     */

    private String carNo;

    /**
     * SIM卡号
     */

    private String sim;

    /**
     * 图片
     */

    private String image;

    /**
     * 备注
     */

    private String remark;

    /**
     * vk返回信息
     */

    private String vkBackinfo;

    /**
     * t_gps_detail_action
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
     *
     * @return gps_detail_id
     */
    public Long getGpsDetailId() {
        return gpsDetailId;
    }

    /**
     *
     * @param gpsDetailId
     */
    public void setGpsDetailId(Long gpsDetailId) {
        this.gpsDetailId = gpsDetailId;
    }

    /**
     *
     * @return gps_detail_add_time
     */
    public Date getGpsDetailAddTime() {
        return gpsDetailAddTime;
    }

    /**
     *
     * @param gpsDetailAddTime
     */
    public void setGpsDetailAddTime(Date gpsDetailAddTime) {
        this.gpsDetailAddTime = gpsDetailAddTime;
    }

    /**
     * IMEI号
     *
     * @return imei IMEI号
     */
    public String getImei() {
        return imei;
    }

    /**
     * IMEI号
     *
     * @param imei
     *            IMEI号
     */
    public void setImei(String imei) {
        this.imei = imei == null ? null : imei.trim();
    }

    /**
     *
     * @return vin
     */
    public String getVin() {
        return vin;
    }

    /**
     *
     * @param vin
     */
    public void setVin(String vin) {
        this.vin = vin == null ? null : vin.trim();
    }

    /**
     * 工单类型
     *
     * @return bill_type 工单类型
     */
    public Integer getBillType() {
        return billType;
    }

    /**
     * 工单类型
     *
     * @param billType
     *            工单类型
     */
    public void setBillType(Integer billType) {
        this.billType = billType;
    }

    /**
     * 操作类型（0增加，1减少）
     *
     * @return type 操作类型（0增加，1减少）
     */
    public String getType() {
        return type;
    }

    /**
     * 操作类型（0增加，1减少）
     *
     * @param type
     *            操作类型（0增加，1减少）
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 操作员
     *
     * @return operator_id 操作员
     */
    public Long getOperatorId() {
        return operatorId;
    }

    /**
     * 操作员
     *
     * @param operatorId
     *            操作员
     */
    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    /**
     * 操作员
     *
     * @return operator_name 操作员
     */
    public String getOperatorName() {
        return operatorName;
    }

    /**
     * 操作员
     *
     * @param operatorName
     *            操作员
     */
    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName == null ? null : operatorName.trim();
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
     * 设备类型（0无线 1有线）
     *
     * @return device_type 设备类型（0无线 1有线）
     */
    public Integer getDeviceType() {
        return deviceType;
    }

    /**
     * 设备类型（0无线 1有线）
     *
     * @param deviceType
     *            设备类型（0无线 1有线）
     */
    public void setDeviceType(Integer deviceType) {
        this.deviceType = deviceType;
    }

    /**
     * （T100等）
     *
     * @return device_name （T100等）
     */
    public String getDeviceName() {
        return deviceName;
    }

    /**
     * （T100等）
     *
     * @param deviceName
     *            （T100等）
     */
    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName == null ? null : deviceName.trim();
    }

    /**
     *
     * @return car_no
     */
    public String getCarNo() {
        return carNo;
    }

    /**
     *
     * @param carNo
     */
    public void setCarNo(String carNo) {
        this.carNo = carNo == null ? null : carNo.trim();
    }

    /**
     * SIM卡号
     *
     * @return sim SIM卡号
     */
    public String getSim() {
        return sim;
    }

    /**
     * SIM卡号
     *
     * @param sim
     *            SIM卡号
     */
    public void setSim(String sim) {
        this.sim = sim == null ? null : sim.trim();
    }

    /**
     * 图片
     *
     * @return image 图片
     */
    public String getImage() {
        return image;
    }

    /**
     * 图片
     *
     * @param image
     *            图片
     */
    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    /**
     * 备注
     *
     * @return remark 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注
     *
     * @param remark
     *            备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * vk返回信息
     *
     * @return vk_backinfo vk返回信息
     */
    public String getVkBackinfo() {
        return vkBackinfo;
    }

    /**
     * vk返回信息
     *
     * @param vkBackinfo
     *            vk返回信息
     */
    public void setVkBackinfo(String vkBackinfo) {
        this.vkBackinfo = vkBackinfo == null ? null : vkBackinfo.trim();
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
        sb.append(", gpsDetailId=").append(gpsDetailId);
        sb.append(", gpsDetailAddTime=").append(gpsDetailAddTime);
        sb.append(", imei=").append(imei);
        sb.append(", vin=").append(vin);
        sb.append(", billType=").append(billType);
        sb.append(", type=").append(type);
        sb.append(", operatorId=").append(operatorId);
        sb.append(", operatorName=").append(operatorName);
        sb.append(", addTime=").append(addTime);
        sb.append(", deviceType=").append(deviceType);
        sb.append(", deviceName=").append(deviceName);
        sb.append(", carNo=").append(carNo);
        sb.append(", sim=").append(sim);
        sb.append(", image=").append(image);
        sb.append(", remark=").append(remark);
        sb.append(", vkBackinfo=").append(vkBackinfo);
        sb.append("]");
        return sb.toString();
    }
}