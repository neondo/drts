package com.neon.rtp.entity;







import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



public class InsurenceDetail implements Serializable {
    /**
     *
     */


    private Long id;

    /**
     * 订单号
     */

    private String orderNo;

    /**
     * 用户id
     */

    private Long userId;

    /**
     * vin对应报告的订单报告
     */

    private String orderNoReport;

    /**
     * 10001-前置付款流程待付款 , 10010-待分配,10020-已分配,10021-第三方待检测,10022-第三方检测工具完成, 10026-检测师已出发,10027-交通费待补交,10030-待付款,10040-待检测,10041-搁置,10050-待承保,10051-检测师取消订单待审核 ,10052-申请异常报告,10053-申请高危异常报告,10054-待区总审核, 10055-审核中,10060-审核通过,10070-审核不通过,10071-自营审核不通过,10080-第三方承保失败（保留状态）,10090-已取消 ,10091-已结束
     */

    private Integer status;

    /**
     * 姓名
     */

    private String name;

    /**
     * 地址
     */

    private String address;

    /**
     * 手机号
     */

    private String mobile;

    /**
     * 城市id
     */

    private Long cityId;

    /**
     * 主管id
     */

    private Long ownUserId;

    /**
     * 检测师id
     */

    private Long ownUserIdCheck;

    /**
     * 下单人id
     */

    private Long ownUserIdOrder;

    /**
     * 审核人id
     */

    private Long ownUserIdAuditor;

    /**
     * 车架号
     */

    private String vin;

    /**
     * 车牌号
     */

    private String carNo;

    /**
     * 发动机号
     */

    private String engineNo;

    /**
     * 车身颜色
     */

    private String carColor;

    /**
     * t_support_brand_model表id,等同t_valuation_brand表的id
     */

    private Long valuationBrandId;

    /**
     * 补填信息时间
     */

    private Date fillTime;

    /**
     *
     */

    private Date addTime;

    /**
     *
     */

    private Date updateTime;

    /**
     * 产品子类型: 事故保 {1 本地、2 异地、3 本地初检、4 本地复检、5 异地初检、6 异地复检、7 58放心车、8 金融检测、9 58_A套餐、10 58异地检、11  远程检测   、12  延保前置检测、13 金融估价-远程检测  、 14  金融估价-实车检测  、15  58放心车活动、 98 先锋太盟远程检测 、 99  中古检测 、100 SKU自定义检测 }   ； 车况保 {1 A套餐 、2 B套餐 、3 A套餐初检、4 A套餐复检、5 B套餐初检、6 B套餐复检 、7 58延保、8 58_B套餐、9 延保检测 、 10 卓杰行检测 }
     */

    private Integer type;

    /**
     * 备注json格式 (内容： date - 时间，own_user_name - 操作人,role_name - 角色名称,content - 备注内容)
     */

    private String remark;

    /**
     * 0：1.0版检测流程 ，1：2.0版检测流程
     */

    private Integer version;

    /**
     * 车商 id
     */

    private Long carDealerId;

    /**
     * 车商的产品价格
     */

    private BigDecimal carDealerPrice;

    /**
     * 第三方订单号
     */

    private String thirdpartOrderId;

    /**
     * 最大估值
     */

    private Double maxValuation;

    /**
     * 最小估值
     */

    private Double minValuation;

    /**
     * 检测完成时间
     */

    private Date detectionFinishTime;

    /**
     * 审核通过时间
     */

    private Date auditPassTime;

    /**
     * 金融估价结果（json格式）
     */

    private String valuationContent;

    /**
     * 模板id
     */

    private Long templateId;

    /**
     * 检测权重
     */

    private Long weights;

    /**
     * 检测师场内或场外工作： 1-场内(服务中心) ； 2-场外(上门检测)
     */

    private Integer inOrOut;

    /**
     * 第三方帖子状态：1: 正常状态，2 : 冻结状态
     */

    private Integer thirdpartStatus;

    /**
     * 操作类型： 4-过期检测
     */

    private Integer optType;

    /**
     * 检测结果上传进度：1-上传完成
     */

    private BigDecimal remain;

    /**
     * 订单类型:  0-消费订单， 1-充值订单, 2-OCR订单, 3-核查模式，4-查询模式，5-事故保订单，6-车况保订单，7-车架保订单，8-新版VIN订单 ， 9-新版OCR订单，10-延保订单 ，11-精准估价，12-金融估价 ，13-保险  ,14-金融估价(new), 15-GPS产品 ,  16-检测报告 , 17-买车卖车线索 ,  18-检测90天回购保障 , 19-定制估价, 20-车型识别 ,21-金融查询 , 22-平行车保修  ,  23-车况估价 , 24-简版理赔 , 25-检测上门交通费订单 , 26-小工具订单 , 27-报告解析 , 28-估价结果保价订单 ,29-vin码解析 ,30-车辆违章, 31-代金券, 32-等比例代金券,33-违约金订单
     */

    private Integer orderType;

    /**
     * 修理厂id(t_fix_user表id)
     */

    private Long fixUserId;

    /**
     * 检测进度
     */

    private String detectionStep;

    /**
     * 检测建议
     */

    private String tip;

    /**
     * 检测上门交通费订单号
     */

    private String serveOrderNo;

    /**
     * 检测服务站id（t_detection_service_center表id, 注：如果是上门检测订单，这个字段记录的是计算上门检测距离的服务中心id）
     */

    private Long serviceCenterId;

    /**
     * 检测地址经度
     */

    private String addressLongitude;

    /**
     * 检测地址纬度
     */

    private String addressLatitude;

    /**
     * 增值服务ids
     */

    private String extraids;

    /**
     * 是否被抽检：0-否； 1-是；
     */

    private Boolean isChecked;

    /**
     * 打卡照片
     */

    private String signInPic;

    /**
     * 出行方式: 1-步行,2-旅行,3-公共交通,4-自驾,5-出租车,6-动车/高铁
     */

    private Integer wayToTravel;

    /**
     * 打卡地点
     */

    private String signInAddress;

    /**
     * 打卡时间
     */

    private Date signInTime;

    /**
     * 检测是否延迟：0-未延迟 ； 1-延迟；
     */

    private Boolean delayState;

    /**
     * 上门检测出发点经度
     */

    private String startLongitude;

    /**
     * 上门检测出发点纬度
     */

    private String startLatitude;

    /**
     * 违约金订单号(Liquidated Damage orderno )
     */

    private String ldOrderNo;

    /**
     * 违约金扣除条件(JSON:  preSubStatus:提交检测取消时订单状态，statusTime10026:检测师出发时间,spanTimeMin:检测师出发时间与取消时间间隔,deductionRatio:扣除违约金比例)
     */

    private String ldCondition;

    /**
     * 上门检测的路线距离(米)
     */

    private String distance;

    /**
     * 下单终端的地址
     */

    private String createOrderAddress;

    /**
     * (远程检测)检测订单是否兜底 0-不兜底，1-兜底
     */

    private Boolean guarantee;

    /**
     * 差旅费订单号
     */

    private String travelOrderNo;

    /**
     * 预计差旅费用
     */

    private BigDecimal estimateTravelFee;

    /**
     * t_support_brand表的id
     */

    private Long brandId;

    /**
     * t_support_brand_series表的id
     */

    private Long seriesId;

    /**
     * 是否异地下单：0-否 ； 1-是 （下单地点和检测地点不在一个城市算异地）
     */

    private Boolean isDifferentPlace;

    /**
     * 常驻城市id
     */

    private Long residentCityId;

    /**
     * 推送报告状态：0-未推送；1-已推送
     */

    private Boolean pushReportStatus;

    /**
     * 汽车标识：1-新车；2-二手车
     */

    private Integer carFlag;

    /**
     * 预计检测时间
     */

    private Date expectDetectionTime;

    /**
     * 上门检测变更为到店检测的时间
     */

    private Date out2inTime;

    /**
     * 拆解检测级别：1、一级检测;  2、二级拆解检测;  3、三级拆解检测
     */

    private Integer splitLevel;

    /**
     * 检测师到达经度
     */

    private String arriveLongitude;

    /**
     * 检测师到达纬度
     */

    private String arriveLatitude;

    /**
     * 通用估价订单号
     */

    private String currencyAssessOrderNo;

    /**
     * 交通费
     */

    private BigDecimal travelCost;

    /**
     * 是否使用安心保障
     */

    private Boolean isGuarantee;

    /**
     * 升级套餐前的订单号(来源订单号)
     */

    private String fromOrderNo;

    /**
     * 是否在APP端展示：0-否； 1-是
     */

    private Boolean isAppShow;

    /**
     * 评分标准id( t_detection_v2_score_standard的id)
     */

    private Long scoreStandardId;

    /**
     * 第三方检测完成时间
     */

    private Date thirdpartFinishTime;

    /**
     * 批量下单的批次号
     */

    private String batchCode;

    /**
     * 当前套餐是否可升级：0-不可升级； 1-可升级
     */

    private Boolean upgradeSign;

    /**
     * 订单附加的安心保障项
     */

    private String guaranteeItems;

    /**
     * 状态变更时间
     */

    private Date statusChangeTime;

    /**
     * 付款时间
     */

    private Date payTime;

    /**
     * 预约配置表的id(t_detection_reservation_config)
     */

    private Long reservationConfigId;

    /**
     * 预约日期
     */

    private Date reservationDay;

    /**
     * 预约状态：0-不是预约单;1-直接下单;2-预约成功;3-预约失败
     */

    private Integer reservationStatus;

    /**
     * 打卡城市
     */

    private Integer signCityId;

    /**
     * 预约检测时间
     */

    private String reservationDetectionTime;

    /**
     * 订单特殊开关配置(如检测过程中可以添加附加项)
     */

    private String switchConfig;

    /**
     * 第三方检测类型 1-用户;2-车商
     */

    private Integer thirdpartType;

    /**
     * json字段：warrantyDealWith 延保检测订单是否需要处理 0是需要处理，1是不需要处理； 注意！还存在其他字段！
     */

    private String extend;

    /**
     * t_insurence_detail
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
     * vin对应报告的订单报告
     * @return order_no_report vin对应报告的订单报告
     */
    public String getOrderNoReport() {
        return orderNoReport;
    }

    /**
     * vin对应报告的订单报告
     * @param orderNoReport vin对应报告的订单报告
     */
    public void setOrderNoReport(String orderNoReport) {
        this.orderNoReport = orderNoReport == null ? null : orderNoReport.trim();
    }

    /**
     * 10001-前置付款流程待付款 , 10010-待分配,10020-已分配,10021-第三方待检测,10022-第三方检测工具完成, 10026-检测师已出发,10027-交通费待补交,10030-待付款,10040-待检测,10041-搁置,10050-待承保,10051-检测师取消订单待审核 ,10052-申请异常报告,10053-申请高危异常报告,10054-待区总审核, 10055-审核中,10060-审核通过,10070-审核不通过,10071-自营审核不通过,10080-第三方承保失败（保留状态）,10090-已取消 ,10091-已结束
     * @return status 10001-前置付款流程待付款 , 10010-待分配,10020-已分配,10021-第三方待检测,10022-第三方检测工具完成, 10026-检测师已出发,10027-交通费待补交,10030-待付款,10040-待检测,10041-搁置,10050-待承保,10051-检测师取消订单待审核 ,10052-申请异常报告,10053-申请高危异常报告,10054-待区总审核, 10055-审核中,10060-审核通过,10070-审核不通过,10071-自营审核不通过,10080-第三方承保失败（保留状态）,10090-已取消 ,10091-已结束
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 10001-前置付款流程待付款 , 10010-待分配,10020-已分配,10021-第三方待检测,10022-第三方检测工具完成, 10026-检测师已出发,10027-交通费待补交,10030-待付款,10040-待检测,10041-搁置,10050-待承保,10051-检测师取消订单待审核 ,10052-申请异常报告,10053-申请高危异常报告,10054-待区总审核, 10055-审核中,10060-审核通过,10070-审核不通过,10071-自营审核不通过,10080-第三方承保失败（保留状态）,10090-已取消 ,10091-已结束
     * @param status 10001-前置付款流程待付款 , 10010-待分配,10020-已分配,10021-第三方待检测,10022-第三方检测工具完成, 10026-检测师已出发,10027-交通费待补交,10030-待付款,10040-待检测,10041-搁置,10050-待承保,10051-检测师取消订单待审核 ,10052-申请异常报告,10053-申请高危异常报告,10054-待区总审核, 10055-审核中,10060-审核通过,10070-审核不通过,10071-自营审核不通过,10080-第三方承保失败（保留状态）,10090-已取消 ,10091-已结束
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 姓名
     * @return name 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 姓名
     * @param name 姓名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 地址
     * @return address 地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 地址
     * @param address 地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 手机号
     * @return mobile 手机号
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 手机号
     * @param mobile 手机号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * 城市id
     * @return city_id 城市id
     */
    public Long getCityId() {
        return cityId;
    }

    /**
     * 城市id
     * @param cityId 城市id
     */
    public void setCityId(Long cityId) {
        this.cityId = cityId;
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
     * @return own_user_id_check 检测师id
     */
    public Long getOwnUserIdCheck() {
        return ownUserIdCheck;
    }

    /**
     * 检测师id
     * @param ownUserIdCheck 检测师id
     */
    public void setOwnUserIdCheck(Long ownUserIdCheck) {
        this.ownUserIdCheck = ownUserIdCheck;
    }

    /**
     * 下单人id
     * @return own_user_id_order 下单人id
     */
    public Long getOwnUserIdOrder() {
        return ownUserIdOrder;
    }

    /**
     * 下单人id
     * @param ownUserIdOrder 下单人id
     */
    public void setOwnUserIdOrder(Long ownUserIdOrder) {
        this.ownUserIdOrder = ownUserIdOrder;
    }

    /**
     * 审核人id
     * @return own_user_id_auditor 审核人id
     */
    public Long getOwnUserIdAuditor() {
        return ownUserIdAuditor;
    }

    /**
     * 审核人id
     * @param ownUserIdAuditor 审核人id
     */
    public void setOwnUserIdAuditor(Long ownUserIdAuditor) {
        this.ownUserIdAuditor = ownUserIdAuditor;
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
     * 发动机号
     * @return engine_no 发动机号
     */
    public String getEngineNo() {
        return engineNo;
    }

    /**
     * 发动机号
     * @param engineNo 发动机号
     */
    public void setEngineNo(String engineNo) {
        this.engineNo = engineNo == null ? null : engineNo.trim();
    }

    /**
     * 车身颜色
     * @return car_color 车身颜色
     */
    public String getCarColor() {
        return carColor;
    }

    /**
     * 车身颜色
     * @param carColor 车身颜色
     */
    public void setCarColor(String carColor) {
        this.carColor = carColor == null ? null : carColor.trim();
    }

    /**
     * t_support_brand_model表id,等同t_valuation_brand表的id
     * @return valuation_brand_id t_support_brand_model表id,等同t_valuation_brand表的id
     */
    public Long getValuationBrandId() {
        return valuationBrandId;
    }

    /**
     * t_support_brand_model表id,等同t_valuation_brand表的id
     * @param valuationBrandId t_support_brand_model表id,等同t_valuation_brand表的id
     */
    public void setValuationBrandId(Long valuationBrandId) {
        this.valuationBrandId = valuationBrandId;
    }

    /**
     * 补填信息时间
     * @return fill_time 补填信息时间
     */
    public Date getFillTime() {
        return fillTime;
    }

    /**
     * 补填信息时间
     * @param fillTime 补填信息时间
     */
    public void setFillTime(Date fillTime) {
        this.fillTime = fillTime;
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
     * 产品子类型: 事故保 {1 本地、2 异地、3 本地初检、4 本地复检、5 异地初检、6 异地复检、7 58放心车、8 金融检测、9 58_A套餐、10 58异地检、11  远程检测   、12  延保前置检测、13 金融估价-远程检测  、 14  金融估价-实车检测  、15  58放心车活动、 98 先锋太盟远程检测 、 99  中古检测 、100 SKU自定义检测 }   ； 车况保 {1 A套餐 、2 B套餐 、3 A套餐初检、4 A套餐复检、5 B套餐初检、6 B套餐复检 、7 58延保、8 58_B套餐、9 延保检测 、 10 卓杰行检测 }
     * @return type 产品子类型: 事故保 {1 本地、2 异地、3 本地初检、4 本地复检、5 异地初检、6 异地复检、7 58放心车、8 金融检测、9 58_A套餐、10 58异地检、11  远程检测   、12  延保前置检测、13 金融估价-远程检测  、 14  金融估价-实车检测  、15  58放心车活动、 98 先锋太盟远程检测 、 99  中古检测 、100 SKU自定义检测 }   ； 车况保 {1 A套餐 、2 B套餐 、3 A套餐初检、4 A套餐复检、5 B套餐初检、6 B套餐复检 、7 58延保、8 58_B套餐、9 延保检测 、 10 卓杰行检测 }
     */
    public Integer getType() {
        return type;
    }

    /**
     * 产品子类型: 事故保 {1 本地、2 异地、3 本地初检、4 本地复检、5 异地初检、6 异地复检、7 58放心车、8 金融检测、9 58_A套餐、10 58异地检、11  远程检测   、12  延保前置检测、13 金融估价-远程检测  、 14  金融估价-实车检测  、15  58放心车活动、 98 先锋太盟远程检测 、 99  中古检测 、100 SKU自定义检测 }   ； 车况保 {1 A套餐 、2 B套餐 、3 A套餐初检、4 A套餐复检、5 B套餐初检、6 B套餐复检 、7 58延保、8 58_B套餐、9 延保检测 、 10 卓杰行检测 }
     * @param type 产品子类型: 事故保 {1 本地、2 异地、3 本地初检、4 本地复检、5 异地初检、6 异地复检、7 58放心车、8 金融检测、9 58_A套餐、10 58异地检、11  远程检测   、12  延保前置检测、13 金融估价-远程检测  、 14  金融估价-实车检测  、15  58放心车活动、 98 先锋太盟远程检测 、 99  中古检测 、100 SKU自定义检测 }   ； 车况保 {1 A套餐 、2 B套餐 、3 A套餐初检、4 A套餐复检、5 B套餐初检、6 B套餐复检 、7 58延保、8 58_B套餐、9 延保检测 、 10 卓杰行检测 }
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 备注json格式 (内容： date - 时间，own_user_name - 操作人,role_name - 角色名称,content - 备注内容)
     * @return remark 备注json格式 (内容： date - 时间，own_user_name - 操作人,role_name - 角色名称,content - 备注内容)
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注json格式 (内容： date - 时间，own_user_name - 操作人,role_name - 角色名称,content - 备注内容)
     * @param remark 备注json格式 (内容： date - 时间，own_user_name - 操作人,role_name - 角色名称,content - 备注内容)
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 0：1.0版检测流程 ，1：2.0版检测流程
     * @return version 0：1.0版检测流程 ，1：2.0版检测流程
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * 0：1.0版检测流程 ，1：2.0版检测流程
     * @param version 0：1.0版检测流程 ，1：2.0版检测流程
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * 车商 id
     * @return car_dealer_id 车商 id
     */
    public Long getCarDealerId() {
        return carDealerId;
    }

    /**
     * 车商 id
     * @param carDealerId 车商 id
     */
    public void setCarDealerId(Long carDealerId) {
        this.carDealerId = carDealerId;
    }

    /**
     * 车商的产品价格
     * @return car_dealer_price 车商的产品价格
     */
    public BigDecimal getCarDealerPrice() {
        return carDealerPrice;
    }

    /**
     * 车商的产品价格
     * @param carDealerPrice 车商的产品价格
     */
    public void setCarDealerPrice(BigDecimal carDealerPrice) {
        this.carDealerPrice = carDealerPrice;
    }

    /**
     * 第三方订单号
     * @return thirdpart_orderid 第三方订单号
     */
    public String getThirdpartOrderId() {
        return thirdpartOrderId;
    }

    /**
     * 第三方订单号
     * @param thirdpartOrderId 第三方订单号
     */
    public void setThirdpartOrderId(String thirdpartOrderId) {
        this.thirdpartOrderId = thirdpartOrderId == null ? null : thirdpartOrderId.trim();
    }

    /**
     * 最大估值
     * @return max_valuation 最大估值
     */
    public Double getMaxValuation() {
        return maxValuation;
    }

    /**
     * 最大估值
     * @param maxValuation 最大估值
     */
    public void setMaxValuation(Double maxValuation) {
        this.maxValuation = maxValuation;
    }

    /**
     * 最小估值
     * @return min_valuation 最小估值
     */
    public Double getMinValuation() {
        return minValuation;
    }

    /**
     * 最小估值
     * @param minValuation 最小估值
     */
    public void setMinValuation(Double minValuation) {
        this.minValuation = minValuation;
    }

    /**
     * 检测完成时间
     * @return detection_finish_time 检测完成时间
     */
    public Date getDetectionFinishTime() {
        return detectionFinishTime;
    }

    /**
     * 检测完成时间
     * @param detectionFinishTime 检测完成时间
     */
    public void setDetectionFinishTime(Date detectionFinishTime) {
        this.detectionFinishTime = detectionFinishTime;
    }

    /**
     * 审核通过时间
     * @return audit_pass_time 审核通过时间
     */
    public Date getAuditPassTime() {
        return auditPassTime;
    }

    /**
     * 审核通过时间
     * @param auditPassTime 审核通过时间
     */
    public void setAuditPassTime(Date auditPassTime) {
        this.auditPassTime = auditPassTime;
    }

    /**
     * 金融估价结果（json格式）
     * @return valuation_content 金融估价结果（json格式）
     */
    public String getValuationContent() {
        return valuationContent;
    }

    /**
     * 金融估价结果（json格式）
     * @param valuationContent 金融估价结果（json格式）
     */
    public void setValuationContent(String valuationContent) {
        this.valuationContent = valuationContent == null ? null : valuationContent.trim();
    }

    /**
     * 模板id
     * @return template_id 模板id
     */
    public Long getTemplateId() {
        return templateId;
    }

    /**
     * 模板id
     * @param templateId 模板id
     */
    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }

    /**
     * 检测权重
     * @return weights 检测权重
     */
    public Long getWeights() {
        return weights;
    }

    /**
     * 检测权重
     * @param weights 检测权重
     */
    public void setWeights(Long weights) {
        this.weights = weights;
    }

    /**
     * 检测师场内或场外工作： 1-场内(服务中心) ； 2-场外(上门检测)
     * @return in_or_out 检测师场内或场外工作： 1-场内(服务中心) ； 2-场外(上门检测)
     */
    public Integer getInOrOut() {
        return inOrOut;
    }

    /**
     * 检测师场内或场外工作： 1-场内(服务中心) ； 2-场外(上门检测)
     * @param inOrOut 检测师场内或场外工作： 1-场内(服务中心) ； 2-场外(上门检测)
     */
    public void setInOrOut(Integer inOrOut) {
        this.inOrOut = inOrOut;
    }

    /**
     * 第三方帖子状态：1: 正常状态，2 : 冻结状态
     * @return thirdpart_status 第三方帖子状态：1: 正常状态，2 : 冻结状态
     */
    public Integer getThirdpartStatus() {
        return thirdpartStatus;
    }

    /**
     * 第三方帖子状态：1: 正常状态，2 : 冻结状态
     * @param thirdpartStatus 第三方帖子状态：1: 正常状态，2 : 冻结状态
     */
    public void setThirdpartStatus(Integer thirdpartStatus) {
        this.thirdpartStatus = thirdpartStatus;
    }

    /**
     * 操作类型： 4-过期检测
     * @return opt_type 操作类型： 4-过期检测
     */
    public Integer getOptType() {
        return optType;
    }

    /**
     * 操作类型： 4-过期检测
     * @param optType 操作类型： 4-过期检测
     */
    public void setOptType(Integer optType) {
        this.optType = optType;
    }

    /**
     * 检测结果上传进度：1-上传完成
     * @return remain 检测结果上传进度：1-上传完成
     */
    public BigDecimal getRemain() {
        return remain;
    }

    /**
     * 检测结果上传进度：1-上传完成
     * @param remain 检测结果上传进度：1-上传完成
     */
    public void setRemain(BigDecimal remain) {
        this.remain = remain;
    }

    /**
     * 订单类型:  0-消费订单， 1-充值订单, 2-OCR订单, 3-核查模式，4-查询模式，5-事故保订单，6-车况保订单，7-车架保订单，8-新版VIN订单 ， 9-新版OCR订单，10-延保订单 ，11-精准估价，12-金融估价 ，13-保险  ,14-金融估价(new), 15-GPS产品 ,  16-检测报告 , 17-买车卖车线索 ,  18-检测90天回购保障 , 19-定制估价, 20-车型识别 ,21-金融查询 , 22-平行车保修  ,  23-车况估价 , 24-简版理赔 , 25-检测上门交通费订单 , 26-小工具订单 , 27-报告解析 , 28-估价结果保价订单 ,29-vin码解析 ,30-车辆违章, 31-代金券, 32-等比例代金券,33-违约金订单
     * @return order_type 订单类型:  0-消费订单， 1-充值订单, 2-OCR订单, 3-核查模式，4-查询模式，5-事故保订单，6-车况保订单，7-车架保订单，8-新版VIN订单 ， 9-新版OCR订单，10-延保订单 ，11-精准估价，12-金融估价 ，13-保险  ,14-金融估价(new), 15-GPS产品 ,  16-检测报告 , 17-买车卖车线索 ,  18-检测90天回购保障 , 19-定制估价, 20-车型识别 ,21-金融查询 , 22-平行车保修  ,  23-车况估价 , 24-简版理赔 , 25-检测上门交通费订单 , 26-小工具订单 , 27-报告解析 , 28-估价结果保价订单 ,29-vin码解析 ,30-车辆违章, 31-代金券, 32-等比例代金券,33-违约金订单
     */
    public Integer getOrderType() {
        return orderType;
    }

    /**
     * 订单类型:  0-消费订单， 1-充值订单, 2-OCR订单, 3-核查模式，4-查询模式，5-事故保订单，6-车况保订单，7-车架保订单，8-新版VIN订单 ， 9-新版OCR订单，10-延保订单 ，11-精准估价，12-金融估价 ，13-保险  ,14-金融估价(new), 15-GPS产品 ,  16-检测报告 , 17-买车卖车线索 ,  18-检测90天回购保障 , 19-定制估价, 20-车型识别 ,21-金融查询 , 22-平行车保修  ,  23-车况估价 , 24-简版理赔 , 25-检测上门交通费订单 , 26-小工具订单 , 27-报告解析 , 28-估价结果保价订单 ,29-vin码解析 ,30-车辆违章, 31-代金券, 32-等比例代金券,33-违约金订单
     * @param orderType 订单类型:  0-消费订单， 1-充值订单, 2-OCR订单, 3-核查模式，4-查询模式，5-事故保订单，6-车况保订单，7-车架保订单，8-新版VIN订单 ， 9-新版OCR订单，10-延保订单 ，11-精准估价，12-金融估价 ，13-保险  ,14-金融估价(new), 15-GPS产品 ,  16-检测报告 , 17-买车卖车线索 ,  18-检测90天回购保障 , 19-定制估价, 20-车型识别 ,21-金融查询 , 22-平行车保修  ,  23-车况估价 , 24-简版理赔 , 25-检测上门交通费订单 , 26-小工具订单 , 27-报告解析 , 28-估价结果保价订单 ,29-vin码解析 ,30-车辆违章, 31-代金券, 32-等比例代金券,33-违约金订单
     */
    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    /**
     * 修理厂id(t_fix_user表id)
     * @return fix_user_id 修理厂id(t_fix_user表id)
     */
    public Long getFixUserId() {
        return fixUserId;
    }

    /**
     * 修理厂id(t_fix_user表id)
     * @param fixUserId 修理厂id(t_fix_user表id)
     */
    public void setFixUserId(Long fixUserId) {
        this.fixUserId = fixUserId;
    }

    /**
     * 检测进度
     * @return detection_step 检测进度
     */
    public String getDetectionStep() {
        return detectionStep;
    }

    /**
     * 检测进度
     * @param detectionStep 检测进度
     */
    public void setDetectionStep(String detectionStep) {
        this.detectionStep = detectionStep == null ? null : detectionStep.trim();
    }

    /**
     * 检测建议
     * @return tip 检测建议
     */
    public String getTip() {
        return tip;
    }

    /**
     * 检测建议
     * @param tip 检测建议
     */
    public void setTip(String tip) {
        this.tip = tip == null ? null : tip.trim();
    }

    /**
     * 检测上门交通费订单号
     * @return serve_order_no 检测上门交通费订单号
     */
    public String getServeOrderNo() {
        return serveOrderNo;
    }

    /**
     * 检测上门交通费订单号
     * @param serveOrderNo 检测上门交通费订单号
     */
    public void setServeOrderNo(String serveOrderNo) {
        this.serveOrderNo = serveOrderNo == null ? null : serveOrderNo.trim();
    }

    /**
     * 检测服务站id（t_detection_service_center表id, 注：如果是上门检测订单，这个字段记录的是计算上门检测距离的服务中心id）
     * @return service_center_id 检测服务站id（t_detection_service_center表id, 注：如果是上门检测订单，这个字段记录的是计算上门检测距离的服务中心id）
     */
    public Long getServiceCenterId() {
        return serviceCenterId;
    }

    /**
     * 检测服务站id（t_detection_service_center表id, 注：如果是上门检测订单，这个字段记录的是计算上门检测距离的服务中心id）
     * @param serviceCenterId 检测服务站id（t_detection_service_center表id, 注：如果是上门检测订单，这个字段记录的是计算上门检测距离的服务中心id）
     */
    public void setServiceCenterId(Long serviceCenterId) {
        this.serviceCenterId = serviceCenterId;
    }

    /**
     * 检测地址经度
     * @return address_longitude 检测地址经度
     */
    public String getAddressLongitude() {
        return addressLongitude;
    }

    /**
     * 检测地址经度
     * @param addressLongitude 检测地址经度
     */
    public void setAddressLongitude(String addressLongitude) {
        this.addressLongitude = addressLongitude == null ? null : addressLongitude.trim();
    }

    /**
     * 检测地址纬度
     * @return address_latitude 检测地址纬度
     */
    public String getAddressLatitude() {
        return addressLatitude;
    }

    /**
     * 检测地址纬度
     * @param addressLatitude 检测地址纬度
     */
    public void setAddressLatitude(String addressLatitude) {
        this.addressLatitude = addressLatitude == null ? null : addressLatitude.trim();
    }

    /**
     * 增值服务ids
     * @return extraids 增值服务ids
     */
    public String getExtraids() {
        return extraids;
    }

    /**
     * 增值服务ids
     * @param extraids 增值服务ids
     */
    public void setExtraids(String extraids) {
        this.extraids = extraids == null ? null : extraids.trim();
    }

    /**
     * 是否被抽检：0-否； 1-是；
     * @return is_checked 是否被抽检：0-否； 1-是；
     */
    public Boolean getIsChecked() {
        return isChecked;
    }

    /**
     * 是否被抽检：0-否； 1-是；
     * @param isChecked 是否被抽检：0-否； 1-是；
     */
    public void setIsChecked(Boolean isChecked) {
        this.isChecked = isChecked;
    }

    /**
     * 打卡照片
     * @return sign_in_pic 打卡照片
     */
    public String getSignInPic() {
        return signInPic;
    }

    /**
     * 打卡照片
     * @param signInPic 打卡照片
     */
    public void setSignInPic(String signInPic) {
        this.signInPic = signInPic == null ? null : signInPic.trim();
    }

    /**
     * 出行方式: 1-步行,2-旅行,3-公共交通,4-自驾,5-出租车,6-动车/高铁
     * @return way_to_travel 出行方式: 1-步行,2-旅行,3-公共交通,4-自驾,5-出租车,6-动车/高铁
     */
    public Integer getWayToTravel() {
        return wayToTravel;
    }

    /**
     * 出行方式: 1-步行,2-旅行,3-公共交通,4-自驾,5-出租车,6-动车/高铁
     * @param wayToTravel 出行方式: 1-步行,2-旅行,3-公共交通,4-自驾,5-出租车,6-动车/高铁
     */
    public void setWayToTravel(Integer wayToTravel) {
        this.wayToTravel = wayToTravel;
    }

    /**
     * 打卡地点
     * @return sign_in_address 打卡地点
     */
    public String getSignInAddress() {
        return signInAddress;
    }

    /**
     * 打卡地点
     * @param signInAddress 打卡地点
     */
    public void setSignInAddress(String signInAddress) {
        this.signInAddress = signInAddress == null ? null : signInAddress.trim();
    }

    /**
     * 打卡时间
     * @return sign_in_time 打卡时间
     */
    public Date getSignInTime() {
        return signInTime;
    }

    /**
     * 打卡时间
     * @param signInTime 打卡时间
     */
    public void setSignInTime(Date signInTime) {
        this.signInTime = signInTime;
    }

    /**
     * 检测是否延迟：0-未延迟 ； 1-延迟；
     * @return delay_state 检测是否延迟：0-未延迟 ； 1-延迟；
     */
    public Boolean getDelayState() {
        return delayState;
    }

    /**
     * 检测是否延迟：0-未延迟 ； 1-延迟；
     * @param delayState 检测是否延迟：0-未延迟 ； 1-延迟；
     */
    public void setDelayState(Boolean delayState) {
        this.delayState = delayState;
    }

    /**
     * 上门检测出发点经度
     * @return start_longitude 上门检测出发点经度
     */
    public String getStartLongitude() {
        return startLongitude;
    }

    /**
     * 上门检测出发点经度
     * @param startLongitude 上门检测出发点经度
     */
    public void setStartLongitude(String startLongitude) {
        this.startLongitude = startLongitude == null ? null : startLongitude.trim();
    }

    /**
     * 上门检测出发点纬度
     * @return start_latitude 上门检测出发点纬度
     */
    public String getStartLatitude() {
        return startLatitude;
    }

    /**
     * 上门检测出发点纬度
     * @param startLatitude 上门检测出发点纬度
     */
    public void setStartLatitude(String startLatitude) {
        this.startLatitude = startLatitude == null ? null : startLatitude.trim();
    }

    /**
     * 违约金订单号(Liquidated Damage orderno )
     * @return ld_order_no 违约金订单号(Liquidated Damage orderno )
     */
    public String getLdOrderNo() {
        return ldOrderNo;
    }

    /**
     * 违约金订单号(Liquidated Damage orderno )
     * @param ldOrderNo 违约金订单号(Liquidated Damage orderno )
     */
    public void setLdOrderNo(String ldOrderNo) {
        this.ldOrderNo = ldOrderNo == null ? null : ldOrderNo.trim();
    }

    /**
     * 违约金扣除条件(JSON:  preSubStatus:提交检测取消时订单状态，statusTime10026:检测师出发时间,spanTimeMin:检测师出发时间与取消时间间隔,deductionRatio:扣除违约金比例)
     * @return ld_condition 违约金扣除条件(JSON:  preSubStatus:提交检测取消时订单状态，statusTime10026:检测师出发时间,spanTimeMin:检测师出发时间与取消时间间隔,deductionRatio:扣除违约金比例)
     */
    public String getLdCondition() {
        return ldCondition;
    }

    /**
     * 违约金扣除条件(JSON:  preSubStatus:提交检测取消时订单状态，statusTime10026:检测师出发时间,spanTimeMin:检测师出发时间与取消时间间隔,deductionRatio:扣除违约金比例)
     * @param ldCondition 违约金扣除条件(JSON:  preSubStatus:提交检测取消时订单状态，statusTime10026:检测师出发时间,spanTimeMin:检测师出发时间与取消时间间隔,deductionRatio:扣除违约金比例)
     */
    public void setLdCondition(String ldCondition) {
        this.ldCondition = ldCondition == null ? null : ldCondition.trim();
    }

    /**
     * 上门检测的路线距离(米)
     * @return distance 上门检测的路线距离(米)
     */
    public String getDistance() {
        return distance;
    }

    /**
     * 上门检测的路线距离(米)
     * @param distance 上门检测的路线距离(米)
     */
    public void setDistance(String distance) {
        this.distance = distance == null ? null : distance.trim();
    }

    /**
     * 下单终端的地址
     * @return create_order_address 下单终端的地址
     */
    public String getCreateOrderAddress() {
        return createOrderAddress;
    }

    /**
     * 下单终端的地址
     * @param createOrderAddress 下单终端的地址
     */
    public void setCreateOrderAddress(String createOrderAddress) {
        this.createOrderAddress = createOrderAddress == null ? null : createOrderAddress.trim();
    }

    /**
     * (远程检测)检测订单是否兜底 0-不兜底，1-兜底
     * @return guarantee (远程检测)检测订单是否兜底 0-不兜底，1-兜底
     */
    public Boolean getGuarantee() {
        return guarantee;
    }

    /**
     * (远程检测)检测订单是否兜底 0-不兜底，1-兜底
     * @param guarantee (远程检测)检测订单是否兜底 0-不兜底，1-兜底
     */
    public void setGuarantee(Boolean guarantee) {
        this.guarantee = guarantee;
    }

    /**
     * 差旅费订单号
     * @return travel_order_no 差旅费订单号
     */
    public String getTravelOrderNo() {
        return travelOrderNo;
    }

    /**
     * 差旅费订单号
     * @param travelOrderNo 差旅费订单号
     */
    public void setTravelOrderNo(String travelOrderNo) {
        this.travelOrderNo = travelOrderNo == null ? null : travelOrderNo.trim();
    }

    /**
     * 预计差旅费用
     * @return estimate_travel_fee 预计差旅费用
     */
    public BigDecimal getEstimateTravelFee() {
        return estimateTravelFee;
    }

    /**
     * 预计差旅费用
     * @param estimateTravelFee 预计差旅费用
     */
    public void setEstimateTravelFee(BigDecimal estimateTravelFee) {
        this.estimateTravelFee = estimateTravelFee;
    }

    /**
     * t_support_brand表的id
     * @return brand_id t_support_brand表的id
     */
    public Long getBrandId() {
        return brandId;
    }

    /**
     * t_support_brand表的id
     * @param brandId t_support_brand表的id
     */
    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    /**
     * t_support_brand_series表的id
     * @return series_id t_support_brand_series表的id
     */
    public Long getSeriesId() {
        return seriesId;
    }

    /**
     * t_support_brand_series表的id
     * @param seriesId t_support_brand_series表的id
     */
    public void setSeriesId(Long seriesId) {
        this.seriesId = seriesId;
    }

    /**
     * 是否异地下单：0-否 ； 1-是 （下单地点和检测地点不在一个城市算异地）
     * @return is_different_place 是否异地下单：0-否 ； 1-是 （下单地点和检测地点不在一个城市算异地）
     */
    public Boolean getIsDifferentPlace() {
        return isDifferentPlace;
    }

    /**
     * 是否异地下单：0-否 ； 1-是 （下单地点和检测地点不在一个城市算异地）
     * @param isDifferentPlace 是否异地下单：0-否 ； 1-是 （下单地点和检测地点不在一个城市算异地）
     */
    public void setIsDifferentPlace(Boolean isDifferentPlace) {
        this.isDifferentPlace = isDifferentPlace;
    }

    /**
     * 常驻城市id
     * @return resident_city_id 常驻城市id
     */
    public Long getResidentCityId() {
        return residentCityId;
    }

    /**
     * 常驻城市id
     * @param residentCityId 常驻城市id
     */
    public void setResidentCityId(Long residentCityId) {
        this.residentCityId = residentCityId;
    }

    /**
     * 推送报告状态：0-未推送；1-已推送
     * @return push_report_status 推送报告状态：0-未推送；1-已推送
     */
    public Boolean getPushReportStatus() {
        return pushReportStatus;
    }

    /**
     * 推送报告状态：0-未推送；1-已推送
     * @param pushReportStatus 推送报告状态：0-未推送；1-已推送
     */
    public void setPushReportStatus(Boolean pushReportStatus) {
        this.pushReportStatus = pushReportStatus;
    }

    /**
     * 汽车标识：1-新车；2-二手车
     * @return car_flag 汽车标识：1-新车；2-二手车
     */
    public Integer getCarFlag() {
        return carFlag;
    }

    /**
     * 汽车标识：1-新车；2-二手车
     * @param carFlag 汽车标识：1-新车；2-二手车
     */
    public void setCarFlag(Integer carFlag) {
        this.carFlag = carFlag;
    }

    /**
     * 预计检测时间
     * @return expect_detection_time 预计检测时间
     */
    public Date getExpectDetectionTime() {
        return expectDetectionTime;
    }

    /**
     * 预计检测时间
     * @param expectDetectionTime 预计检测时间
     */
    public void setExpectDetectionTime(Date expectDetectionTime) {
        this.expectDetectionTime = expectDetectionTime;
    }

    /**
     * 上门检测变更为到店检测的时间
     * @return out2in_time 上门检测变更为到店检测的时间
     */
    public Date getOut2inTime() {
        return out2inTime;
    }

    /**
     * 上门检测变更为到店检测的时间
     * @param out2inTime 上门检测变更为到店检测的时间
     */
    public void setOut2inTime(Date out2inTime) {
        this.out2inTime = out2inTime;
    }

    /**
     * 拆解检测级别：1、一级检测;  2、二级拆解检测;  3、三级拆解检测
     * @return split_level 拆解检测级别：1、一级检测;  2、二级拆解检测;  3、三级拆解检测
     */
    public Integer getSplitLevel() {
        return splitLevel;
    }

    /**
     * 拆解检测级别：1、一级检测;  2、二级拆解检测;  3、三级拆解检测
     * @param splitLevel 拆解检测级别：1、一级检测;  2、二级拆解检测;  3、三级拆解检测
     */
    public void setSplitLevel(Integer splitLevel) {
        this.splitLevel = splitLevel;
    }

    /**
     * 检测师到达经度
     * @return arrive_longitude 检测师到达经度
     */
    public String getArriveLongitude() {
        return arriveLongitude;
    }

    /**
     * 检测师到达经度
     * @param arriveLongitude 检测师到达经度
     */
    public void setArriveLongitude(String arriveLongitude) {
        this.arriveLongitude = arriveLongitude == null ? null : arriveLongitude.trim();
    }

    /**
     * 检测师到达纬度
     * @return arrive_latitude 检测师到达纬度
     */
    public String getArriveLatitude() {
        return arriveLatitude;
    }

    /**
     * 检测师到达纬度
     * @param arriveLatitude 检测师到达纬度
     */
    public void setArriveLatitude(String arriveLatitude) {
        this.arriveLatitude = arriveLatitude == null ? null : arriveLatitude.trim();
    }

    /**
     * 通用估价订单号
     * @return currency_assess_order_no 通用估价订单号
     */
    public String getCurrencyAssessOrderNo() {
        return currencyAssessOrderNo;
    }

    /**
     * 通用估价订单号
     * @param currencyAssessOrderNo 通用估价订单号
     */
    public void setCurrencyAssessOrderNo(String currencyAssessOrderNo) {
        this.currencyAssessOrderNo = currencyAssessOrderNo == null ? null : currencyAssessOrderNo.trim();
    }

    /**
     * 交通费
     * @return travel_cost 交通费
     */
    public BigDecimal getTravelCost() {
        return travelCost;
    }

    /**
     * 交通费
     * @param travelCost 交通费
     */
    public void setTravelCost(BigDecimal travelCost) {
        this.travelCost = travelCost;
    }

    /**
     * 是否使用安心保障
     * @return is_guarantee 是否使用安心保障
     */
    public Boolean getIsGuarantee() {
        return isGuarantee;
    }

    /**
     * 是否使用安心保障
     * @param isGuarantee 是否使用安心保障
     */
    public void setIsGuarantee(Boolean isGuarantee) {
        this.isGuarantee = isGuarantee;
    }

    /**
     * 升级套餐前的订单号(来源订单号)
     * @return from_order_no 升级套餐前的订单号(来源订单号)
     */
    public String getFromOrderNo() {
        return fromOrderNo;
    }

    /**
     * 升级套餐前的订单号(来源订单号)
     * @param fromOrderNo 升级套餐前的订单号(来源订单号)
     */
    public void setFromOrderNo(String fromOrderNo) {
        this.fromOrderNo = fromOrderNo == null ? null : fromOrderNo.trim();
    }

    /**
     * 是否在APP端展示：0-否； 1-是
     * @return is_app_show 是否在APP端展示：0-否； 1-是
     */
    public Boolean getIsAppShow() {
        return isAppShow;
    }

    /**
     * 是否在APP端展示：0-否； 1-是
     * @param isAppShow 是否在APP端展示：0-否； 1-是
     */
    public void setIsAppShow(Boolean isAppShow) {
        this.isAppShow = isAppShow;
    }

    /**
     * 评分标准id( t_detection_v2_score_standard的id)
     * @return score_standard_id 评分标准id( t_detection_v2_score_standard的id)
     */
    public Long getScoreStandardId() {
        return scoreStandardId;
    }

    /**
     * 评分标准id( t_detection_v2_score_standard的id)
     * @param scoreStandardId 评分标准id( t_detection_v2_score_standard的id)
     */
    public void setScoreStandardId(Long scoreStandardId) {
        this.scoreStandardId = scoreStandardId;
    }

    /**
     * 第三方检测完成时间
     * @return thirdpart_finish_time 第三方检测完成时间
     */
    public Date getThirdpartFinishTime() {
        return thirdpartFinishTime;
    }

    /**
     * 第三方检测完成时间
     * @param thirdpartFinishTime 第三方检测完成时间
     */
    public void setThirdpartFinishTime(Date thirdpartFinishTime) {
        this.thirdpartFinishTime = thirdpartFinishTime;
    }

    /**
     * 批量下单的批次号
     * @return batch_code 批量下单的批次号
     */
    public String getBatchCode() {
        return batchCode;
    }

    /**
     * 批量下单的批次号
     * @param batchCode 批量下单的批次号
     */
    public void setBatchCode(String batchCode) {
        this.batchCode = batchCode == null ? null : batchCode.trim();
    }

    /**
     * 当前套餐是否可升级：0-不可升级； 1-可升级
     * @return upgrade_sign 当前套餐是否可升级：0-不可升级； 1-可升级
     */
    public Boolean getUpgradeSign() {
        return upgradeSign;
    }

    /**
     * 当前套餐是否可升级：0-不可升级； 1-可升级
     * @param upgradeSign 当前套餐是否可升级：0-不可升级； 1-可升级
     */
    public void setUpgradeSign(Boolean upgradeSign) {
        this.upgradeSign = upgradeSign;
    }

    /**
     * 订单附加的安心保障项
     * @return guarantee_items 订单附加的安心保障项
     */
    public String getGuaranteeItems() {
        return guaranteeItems;
    }

    /**
     * 订单附加的安心保障项
     * @param guaranteeItems 订单附加的安心保障项
     */
    public void setGuaranteeItems(String guaranteeItems) {
        this.guaranteeItems = guaranteeItems == null ? null : guaranteeItems.trim();
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
     * 付款时间
     * @return pay_time 付款时间
     */
    public Date getPayTime() {
        return payTime;
    }

    /**
     * 付款时间
     * @param payTime 付款时间
     */
    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    /**
     * 预约配置表的id(t_detection_reservation_config)
     * @return reservation_config_id 预约配置表的id(t_detection_reservation_config)
     */
    public Long getReservationConfigId() {
        return reservationConfigId;
    }

    /**
     * 预约配置表的id(t_detection_reservation_config)
     * @param reservationConfigId 预约配置表的id(t_detection_reservation_config)
     */
    public void setReservationConfigId(Long reservationConfigId) {
        this.reservationConfigId = reservationConfigId;
    }

    /**
     * 预约日期
     * @return reservation_day 预约日期
     */
    public Date getReservationDay() {
        return reservationDay;
    }

    /**
     * 预约日期
     * @param reservationDay 预约日期
     */
    public void setReservationDay(Date reservationDay) {
        this.reservationDay = reservationDay;
    }

    /**
     * 预约状态：0-不是预约单;1-直接下单;2-预约成功;3-预约失败
     * @return reservation_status 预约状态：0-不是预约单;1-直接下单;2-预约成功;3-预约失败
     */
    public Integer getReservationStatus() {
        return reservationStatus;
    }

    /**
     * 预约状态：0-不是预约单;1-直接下单;2-预约成功;3-预约失败
     * @param reservationStatus 预约状态：0-不是预约单;1-直接下单;2-预约成功;3-预约失败
     */
    public void setReservationStatus(Integer reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    /**
     * 打卡城市
     * @return sign_city_id 打卡城市
     */
    public Integer getSignCityId() {
        return signCityId;
    }

    /**
     * 打卡城市
     * @param signCityId 打卡城市
     */
    public void setSignCityId(Integer signCityId) {
        this.signCityId = signCityId;
    }

    /**
     * 预约检测时间
     * @return reservation_detection_time 预约检测时间
     */
    public String getReservationDetectionTime() {
        return reservationDetectionTime;
    }

    /**
     * 预约检测时间
     * @param reservationDetectionTime 预约检测时间
     */
    public void setReservationDetectionTime(String reservationDetectionTime) {
        this.reservationDetectionTime = reservationDetectionTime == null ? null : reservationDetectionTime.trim();
    }

    /**
     * 订单特殊开关配置(如检测过程中可以添加附加项)
     * @return switch_config 订单特殊开关配置(如检测过程中可以添加附加项)
     */
    public String getSwitchConfig() {
        return switchConfig;
    }

    /**
     * 订单特殊开关配置(如检测过程中可以添加附加项)
     * @param switchConfig 订单特殊开关配置(如检测过程中可以添加附加项)
     */
    public void setSwitchConfig(String switchConfig) {
        this.switchConfig = switchConfig == null ? null : switchConfig.trim();
    }

    /**
     * 第三方检测类型 1-用户;2-车商
     * @return thirdpart_type 第三方检测类型 1-用户;2-车商
     */
    public Integer getThirdpartType() {
        return thirdpartType;
    }

    /**
     * 第三方检测类型 1-用户;2-车商
     * @param thirdpartType 第三方检测类型 1-用户;2-车商
     */
    public void setThirdpartType(Integer thirdpartType) {
        this.thirdpartType = thirdpartType;
    }

    /**
     * json字段：warrantyDealWith 延保检测订单是否需要处理 0是需要处理，1是不需要处理； 注意！还存在其他字段！
     * @return extend json字段：warrantyDealWith 延保检测订单是否需要处理 0是需要处理，1是不需要处理； 注意！还存在其他字段！
     */
    public String getExtend() {
        return extend;
    }

    /**
     * json字段：warrantyDealWith 延保检测订单是否需要处理 0是需要处理，1是不需要处理； 注意！还存在其他字段！
     * @param extend json字段：warrantyDealWith 延保检测订单是否需要处理 0是需要处理，1是不需要处理； 注意！还存在其他字段！
     */
    public void setExtend(String extend) {
        this.extend = extend == null ? null : extend.trim();
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
        sb.append(", userId=").append(userId);
        sb.append(", orderNoReport=").append(orderNoReport);
        sb.append(", status=").append(status);
        sb.append(", name=").append(name);
        sb.append(", address=").append(address);
        sb.append(", mobile=").append(mobile);
        sb.append(", cityId=").append(cityId);
        sb.append(", ownUserId=").append(ownUserId);
        sb.append(", ownUserIdCheck=").append(ownUserIdCheck);
        sb.append(", ownUserIdOrder=").append(ownUserIdOrder);
        sb.append(", ownUserIdAuditor=").append(ownUserIdAuditor);
        sb.append(", vin=").append(vin);
        sb.append(", carNo=").append(carNo);
        sb.append(", engineNo=").append(engineNo);
        sb.append(", carColor=").append(carColor);
        sb.append(", valuationBrandId=").append(valuationBrandId);
        sb.append(", fillTime=").append(fillTime);
        sb.append(", addTime=").append(addTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", type=").append(type);
        sb.append(", remark=").append(remark);
        sb.append(", version=").append(version);
        sb.append(", carDealerId=").append(carDealerId);
        sb.append(", carDealerPrice=").append(carDealerPrice);
        sb.append(", thirdpartOrderId=").append(thirdpartOrderId);
        sb.append(", maxValuation=").append(maxValuation);
        sb.append(", minValuation=").append(minValuation);
        sb.append(", detectionFinishTime=").append(detectionFinishTime);
        sb.append(", auditPassTime=").append(auditPassTime);
        sb.append(", valuationContent=").append(valuationContent);
        sb.append(", templateId=").append(templateId);
        sb.append(", weights=").append(weights);
        sb.append(", inOrOut=").append(inOrOut);
        sb.append(", thirdpartStatus=").append(thirdpartStatus);
        sb.append(", optType=").append(optType);
        sb.append(", remain=").append(remain);
        sb.append(", orderType=").append(orderType);
        sb.append(", fixUserId=").append(fixUserId);
        sb.append(", detectionStep=").append(detectionStep);
        sb.append(", tip=").append(tip);
        sb.append(", serveOrderNo=").append(serveOrderNo);
        sb.append(", serviceCenterId=").append(serviceCenterId);
        sb.append(", addressLongitude=").append(addressLongitude);
        sb.append(", addressLatitude=").append(addressLatitude);
        sb.append(", extraids=").append(extraids);
        sb.append(", isChecked=").append(isChecked);
        sb.append(", signInPic=").append(signInPic);
        sb.append(", wayToTravel=").append(wayToTravel);
        sb.append(", signInAddress=").append(signInAddress);
        sb.append(", signInTime=").append(signInTime);
        sb.append(", delayState=").append(delayState);
        sb.append(", startLongitude=").append(startLongitude);
        sb.append(", startLatitude=").append(startLatitude);
        sb.append(", ldOrderNo=").append(ldOrderNo);
        sb.append(", ldCondition=").append(ldCondition);
        sb.append(", distance=").append(distance);
        sb.append(", createOrderAddress=").append(createOrderAddress);
        sb.append(", guarantee=").append(guarantee);
        sb.append(", travelOrderNo=").append(travelOrderNo);
        sb.append(", estimateTravelFee=").append(estimateTravelFee);
        sb.append(", brandId=").append(brandId);
        sb.append(", seriesId=").append(seriesId);
        sb.append(", isDifferentPlace=").append(isDifferentPlace);
        sb.append(", residentCityId=").append(residentCityId);
        sb.append(", pushReportStatus=").append(pushReportStatus);
        sb.append(", carFlag=").append(carFlag);
        sb.append(", expectDetectionTime=").append(expectDetectionTime);
        sb.append(", out2inTime=").append(out2inTime);
        sb.append(", splitLevel=").append(splitLevel);
        sb.append(", arriveLongitude=").append(arriveLongitude);
        sb.append(", arriveLatitude=").append(arriveLatitude);
        sb.append(", currencyAssessOrderNo=").append(currencyAssessOrderNo);
        sb.append(", travelCost=").append(travelCost);
        sb.append(", isGuarantee=").append(isGuarantee);
        sb.append(", fromOrderNo=").append(fromOrderNo);
        sb.append(", isAppShow=").append(isAppShow);
        sb.append(", scoreStandardId=").append(scoreStandardId);
        sb.append(", thirdpartFinishTime=").append(thirdpartFinishTime);
        sb.append(", batchCode=").append(batchCode);
        sb.append(", upgradeSign=").append(upgradeSign);
        sb.append(", guaranteeItems=").append(guaranteeItems);
        sb.append(", statusChangeTime=").append(statusChangeTime);
        sb.append(", payTime=").append(payTime);
        sb.append(", reservationConfigId=").append(reservationConfigId);
        sb.append(", reservationDay=").append(reservationDay);
        sb.append(", reservationStatus=").append(reservationStatus);
        sb.append(", signCityId=").append(signCityId);
        sb.append(", reservationDetectionTime=").append(reservationDetectionTime);
        sb.append(", switchConfig=").append(switchConfig);
        sb.append(", thirdpartType=").append(thirdpartType);
        sb.append(", extend=").append(extend);
        sb.append("]");
        return sb.toString();
    }
}