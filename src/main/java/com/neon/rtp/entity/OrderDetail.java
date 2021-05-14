package com.neon.rtp.entity;

import java.io.Serializable;
import java.util.Date;

public class OrderDetail implements Serializable{

    /**
     * 索引
     */
    private Long id;

    private Long brandId;

    public OrderDetail() {
    }

    public OrderDetail(String orderNo) {
        this.orderNo = orderNo;
    }

    /**
     * 订单详情.
     * @param orderNo 订单编号.
     * @param code    外键.
     * @param type    类型
     */
    public OrderDetail(String orderNo, Long code, Integer type) {
        this.orderNo = orderNo;
        this.code = code;
        this.type = type;
    }

    /**
     * 订单编号
     */
    private String orderNo;

    /**
     * 数据外键, 如报告id/保险数据id
     */

    private Long code;

    /**
     * 数据类型.报告/保险... <br/>
     * 0:默认值<br/>
     * 1:报告<br/>
     * 2:保险
     */

    private Integer type;

    /**
     * 数据来源平台 0-本地, 1-车鉴定
     */

    private Integer platform;

    /**
     * 获取报告结果码.    11011-客户/网络端网络 异常 , 11012-账号异常 ,11013-抓取服务器异常 , 11014-查询超过上限, 11051-服务器异常 ,  11052-机器人重试超过2次，查询失败  ,11053-机 器人已进入查询流程，但未查到记录 ,  1104-成功 ,  12011-VIN不可用 ,  1202-错误车牌号 ,  1203-错误发动机号, 9999-未知错误 ,14001-中转消息异常，13000 第三方渠道 不在工作时间  13001 是第三方渠道维护
     */

    private Integer resultCode;

    /**
     * 退款标志<br/>
     * 0:不需要退款 <br/>
     * 1:需要退款<br/>
     * 2:退款成功<br/>
     * 3:退款失败<br/>
     * 4:退款成功
     */

    private Integer flagReimBurse;

    /**
     * 数据生成时间
     */

    private Date updateTime;

    /**
     *
     */

    private String carNo;

    /**
     * 车牌号类型
     */

    private String carNoType;

    /**
     *
     */

    private String driverName;

    /**
     * 身份证号
     */

    private String idNo;

    /**
     * 用户下单时对应的产品档位ID
     */

    private String pid;

    /**
     * 下单所在城市的国标码
     */

    private Integer cityGbCode;

    /**
     * 产品版本（如order_type是维保，就是维保的版本）: 0-旧版;1-新版
     */

    private Integer productVersion;

    /**
     * 查询参数MD5值（新老维保用）
     */

    private String searchKey;

    /**
     * 查询结果key
     */

    private String resultKey;

    /**
     * 维保记录json对应的版本key值
     */

    private String reportVersionKey;

    /**
     * 报告解析方式: 0-旧版;1-新版
     */

    private Integer reportAnalysisWay;

    private String extend;

    private static final long serialVersionUID = -514916034860849117L;

    /**
     * 索引
     * @return id 索引
     */
    public Long getId() {
        return id;
    }

    /**
     * 索引
     * @param id 索引
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 订单编号
     * @return order_no 订单编号
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * 订单编号
     * @param orderNo 订单编号
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    /**
     * 数据外键, 如报告id/保险数据id
     * @return code 数据外键, 如报告id/保险数据id
     */
    public Long getCode() {
        return code;
    }

    /**
     * 数据外键, 如报告id/保险数据id
     * @param code 数据外键, 如报告id/保险数据id
     */
    public void setCode(Long code) {
        this.code = code;
    }

    /**
     * 数据类型.报告/保险...
     * @return type 数据类型.报告/保险...
     */
    public Integer getType() {
        return type;
    }

    /**
     * 数据类型.报告/保险...
     * @param type 数据类型.报告/保险...
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 数据来源平台 0-本地, 1-车鉴定
     * @return platform 数据来源平台 0-本地, 1-车鉴定
     */
    public Integer getPlatform() {
        return platform;
    }

    /**
     * 数据来源平台 0-本地, 1-车鉴定
     * @param platform 数据来源平台 0-本地, 1-车鉴定
     */
    public void setPlatform(Integer platform) {
        this.platform = platform;
    }

    /**
     * 获取报告结果码.    11011-客户/网络端网络 异常 , 11012-账号异常 ,11013-抓取服务器异常 , 11014-查询超过上限, 11051-服务器异常 ,  11052-机器人重试超过2次，查询失败  ,11053-机 器人已进入查询流程，但未查到记录 ,  1104-成功 ,  12011-VIN不可用 ,  1202-错误车牌号 ,  1203-错误发动机号, 9999-未知错误 ,14001-中转消息异常，13000 第三方渠道 不在工作时间  13001 是第三方渠道维护
     * @return result_code 获取报告结果码.    11011-客户/网络端网络 异常 , 11012-账号异常 ,11013-抓取服务器异常 , 11014-查询超过上限, 11051-服务器异常 ,  11052-机器人重试超过2次，查询失败  ,11053-机 器人已进入查询流程，但未查到记录 ,  1104-成功 ,  12011-VIN不可用 ,  1202-错误车牌号 ,  1203-错误发动机号, 9999-未知错误 ,14001-中转消息异常，13000 第三方渠道 不在工作时间  13001 是第三方渠道维护
     */
    public Integer getResultCode() {
        return resultCode;
    }

    /**
     * 获取报告结果码.    11011-客户/网络端网络 异常 , 11012-账号异常 ,11013-抓取服务器异常 , 11014-查询超过上限, 11051-服务器异常 ,  11052-机器人重试超过2次，查询失败  ,11053-机 器人已进入查询流程，但未查到记录 ,  1104-成功 ,  12011-VIN不可用 ,  1202-错误车牌号 ,  1203-错误发动机号, 9999-未知错误 ,14001-中转消息异常，13000 第三方渠道 不在工作时间  13001 是第三方渠道维护
     * @param resultCode 获取报告结果码.    11011-客户/网络端网络 异常 , 11012-账号异常 ,11013-抓取服务器异常 , 11014-查询超过上限, 11051-服务器异常 ,  11052-机器人重试超过2次，查询失败  ,11053-机 器人已进入查询流程，但未查到记录 ,  1104-成功 ,  12011-VIN不可用 ,  1202-错误车牌号 ,  1203-错误发动机号, 9999-未知错误 ,14001-中转消息异常，13000 第三方渠道 不在工作时间  13001 是第三方渠道维护
     */
    public void setResultCode(Integer resultCode) {
        this.resultCode = resultCode;
    }

    public Integer getFlagReimBurse() {
        return flagReimBurse;
    }

    public void setFlagReimBurse(Integer flagReimBurse) {
        this.flagReimBurse = flagReimBurse;
    }

    /**
     * 数据生成时间
     * @return update_time 数据生成时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 数据生成时间
     * @param updateTime 数据生成时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return car_no
     */
    public String getCarNo() {
        return carNo;
    }

    /**
     *
     */
    public void setCarNo(String carNo) {
        this.carNo = carNo == null ? null : carNo.trim();
    }

    /**
     * 车牌号类型
     * @return car_no_type 车牌号类型
     */
    public String getCarNoType() {
        return carNoType;
    }

    /**
     * 车牌号类型
     * @param carNoType 车牌号类型
     */
    public void setCarNoType(String carNoType) {
        this.carNoType = carNoType == null ? null : carNoType.trim();
    }

    /**
     * @return driver_name
     */
    public String getDriverName() {
        return driverName;
    }

    /**
     *
     */
    public void setDriverName(String driverName) {
        this.driverName = driverName == null ? null : driverName.trim();
    }

    /**
     * 身份证号
     * @return id_no 身份证号
     */
    public String getIdNo() {
        return idNo;
    }

    /**
     * 身份证号
     * @param idNo 身份证号
     */
    public void setIdNo(String idNo) {
        this.idNo = idNo == null ? null : idNo.trim();
    }

    /**
     * 用户下单时对应的产品档位ID
     * @return pid 用户下单时对应的产品档位ID
     */
    public String getPid() {
        return pid;
    }

    /**
     * 用户下单时对应的产品档位ID
     * @param pid 用户下单时对应的产品档位ID
     */
    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    /**
     * 下单所在城市的国标码
     * @return city_gb_code 下单所在城市的国标码
     */
    public Integer getCityGbCode() {
        return cityGbCode;
    }

    /**
     * 下单所在城市的国标码
     * @param cityGbCode 下单所在城市的国标码
     */
    public void setCityGbCode(Integer cityGbCode) {
        this.cityGbCode = cityGbCode;
    }

    /**
     * 产品版本（如order_type是维保，就是维保的版本）: 0-旧版;1-新版
     * @return product_version 产品版本（如order_type是维保，就是维保的版本）: 0-旧版;1-新版
     */
    public Integer getProductVersion() {
        return productVersion;
    }

    /**
     * 产品版本（如order_type是维保，就是维保的版本）: 0-旧版;1-新版
     * @param productVersion 产品版本（如order_type是维保，就是维保的版本）: 0-旧版;1-新版
     */
    public void setProductVersion(Integer productVersion) {
        this.productVersion = productVersion;
    }

    /**
     * 查询参数MD5值（新老维保用）
     * @return search_key 查询参数MD5值（新老维保用）
     */
    public String getSearchKey() {
        return searchKey;
    }

    /**
     * 查询参数MD5值（新老维保用）
     * @param searchKey 查询参数MD5值（新老维保用）
     */
    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey == null ? null : searchKey.trim();
    }

    /**
     * 查询结果key
     * @return result_key 查询结果key
     */
    public String getResultKey() {
        return resultKey;
    }

    /**
     * 查询结果key
     * @param resultKey 查询结果key
     */
    public void setResultKey(String resultKey) {
        this.resultKey = resultKey == null ? null : resultKey.trim();
    }

    /**
     * 维保记录json对应的版本key值
     * @return report_version_key 维保记录json对应的版本key值
     */
    public String getReportVersionKey() {
        return reportVersionKey;
    }

    /**
     * 维保记录json对应的版本key值
     * @param reportVersionKey 维保记录json对应的版本key值
     */
    public void setReportVersionKey(String reportVersionKey) {
        this.reportVersionKey = reportVersionKey == null ? null : reportVersionKey.trim();
    }

    /**
     * 报告解析方式: 0-旧版;1-新版
     * @return report_analysis_way 报告解析方式: 0-旧版;1-新版
     */
    public Integer getReportAnalysisWay() {
        return reportAnalysisWay;
    }

    /**
     * 报告解析方式: 0-旧版;1-新版
     * @param reportAnalysisWay 报告解析方式: 0-旧版;1-新版
     */
    public void setReportAnalysisWay(Integer reportAnalysisWay) {
        this.reportAnalysisWay = reportAnalysisWay;
    }

    public String getExtend() {
        return extend;
    }

    public void setExtend(String extend) {
        this.extend = extend;
    }

    /**
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
        sb.append(", code=").append(code);
        sb.append(", type=").append(type);
        sb.append(", platform=").append(platform);
        sb.append(", resultCode=").append(resultCode);
        sb.append(", flagReimburse=").append(flagReimBurse);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", carNo=").append(carNo);
        sb.append(", carNoType=").append(carNoType);
        sb.append(", driverName=").append(driverName);
        sb.append(", idNo=").append(idNo);
        sb.append(", pid=").append(pid);
        sb.append(", cityGbCode=").append(cityGbCode);
        sb.append(", productVersion=").append(productVersion);
        sb.append(", searchKey=").append(searchKey);
        sb.append(", resultKey=").append(resultKey);
        sb.append(", reportVersionKey=").append(reportVersionKey);
        sb.append(", reportAnalysisWay=").append(reportAnalysisWay);
        sb.append(", extends=").append(extend);
        sb.append("]");
        return sb.toString();
    }
}