package com.neon.rtp.entity;







import java.io.Serializable;
import java.util.Date;



public class InsurenceInfo implements Serializable {
    /**
     *
     */


    private Long id;

    /**
     * 合同编号
     */

    private String contractNo;

    /**
     * 甲方（买方）
     */

    private String partyA;

    /**
     * 乙方(卖方）
     */

    private String partyB;

    /**
     * 丙方(保险服务方）
     */

    private String partyC;

    /**
     * 表显里程
     */

    private Double watchMile;

    /**
     * 上牌年限
     */

    private String plateYear;

    /**
     * 合同照片
     */

    private String contractPictures;

    /**
     * 身份证照片
     */

    private String idPictures;

    /**
     * 车身照片
     */

    private String carPictures;

    /**
     * 车辆名称
     */

    private String carName;

    /**
     * 车架号
     */

    private String vin;

    /**
     * 承保开始时间
     */

    private Date ensurenceStartTime;

    /**
     * 承保结束时间
     */

    private Date ensurenceEndTime;

    /**
     * 保单号
     */

    private String ensurenceNo;

    /**
     * 第三方承保公司
     */

    private String ensurenceCompany;

    /**
     *
     */

    private Date addTime;

    /**
     *
     */

    private Date updateTime;

    /**
     * 检测师总评
     */

    private String evaluateContent;

    /**
     * 0-检测不通过 ，1-检测通过
     */

    private Boolean status;

    /**
     * 电子合同编号
     */

    private Long contractId;

    /**
     * 0-正常 ； 1-事故 ； 2-火烧 ； 3- 泡水;4-其它
     */

    private Integer carType;

    /**
     * 购车价格(单位: 万元)
     */

    private Double buyPrice;

    /**
     * 备案图片
     */

    private String recordImage;

    /**
     * 备案视频
     */

    private String recordVideo;

    /**
     * 订单号
     */

    private String orderNo;

    /**
     * 车辆评级：A、B、C、D、E
     */

    private String carLevel;

    /**
     * 通话记录
     */

    private String callLog;

    /**
     * 通话标志位： 0-未通话； 1-已通话
     */

    private Boolean callFlag;

    /**
     * 车况综述标准话术ids(t_detection_v2_system_summary表的id)
     */

    private String evaluateContentIds;

    /**
     * sku评分（SR：事故、火烧、水泡）
     */

    private String skuScoreSr;

    /**
     * sku评分（整体车况评级）
     */

    private String skuScoreCar;

    /**
     * sku评分（重要部件）
     */

    private String skuScoreImportant;

    /**
     * sku评分（整备方案评级）
     */

    private String skuScoreRepair;

    /**
     * 检测师签名
     */

    private String checkerSignature;

    /**
     * 过滤掉部分部件后的车辆评级
     */

    private String partComponentCarLevel;

    /**
     * 事故原因
     */

    private String accidentReason;

    /**
     * 发动机视频
     */

    private String engineVideo;

    /**
     * 汽车尾气视频
     */

    private String carGasVideo;

    /**
     * 车辆信息是否完整：0-否； 1-是
     */

    private Boolean isCompleted;

    /**
     * 不完整标记
     */

    private String incompleteFlag;

    /**
     * 车赢检测订单车辆照片
     */

    private String carPic;

    /**
     * 车赢检测订单公司名
     */

    private String companyName;

    /**
     * 车赢检测订单店名
     */

    private String shopName;

    /**
     * 是否事故车：0-否；1-是
     */

    private Boolean isSg;

    /**
     * 是否泡水：0-否；1-是
     */

    private Boolean isPs;

    /**
     * 是否火烧：0-否； 1-是
     */

    private Boolean isHs;

    /**
     * 是否放弃承保：0-否；1-是(S级)
     */

    private Boolean isNoEnsurence;

    /**
     * 车况估价评分
     */

    private String skuScoreValuation;

    /**
     * 是否生成报告：0-否；1-是
     */

    private Boolean reportFlag;

    /**
     * 详版报告地址
     */

    private String detailedReportUrl;

    /**
     * 简版报告地址
     */

    private String simpleReportUrl;

    /**
     * 维保报告地址
     */

    private String wbReportUrl;

    /**
     * 估价报告地址
     */

    private String gjReportUrl;

    /**
     * 自定义价签报告地址
     */

    private String tagReportUrl;

    /**
     * 放弃承保原因(JSON：{"reasonRemark":"","selectedOption":"1","add_time":""} ，selectedOption的枚举值：1-车辆超过10年,2-车辆有事故嫌疑,3-车辆属于非乘用车,4-车价超过百万,5其他)
     */

    private String giveUpReason;

    /**
     * 检测认证书地址
     */

    private String certificateUrl;

    /**
     * 保信是否承保 ： 0-否；1-是
     */

    private Boolean bxEnsurenceFlag;

    /**
     * 抖音详版报告
     */

    private String dyDetailedReportUrl;

    /**
     * 是否打开过wap版报告: 0-否；1-是
     */

    private Boolean openWapReportFlag;

    /**
     * t_insurence_info
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
     * 合同编号
     * @return contract_no 合同编号
     */
    public String getContractNo() {
        return contractNo;
    }

    /**
     * 合同编号
     * @param contractNo 合同编号
     */
    public void setContractNo(String contractNo) {
        this.contractNo = contractNo == null ? null : contractNo.trim();
    }

    /**
     * 甲方（买方）
     * @return party_a 甲方（买方）
     */
    public String getPartyA() {
        return partyA;
    }

    /**
     * 甲方（买方）
     * @param partyA 甲方（买方）
     */
    public void setPartyA(String partyA) {
        this.partyA = partyA == null ? null : partyA.trim();
    }

    /**
     * 乙方(卖方）
     * @return party_b 乙方(卖方）
     */
    public String getPartyB() {
        return partyB;
    }

    /**
     * 乙方(卖方）
     * @param partyB 乙方(卖方）
     */
    public void setPartyB(String partyB) {
        this.partyB = partyB == null ? null : partyB.trim();
    }

    /**
     * 丙方(保险服务方）
     * @return party_c 丙方(保险服务方）
     */
    public String getPartyC() {
        return partyC;
    }

    /**
     * 丙方(保险服务方）
     * @param partyC 丙方(保险服务方）
     */
    public void setPartyC(String partyC) {
        this.partyC = partyC == null ? null : partyC.trim();
    }

    /**
     * 表显里程
     * @return watch_mile 表显里程
     */
    public Double getWatchMile() {
        return watchMile;
    }

    /**
     * 表显里程
     * @param watchMile 表显里程
     */
    public void setWatchMile(Double watchMile) {
        this.watchMile = watchMile;
    }

    /**
     * 上牌年限
     * @return plate_year 上牌年限
     */
    public String getPlateYear() {
        return plateYear;
    }

    /**
     * 上牌年限
     * @param plateYear 上牌年限
     */
    public void setPlateYear(String plateYear) {
        this.plateYear = plateYear == null ? null : plateYear.trim();
    }

    /**
     * 合同照片
     * @return contract_pictures 合同照片
     */
    public String getContractPictures() {
        return contractPictures;
    }

    /**
     * 合同照片
     * @param contractPictures 合同照片
     */
    public void setContractPictures(String contractPictures) {
        this.contractPictures = contractPictures == null ? null : contractPictures.trim();
    }

    /**
     * 身份证照片
     * @return id_pictures 身份证照片
     */
    public String getIdPictures() {
        return idPictures;
    }

    /**
     * 身份证照片
     * @param idPictures 身份证照片
     */
    public void setIdPictures(String idPictures) {
        this.idPictures = idPictures == null ? null : idPictures.trim();
    }

    /**
     * 车身照片
     * @return car_pictures 车身照片
     */
    public String getCarPictures() {
        return carPictures;
    }

    /**
     * 车身照片
     * @param carPictures 车身照片
     */
    public void setCarPictures(String carPictures) {
        this.carPictures = carPictures == null ? null : carPictures.trim();
    }

    /**
     * 车辆名称
     * @return car_name 车辆名称
     */
    public String getCarName() {
        return carName;
    }

    /**
     * 车辆名称
     * @param carName 车辆名称
     */
    public void setCarName(String carName) {
        this.carName = carName == null ? null : carName.trim();
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
     * 承保开始时间
     * @return ensurence_start_time 承保开始时间
     */
    public Date getEnsurenceStartTime() {
        return ensurenceStartTime;
    }

    /**
     * 承保开始时间
     * @param ensurenceStartTime 承保开始时间
     */
    public void setEnsurenceStartTime(Date ensurenceStartTime) {
        this.ensurenceStartTime = ensurenceStartTime;
    }

    /**
     * 承保结束时间
     * @return ensurence_end_time 承保结束时间
     */
    public Date getEnsurenceEndTime() {
        return ensurenceEndTime;
    }

    /**
     * 承保结束时间
     * @param ensurenceEndTime 承保结束时间
     */
    public void setEnsurenceEndTime(Date ensurenceEndTime) {
        this.ensurenceEndTime = ensurenceEndTime;
    }

    /**
     * 保单号
     * @return ensurence_no 保单号
     */
    public String getEnsurenceNo() {
        return ensurenceNo;
    }

    /**
     * 保单号
     * @param ensurenceNo 保单号
     */
    public void setEnsurenceNo(String ensurenceNo) {
        this.ensurenceNo = ensurenceNo == null ? null : ensurenceNo.trim();
    }

    /**
     * 第三方承保公司
     * @return ensurence_company 第三方承保公司
     */
    public String getEnsurenceCompany() {
        return ensurenceCompany;
    }

    /**
     * 第三方承保公司
     * @param ensurenceCompany 第三方承保公司
     */
    public void setEnsurenceCompany(String ensurenceCompany) {
        this.ensurenceCompany = ensurenceCompany == null ? null : ensurenceCompany.trim();
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
     * 检测师总评
     * @return evaluate_content 检测师总评
     */
    public String getEvaluateContent() {
        return evaluateContent;
    }

    /**
     * 检测师总评
     * @param evaluateContent 检测师总评
     */
    public void setEvaluateContent(String evaluateContent) {
        this.evaluateContent = evaluateContent == null ? null : evaluateContent.trim();
    }

    /**
     * 0-检测不通过 ，1-检测通过
     * @return status 0-检测不通过 ，1-检测通过
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * 0-检测不通过 ，1-检测通过
     * @param status 0-检测不通过 ，1-检测通过
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    /**
     * 电子合同编号
     * @return contract_id 电子合同编号
     */
    public Long getContractId() {
        return contractId;
    }

    /**
     * 电子合同编号
     * @param contractId 电子合同编号
     */
    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    /**
     * 0-正常 ； 1-事故 ； 2-火烧 ； 3- 泡水;4-其它
     * @return car_type 0-正常 ； 1-事故 ； 2-火烧 ； 3- 泡水;4-其它
     */
    public Integer getCarType() {
        return carType;
    }

    /**
     * 0-正常 ； 1-事故 ； 2-火烧 ； 3- 泡水;4-其它
     * @param carType 0-正常 ； 1-事故 ； 2-火烧 ； 3- 泡水;4-其它
     */
    public void setCarType(Integer carType) {
        this.carType = carType;
    }

    /**
     * 购车价格(单位: 万元)
     * @return buy_price 购车价格(单位: 万元)
     */
    public Double getBuyPrice() {
        return buyPrice;
    }

    /**
     * 购车价格(单位: 万元)
     * @param buyPrice 购车价格(单位: 万元)
     */
    public void setBuyPrice(Double buyPrice) {
        this.buyPrice = buyPrice;
    }

    /**
     * 备案图片
     * @return record_image 备案图片
     */
    public String getRecordImage() {
        return recordImage;
    }

    /**
     * 备案图片
     * @param recordImage 备案图片
     */
    public void setRecordImage(String recordImage) {
        this.recordImage = recordImage == null ? null : recordImage.trim();
    }

    /**
     * 备案视频
     * @return record_video 备案视频
     */
    public String getRecordVideo() {
        return recordVideo;
    }

    /**
     * 备案视频
     * @param recordVideo 备案视频
     */
    public void setRecordVideo(String recordVideo) {
        this.recordVideo = recordVideo == null ? null : recordVideo.trim();
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
     * 车辆评级：A、B、C、D、E
     * @return car_level 车辆评级：A、B、C、D、E
     */
    public String getCarLevel() {
        return carLevel;
    }

    /**
     * 车辆评级：A、B、C、D、E
     * @param carLevel 车辆评级：A、B、C、D、E
     */
    public void setCarLevel(String carLevel) {
        this.carLevel = carLevel == null ? null : carLevel.trim();
    }

    /**
     * 通话记录
     * @return call_log 通话记录
     */
    public String getCallLog() {
        return callLog;
    }

    /**
     * 通话记录
     * @param callLog 通话记录
     */
    public void setCallLog(String callLog) {
        this.callLog = callLog == null ? null : callLog.trim();
    }

    /**
     * 通话标志位： 0-未通话； 1-已通话
     * @return call_flag 通话标志位： 0-未通话； 1-已通话
     */
    public Boolean getCallFlag() {
        return callFlag;
    }

    /**
     * 通话标志位： 0-未通话； 1-已通话
     * @param callFlag 通话标志位： 0-未通话； 1-已通话
     */
    public void setCallFlag(Boolean callFlag) {
        this.callFlag = callFlag;
    }

    /**
     * 车况综述标准话术ids(t_detection_v2_system_summary表的id)
     * @return evaluate_content_ids 车况综述标准话术ids(t_detection_v2_system_summary表的id)
     */
    public String getEvaluateContentIds() {
        return evaluateContentIds;
    }

    /**
     * 车况综述标准话术ids(t_detection_v2_system_summary表的id)
     * @param evaluateContentIds 车况综述标准话术ids(t_detection_v2_system_summary表的id)
     */
    public void setEvaluateContentIds(String evaluateContentIds) {
        this.evaluateContentIds = evaluateContentIds == null ? null : evaluateContentIds.trim();
    }

    /**
     * sku评分（SR：事故、火烧、水泡）
     * @return sku_score_sr sku评分（SR：事故、火烧、水泡）
     */
    public String getSkuScoreSr() {
        return skuScoreSr;
    }

    /**
     * sku评分（SR：事故、火烧、水泡）
     * @param skuScoreSr sku评分（SR：事故、火烧、水泡）
     */
    public void setSkuScoreSr(String skuScoreSr) {
        this.skuScoreSr = skuScoreSr == null ? null : skuScoreSr.trim();
    }

    /**
     * sku评分（整体车况评级）
     * @return sku_score_car sku评分（整体车况评级）
     */
    public String getSkuScoreCar() {
        return skuScoreCar;
    }

    /**
     * sku评分（整体车况评级）
     * @param skuScoreCar sku评分（整体车况评级）
     */
    public void setSkuScoreCar(String skuScoreCar) {
        this.skuScoreCar = skuScoreCar == null ? null : skuScoreCar.trim();
    }

    /**
     * sku评分（重要部件）
     * @return sku_score_important sku评分（重要部件）
     */
    public String getSkuScoreImportant() {
        return skuScoreImportant;
    }

    /**
     * sku评分（重要部件）
     * @param skuScoreImportant sku评分（重要部件）
     */
    public void setSkuScoreImportant(String skuScoreImportant) {
        this.skuScoreImportant = skuScoreImportant == null ? null : skuScoreImportant.trim();
    }

    /**
     * sku评分（整备方案评级）
     * @return sku_score_repair sku评分（整备方案评级）
     */
    public String getSkuScoreRepair() {
        return skuScoreRepair;
    }

    /**
     * sku评分（整备方案评级）
     * @param skuScoreRepair sku评分（整备方案评级）
     */
    public void setSkuScoreRepair(String skuScoreRepair) {
        this.skuScoreRepair = skuScoreRepair == null ? null : skuScoreRepair.trim();
    }

    /**
     * 检测师签名
     * @return checker_signature 检测师签名
     */
    public String getCheckerSignature() {
        return checkerSignature;
    }

    /**
     * 检测师签名
     * @param checkerSignature 检测师签名
     */
    public void setCheckerSignature(String checkerSignature) {
        this.checkerSignature = checkerSignature == null ? null : checkerSignature.trim();
    }

    /**
     * 过滤掉部分部件后的车辆评级
     * @return part_component_car_level 过滤掉部分部件后的车辆评级
     */
    public String getPartComponentCarLevel() {
        return partComponentCarLevel;
    }

    /**
     * 过滤掉部分部件后的车辆评级
     * @param partComponentCarLevel 过滤掉部分部件后的车辆评级
     */
    public void setPartComponentCarLevel(String partComponentCarLevel) {
        this.partComponentCarLevel = partComponentCarLevel == null ? null : partComponentCarLevel.trim();
    }

    /**
     * 事故原因
     * @return accident_reason 事故原因
     */
    public String getAccidentReason() {
        return accidentReason;
    }

    /**
     * 事故原因
     * @param accidentReason 事故原因
     */
    public void setAccidentReason(String accidentReason) {
        this.accidentReason = accidentReason == null ? null : accidentReason.trim();
    }

    /**
     * 发动机视频
     * @return engine_video 发动机视频
     */
    public String getEngineVideo() {
        return engineVideo;
    }

    /**
     * 发动机视频
     * @param engineVideo 发动机视频
     */
    public void setEngineVideo(String engineVideo) {
        this.engineVideo = engineVideo == null ? null : engineVideo.trim();
    }

    /**
     * 汽车尾气视频
     * @return car_gas_video 汽车尾气视频
     */
    public String getCarGasVideo() {
        return carGasVideo;
    }

    /**
     * 汽车尾气视频
     * @param carGasVideo 汽车尾气视频
     */
    public void setCarGasVideo(String carGasVideo) {
        this.carGasVideo = carGasVideo == null ? null : carGasVideo.trim();
    }

    /**
     * 车辆信息是否完整：0-否； 1-是
     * @return is_completed 车辆信息是否完整：0-否； 1-是
     */
    public Boolean getIsCompleted() {
        return isCompleted;
    }

    /**
     * 车辆信息是否完整：0-否； 1-是
     * @param isCompleted 车辆信息是否完整：0-否； 1-是
     */
    public void setIsCompleted(Boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    /**
     * 不完整标记
     * @return incomplete_flag 不完整标记
     */
    public String getIncompleteFlag() {
        return incompleteFlag;
    }

    /**
     * 不完整标记
     * @param incompleteFlag 不完整标记
     */
    public void setIncompleteFlag(String incompleteFlag) {
        this.incompleteFlag = incompleteFlag == null ? null : incompleteFlag.trim();
    }

    /**
     * 车赢检测订单车辆照片
     * @return car_pic 车赢检测订单车辆照片
     */
    public String getCarPic() {
        return carPic;
    }

    /**
     * 车赢检测订单车辆照片
     * @param carPic 车赢检测订单车辆照片
     */
    public void setCarPic(String carPic) {
        this.carPic = carPic == null ? null : carPic.trim();
    }

    /**
     * 车赢检测订单公司名
     * @return company_name 车赢检测订单公司名
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * 车赢检测订单公司名
     * @param companyName 车赢检测订单公司名
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    /**
     * 车赢检测订单店名
     * @return shop_name 车赢检测订单店名
     */
    public String getShopName() {
        return shopName;
    }

    /**
     * 车赢检测订单店名
     * @param shopName 车赢检测订单店名
     */
    public void setShopName(String shopName) {
        this.shopName = shopName == null ? null : shopName.trim();
    }

    /**
     * 是否事故车：0-否；1-是
     * @return is_sg 是否事故车：0-否；1-是
     */
    public Boolean getIsSg() {
        return isSg;
    }

    /**
     * 是否事故车：0-否；1-是
     * @param isSg 是否事故车：0-否；1-是
     */
    public void setIsSg(Boolean isSg) {
        this.isSg = isSg;
    }

    /**
     * 是否泡水：0-否；1-是
     * @return is_ps 是否泡水：0-否；1-是
     */
    public Boolean getIsPs() {
        return isPs;
    }

    /**
     * 是否泡水：0-否；1-是
     * @param isPs 是否泡水：0-否；1-是
     */
    public void setIsPs(Boolean isPs) {
        this.isPs = isPs;
    }

    /**
     * 是否火烧：0-否； 1-是
     * @return is_hs 是否火烧：0-否； 1-是
     */
    public Boolean getIsHs() {
        return isHs;
    }

    /**
     * 是否火烧：0-否； 1-是
     * @param isHs 是否火烧：0-否； 1-是
     */
    public void setIsHs(Boolean isHs) {
        this.isHs = isHs;
    }

    /**
     * 是否放弃承保：0-否；1-是(S级)
     * @return is_no_ensurence 是否放弃承保：0-否；1-是(S级)
     */
    public Boolean getIsNoEnsurence() {
        return isNoEnsurence;
    }

    /**
     * 是否放弃承保：0-否；1-是(S级)
     * @param isNoEnsurence 是否放弃承保：0-否；1-是(S级)
     */
    public void setIsNoEnsurence(Boolean isNoEnsurence) {
        this.isNoEnsurence = isNoEnsurence;
    }

    /**
     * 车况估价评分
     * @return sku_score_valuation 车况估价评分
     */
    public String getSkuScoreValuation() {
        return skuScoreValuation;
    }

    /**
     * 车况估价评分
     * @param skuScoreValuation 车况估价评分
     */
    public void setSkuScoreValuation(String skuScoreValuation) {
        this.skuScoreValuation = skuScoreValuation == null ? null : skuScoreValuation.trim();
    }

    /**
     * 是否生成报告：0-否；1-是
     * @return report_flag 是否生成报告：0-否；1-是
     */
    public Boolean getReportFlag() {
        return reportFlag;
    }

    /**
     * 是否生成报告：0-否；1-是
     * @param reportFlag 是否生成报告：0-否；1-是
     */
    public void setReportFlag(Boolean reportFlag) {
        this.reportFlag = reportFlag;
    }

    /**
     * 详版报告地址
     * @return detailed_report_url 详版报告地址
     */
    public String getDetailedReportUrl() {
        return detailedReportUrl;
    }

    /**
     * 详版报告地址
     * @param detailedReportUrl 详版报告地址
     */
    public void setDetailedReportUrl(String detailedReportUrl) {
        this.detailedReportUrl = detailedReportUrl == null ? null : detailedReportUrl.trim();
    }

    /**
     * 简版报告地址
     * @return simple_report_url 简版报告地址
     */
    public String getSimpleReportUrl() {
        return simpleReportUrl;
    }

    /**
     * 简版报告地址
     * @param simpleReportUrl 简版报告地址
     */
    public void setSimpleReportUrl(String simpleReportUrl) {
        this.simpleReportUrl = simpleReportUrl == null ? null : simpleReportUrl.trim();
    }

    /**
     * 维保报告地址
     * @return wb_report_url 维保报告地址
     */
    public String getWbReportUrl() {
        return wbReportUrl;
    }

    /**
     * 维保报告地址
     * @param wbReportUrl 维保报告地址
     */
    public void setWbReportUrl(String wbReportUrl) {
        this.wbReportUrl = wbReportUrl == null ? null : wbReportUrl.trim();
    }

    /**
     * 估价报告地址
     * @return gj_report_url 估价报告地址
     */
    public String getGjReportUrl() {
        return gjReportUrl;
    }

    /**
     * 估价报告地址
     * @param gjReportUrl 估价报告地址
     */
    public void setGjReportUrl(String gjReportUrl) {
        this.gjReportUrl = gjReportUrl == null ? null : gjReportUrl.trim();
    }

    /**
     * 自定义价签报告地址
     * @return tag_report_url 自定义价签报告地址
     */
    public String getTagReportUrl() {
        return tagReportUrl;
    }

    /**
     * 自定义价签报告地址
     * @param tagReportUrl 自定义价签报告地址
     */
    public void setTagReportUrl(String tagReportUrl) {
        this.tagReportUrl = tagReportUrl == null ? null : tagReportUrl.trim();
    }

    /**
     * 放弃承保原因(JSON：{"reasonRemark":"","selectedOption":"1","add_time":""} ，selectedOption的枚举值：1-车辆超过10年,2-车辆有事故嫌疑,3-车辆属于非乘用车,4-车价超过百万,5其他)
     * @return give_up_reason 放弃承保原因(JSON：{"reasonRemark":"","selectedOption":"1","add_time":""} ，selectedOption的枚举值：1-车辆超过10年,2-车辆有事故嫌疑,3-车辆属于非乘用车,4-车价超过百万,5其他)
     */
    public String getGiveUpReason() {
        return giveUpReason;
    }

    /**
     * 放弃承保原因(JSON：{"reasonRemark":"","selectedOption":"1","add_time":""} ，selectedOption的枚举值：1-车辆超过10年,2-车辆有事故嫌疑,3-车辆属于非乘用车,4-车价超过百万,5其他)
     * @param giveUpReason 放弃承保原因(JSON：{"reasonRemark":"","selectedOption":"1","add_time":""} ，selectedOption的枚举值：1-车辆超过10年,2-车辆有事故嫌疑,3-车辆属于非乘用车,4-车价超过百万,5其他)
     */
    public void setGiveUpReason(String giveUpReason) {
        this.giveUpReason = giveUpReason == null ? null : giveUpReason.trim();
    }

    /**
     * 检测认证书地址
     * @return certificate_url 检测认证书地址
     */
    public String getCertificateUrl() {
        return certificateUrl;
    }

    /**
     * 检测认证书地址
     * @param certificateUrl 检测认证书地址
     */
    public void setCertificateUrl(String certificateUrl) {
        this.certificateUrl = certificateUrl == null ? null : certificateUrl.trim();
    }

    /**
     * 保信是否承保 ： 0-否；1-是
     * @return bx_ensurence_flag 保信是否承保 ： 0-否；1-是
     */
    public Boolean getBxEnsurenceFlag() {
        return bxEnsurenceFlag;
    }

    /**
     * 保信是否承保 ： 0-否；1-是
     * @param bxEnsurenceFlag 保信是否承保 ： 0-否；1-是
     */
    public void setBxEnsurenceFlag(Boolean bxEnsurenceFlag) {
        this.bxEnsurenceFlag = bxEnsurenceFlag;
    }

    /**
     * 抖音详版报告
     * @return dy_detailed_report_url 抖音详版报告
     */
    public String getDyDetailedReportUrl() {
        return dyDetailedReportUrl;
    }

    /**
     * 抖音详版报告
     * @param dyDetailedReportUrl 抖音详版报告
     */
    public void setDyDetailedReportUrl(String dyDetailedReportUrl) {
        this.dyDetailedReportUrl = dyDetailedReportUrl == null ? null : dyDetailedReportUrl.trim();
    }

    /**
     * 是否打开过wap版报告: 0-否；1-是
     * @return open_wap_report_flag 是否打开过wap版报告: 0-否；1-是
     */
    public Boolean getOpenWapReportFlag() {
        return openWapReportFlag;
    }

    /**
     * 是否打开过wap版报告: 0-否；1-是
     * @param openWapReportFlag 是否打开过wap版报告: 0-否；1-是
     */
    public void setOpenWapReportFlag(Boolean openWapReportFlag) {
        this.openWapReportFlag = openWapReportFlag;
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
        sb.append(", contractNo=").append(contractNo);
        sb.append(", partyA=").append(partyA);
        sb.append(", partyB=").append(partyB);
        sb.append(", partyC=").append(partyC);
        sb.append(", watchMile=").append(watchMile);
        sb.append(", plateYear=").append(plateYear);
        sb.append(", contractPictures=").append(contractPictures);
        sb.append(", idPictures=").append(idPictures);
        sb.append(", carPictures=").append(carPictures);
        sb.append(", carName=").append(carName);
        sb.append(", vin=").append(vin);
        sb.append(", ensurenceStartTime=").append(ensurenceStartTime);
        sb.append(", ensurenceEndTime=").append(ensurenceEndTime);
        sb.append(", ensurenceNo=").append(ensurenceNo);
        sb.append(", ensurenceCompany=").append(ensurenceCompany);
        sb.append(", addTime=").append(addTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", evaluateContent=").append(evaluateContent);
        sb.append(", status=").append(status);
        sb.append(", contractId=").append(contractId);
        sb.append(", carType=").append(carType);
        sb.append(", buyPrice=").append(buyPrice);
        sb.append(", recordImage=").append(recordImage);
        sb.append(", recordVideo=").append(recordVideo);
        sb.append(", orderNo=").append(orderNo);
        sb.append(", carLevel=").append(carLevel);
        sb.append(", callLog=").append(callLog);
        sb.append(", callFlag=").append(callFlag);
        sb.append(", evaluateContentIds=").append(evaluateContentIds);
        sb.append(", skuScoreSr=").append(skuScoreSr);
        sb.append(", skuScoreCar=").append(skuScoreCar);
        sb.append(", skuScoreImportant=").append(skuScoreImportant);
        sb.append(", skuScoreRepair=").append(skuScoreRepair);
        sb.append(", checkerSignature=").append(checkerSignature);
        sb.append(", partComponentCarLevel=").append(partComponentCarLevel);
        sb.append(", accidentReason=").append(accidentReason);
        sb.append(", engineVideo=").append(engineVideo);
        sb.append(", carGasVideo=").append(carGasVideo);
        sb.append(", isCompleted=").append(isCompleted);
        sb.append(", incompleteFlag=").append(incompleteFlag);
        sb.append(", carPic=").append(carPic);
        sb.append(", companyName=").append(companyName);
        sb.append(", shopName=").append(shopName);
        sb.append(", isSg=").append(isSg);
        sb.append(", isPs=").append(isPs);
        sb.append(", isHs=").append(isHs);
        sb.append(", isNoEnsurence=").append(isNoEnsurence);
        sb.append(", skuScoreValuation=").append(skuScoreValuation);
        sb.append(", reportFlag=").append(reportFlag);
        sb.append(", detailedReportUrl=").append(detailedReportUrl);
        sb.append(", simpleReportUrl=").append(simpleReportUrl);
        sb.append(", wbReportUrl=").append(wbReportUrl);
        sb.append(", gjReportUrl=").append(gjReportUrl);
        sb.append(", tagReportUrl=").append(tagReportUrl);
        sb.append(", giveUpReason=").append(giveUpReason);
        sb.append(", certificateUrl=").append(certificateUrl);
        sb.append(", bxEnsurenceFlag=").append(bxEnsurenceFlag);
        sb.append(", dyDetailedReportUrl=").append(dyDetailedReportUrl);
        sb.append(", openWapReportFlag=").append(openWapReportFlag);
        sb.append("]");
        return sb.toString();
    }
}