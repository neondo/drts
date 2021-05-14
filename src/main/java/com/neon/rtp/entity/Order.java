package com.neon.rtp.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author lee.
 */
public class Order implements Serializable{

    private static final long serialVersionUID = -3252446479769205380L;

    private Long id;

    private String orderNo;

    private Long userId;
    // 订单状态，处理中、已完成、未完成

    private Integer orderStatus;

    /**
     * 1000 审核正确，1001vin 码无法识别，1002 品牌维 护中，1003 品牌不在服务时间，1004 数据维护中，1005 只能查维保记录，1006 需要 发动机号，1007
     * 需要车牌号，1008 需要发动机号和车牌号，1009VIN 已购
     */

    private Integer checkCode;

    /**
     * 订单金额.
     */

    private BigDecimal orderMoney;

    /**
     * 支付金额.
     */

    private BigDecimal payMoney;

    private BigDecimal orderStandardMoney;

    /**
     * 购买时间.
     */

    private Date buyTime;

    /**
     * 订单确认时间
     */

    private Date confirmTime;

    /**
     * 支付时间.
     */

    private Date payTime;

    /**
     * 支付类型 0-余额 1-支付宝 2-微信 3-网银.
     */

    private Integer payType;

    private String vin;

    private String engineNo;

    private String carNo;

    /**
     * 订单来源，0:wap, 1:api.
     */

    private Integer source;

    /**
     * 第三方维修记录的orderid，方便以后可以直接用这个orderid获取维修记录.
     */

    private String thirdpartOrderid;

    /**
     * 订单类型 订单类型:  0-消费订单， 1-充值订单, 2-OCR订单, 3-核查模式，4-查询模式，5-事故保订单，6-车况保订单，7-车架保订单，8-新版VIN订单 ， 9-新版OCR订单，10-延保订单 ，11-精准估价，12-金融估价 ，13-保险  ,14-金融估价(new), 15-GPS产品 ,  16-检测报告 , 17-买车卖车线索 ,  18-检测90天回购保障 , 19-定制估价, 20-车型识别 ,21-金融查询 , 22-平行车保修  ,  23-车况估价 , 24-简版理赔 , 25-检测上门交通费订单 , 26-小工具订单 , 27-报告解析 , 28-估价结果保价订单 ,29-vin码解析 ,30-车辆违章, 31-代金券, 32-等比例代金券,33-违约金订单,34-差旅费订单,35-检测综合结果订单,36-通用估价,37-江浙沪皖版碰撞,38-技术服务费,39-安心保障
     */

    private Integer orderType;

    /**
     * 第一次查看报告时间.
     */

    private Date checkTime;

    /**
     * 订单是否删除<br/>
     * 0:未删除<br/>
     * 1:删除<br/>
     * 2:删除
     */

    private Integer deleted;

    /**
     * 订单是否超时<br/>
     * 0:未超时<br/>
     * 1:超时
     */

    private Boolean timeout;

    /**
     * 订单有效期.
     */

    private Integer expireDays;

    /**
     * 备注.
     */

    private String remark;

    /**
     * 扩展字段.
     */

    private String extend;

    private Integer refreshTimes;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the orderNo
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * @param orderNo the orderNo to set
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    /**
     * @return the orderStatus
     */
    public Integer getOrderStatus() {
        return orderStatus;
    }

    /**
     * @param orderStatus the orderStatus to set
     */
    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * @return the orderMoney
     */
    public BigDecimal getOrderMoney() {
        return orderMoney;
    }

    /**
     * @param orderMoney the orderMoney to set
     */
    public void setOrderMoney(BigDecimal orderMoney) {
        this.orderMoney = orderMoney;
    }

    /**
     * @return the payMoney
     */
    public BigDecimal getPayMoney() {
        return payMoney;
    }

    /**
     * @param payMoney the payMoney to set
     */
    public void setPayMoney(BigDecimal payMoney) {
        this.payMoney = payMoney;
    }

    /**
     * @return the buyTime
     */
    public Date getBuyTime() {
        return buyTime;
    }

    /**
     * @param buyTime the buyTime to set
     */
    public void setBuyTime(Date buyTime) {
        this.buyTime = buyTime;
    }

    /**
     * @return the payTime
     */
    public Date getPayTime() {
        return payTime;
    }

    /**
     * @param payTime the payTime to set
     */
    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    /**
     * @return the vin
     */
    public String getVin() {
        return vin;
    }

    /**
     * @param vin the vin to set
     */
    public void setVin(String vin) {
        this.vin = vin;
    }

    /**
     * @return the userId
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * @return the thirdpartOrderid
     */
    public String getThirdpartOrderid() {
        return thirdpartOrderid;
    }

    /**
     * @param thirdpartOrderid the thirdpartOrderid to set
     */
    public void setThirdpartOrderid(String thirdpartOrderid) {
        this.thirdpartOrderid = thirdpartOrderid;
    }

    /**
     * @return the source
     */
    public Integer getSource() {
        return source;
    }

    /**
     * @param source the source to set
     */
    public void setSource(Integer source) {
        this.source = source;
    }

    /**
     * @return the orderType
     */
    public Integer getOrderType() {
        return orderType;
    }

    /**
     * @param orderType the orderType to set
     */
    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    /**
     * @return the payType
     */
    public Integer getPayType() {
        return payType;
    }

    /**
     * @param payType the payType to set
     */
    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    /**
     * @return the checkTime
     */
    public Date getCheckTime() {
        return checkTime;
    }

    /**
     * @param checkTime the checkTime to set
     */
    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    /**
     * @param deleted the deleted to set
     */
    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    /**
     * @return the timeout
     */
    public Boolean getTimeout() {
        return timeout;
    }

    /**
     * @param timeout the timeout to set
     */
    public void setTimeout(Boolean timeout) {
        this.timeout = timeout;
    }

    /**
     * @return the deleted
     */
    public Integer getDeleted() {
        return deleted;
    }

    /**
     * @return the expireDays
     */
    public Integer getExpireDays() {
        return expireDays;
    }

    /**
     * @param expireDays the expireDays to set
     */
    public void setExpireDays(Integer expireDays) {
        this.expireDays = expireDays;
    }

    /**
     * @return the remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark the remark to set
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * @return the extend
     */
    public String getExtend() {
        return extend;
    }

    /**
     * @param extend the extend to set
     */
    public void setExtend(String extend) {
        this.extend = extend;
    }

    public Integer getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(Integer checkCode) {
        this.checkCode = checkCode;
    }

    public String getEngineNo() {
        return engineNo;
    }

    public void setEngineNo(String engineNo) {
        this.engineNo = engineNo;
    }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public Integer getRefreshTimes() {
        return refreshTimes;
    }

    public void setRefreshTimes(Integer refreshTimes) {
        this.refreshTimes = refreshTimes;
    }

    public Date getConfirmTime() {
        return confirmTime;
    }

    public void setConfirmTime(Date confirmTime) {
        this.confirmTime = confirmTime;
    }

    public BigDecimal getOrderStandardMoney() {
        return orderStandardMoney;
    }

    public void setOrderStandardMoney(BigDecimal orderStandardMoney) {
        this.orderStandardMoney = orderStandardMoney;
    }

    @Override
    public String toString() {
        return "Order [id=" + id + ", orderNo=" + orderNo + ", userId=" + userId + ", orderStatus=" + orderStatus + ", checkCode=" +
                checkCode + ", orderMoney=" + orderMoney + ", payMoney=" + payMoney + ", orderStandardMoney=" + orderStandardMoney +
                ", buyTime=" + buyTime + ", confirmTime=" + confirmTime + ", payTime=" + payTime + ", payType=" + payType + ", vin=" + vin +
                ", engineNo=" + engineNo + ", carNo=" + carNo + ", source=" + source + ", thirdpartOrderid=" + thirdpartOrderid +
                ", orderType=" + orderType + ", checkTime=" + checkTime + ", deleted=" + deleted + ", timeout=" + timeout + ", expireDays=" +
                expireDays + ", remark=" + remark + ", extend=" + extend + ", refreshTimes=" + refreshTimes +
                "]";
    }
}
