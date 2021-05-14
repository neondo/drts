/**
 *
 */

package com.neon.rtp.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;







/**
 * @author lee
 *
 */


public class WarrantyInfo implements Serializable {
  /**
   *
   */

  private static final long serialVersionUID = 1L;

  public WarrantyInfo() {
  }

  public WarrantyInfo(String orderNo) {
    this.orderNo = orderNo;
  }



  private Long id;

  private String orderNo;

  /**
   * 投保人姓名
   */

  private String warrantyName;

  /**
   * 投保人手机号
   */

  private String warrantyMobile;

  /**
   * 电子合同id
   */

  private Long contractId;

  /**
   * 承保开始里程 （单位：万公里）
   */

  private BigDecimal startMiles;

  /**
   * 承保结束里程 （单位：万公里）
   */

  private BigDecimal endMiles;

  /**
   * 承保开始时间
   */

  private Date ensurenceStartTime;

  /**
   * 承保结束时间
   */

  private Date ensurenceEndTime;

  /**
   * 延保单号
   */

  private String insurenceNo;

  private Date addTime;

  private Date updateTime;

  private String extend;

  /**
   * 发动机号
   */

  private String engineNo;

  /**
   * 车牌号
   */

  private String carNo;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getOrderNo() {
    return orderNo;
  }

  public void setOrderNo(String orderNo) {
    this.orderNo = orderNo;
  }

  public String getWarrantyName() {
    return warrantyName;
  }

  public void setWarrantyName(String warrantyName) {
    this.warrantyName = warrantyName;
  }

  public String getWarrantyMobile() {
    return warrantyMobile;
  }

  public void setWarrantyMobile(String warrantyMobile) {
    this.warrantyMobile = warrantyMobile;
  }

  public Long getContractId() {
    return contractId;
  }

  public void setContractId(Long contractId) {
    this.contractId = contractId;
  }

  public BigDecimal getStartMiles() {
    return startMiles;
  }

  public void setStartMiles(BigDecimal startMiles) {
    this.startMiles = startMiles;
  }

  public BigDecimal getEndMiles() {
    return endMiles;
  }

  public void setEndMiles(BigDecimal endMiles) {
    this.endMiles = endMiles;
  }

  public Date getEnsurenceStartTime() {
    return ensurenceStartTime;
  }

  public void setEnsurenceStartTime(Date ensurenceStartTime) {
    this.ensurenceStartTime = ensurenceStartTime;
  }

  public Date getEnsurenceEndTime() {
    return ensurenceEndTime;
  }

  public void setEnsurenceEndTime(Date ensurenceEndTime) {
    this.ensurenceEndTime = ensurenceEndTime;
  }

  public String getInsurenceNo() {
    return insurenceNo;
  }

  public void setInsurenceNo(String insurenceNo) {
    this.insurenceNo = insurenceNo;
  }

  public Date getAddTime() {
    return addTime;
  }

  public void setAddTime(Date addTime) {
    this.addTime = addTime;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  public String getExtend() {
    return extend;
  }

  public void setExtend(String extend) {
    this.extend = extend;
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

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("WarrantyInfo [id=");
    builder.append(id);
    builder.append(", orderNo=");
    builder.append(orderNo);
    builder.append(", warrantyName=");
    builder.append(warrantyName);
    builder.append(", warrantyMobile=");
    builder.append(warrantyMobile);
    builder.append(", contractId=");
    builder.append(contractId);
    builder.append(", startMiles=");
    builder.append(startMiles);
    builder.append(", endMiles=");
    builder.append(endMiles);
    builder.append(", ensurenceStartTime=");
    builder.append(ensurenceStartTime);
    builder.append(", ensurenceEndTime=");
    builder.append(ensurenceEndTime);
    builder.append(", insurenceNo=");
    builder.append(insurenceNo);
    builder.append(", addTime=");
    builder.append(addTime);
    builder.append(", updateTime=");
    builder.append(updateTime);
    builder.append(", extend=");
    builder.append(extend);
    builder.append("]");
    return builder.toString();
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((addTime == null) ? 0 : addTime.hashCode());
    result = prime * result + ((carNo == null) ? 0 : carNo.hashCode());
    result = prime * result + ((contractId == null) ? 0 : contractId.hashCode());
    result = prime * result + ((endMiles == null) ? 0 : endMiles.hashCode());
    result = prime * result + ((engineNo == null) ? 0 : engineNo.hashCode());
    result = prime * result + ((ensurenceEndTime == null) ? 0 : ensurenceEndTime.hashCode());
    result = prime * result + ((ensurenceStartTime == null) ? 0 : ensurenceStartTime.hashCode());
    result = prime * result + ((extend == null) ? 0 : extend.hashCode());
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((insurenceNo == null) ? 0 : insurenceNo.hashCode());
    result = prime * result + ((orderNo == null) ? 0 : orderNo.hashCode());
    result = prime * result + ((startMiles == null) ? 0 : startMiles.hashCode());
    result = prime * result + ((updateTime == null) ? 0 : updateTime.hashCode());
    result = prime * result + ((warrantyMobile == null) ? 0 : warrantyMobile.hashCode());
    result = prime * result + ((warrantyName == null) ? 0 : warrantyName.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    WarrantyInfo other = (WarrantyInfo) obj;
    if (addTime == null) {
      if (other.addTime != null)
        return false;
    } else if (!addTime.equals(other.addTime))
      return false;
    if (carNo == null) {
      if (other.carNo != null)
        return false;
    } else if (!carNo.equals(other.carNo))
      return false;
    if (contractId == null) {
      if (other.contractId != null)
        return false;
    } else if (!contractId.equals(other.contractId))
      return false;
    if (endMiles == null) {
      if (other.endMiles != null)
        return false;
    } else if (!endMiles.equals(other.endMiles))
      return false;
    if (engineNo == null) {
      if (other.engineNo != null)
        return false;
    } else if (!engineNo.equals(other.engineNo))
      return false;
    if (ensurenceEndTime == null) {
      if (other.ensurenceEndTime != null)
        return false;
    } else if (!ensurenceEndTime.equals(other.ensurenceEndTime))
      return false;
    if (ensurenceStartTime == null) {
      if (other.ensurenceStartTime != null)
        return false;
    } else if (!ensurenceStartTime.equals(other.ensurenceStartTime))
      return false;
    if (extend == null) {
      if (other.extend != null)
        return false;
    } else if (!extend.equals(other.extend))
      return false;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    if (insurenceNo == null) {
      if (other.insurenceNo != null)
        return false;
    } else if (!insurenceNo.equals(other.insurenceNo))
      return false;
    if (orderNo == null) {
      if (other.orderNo != null)
        return false;
    } else if (!orderNo.equals(other.orderNo))
      return false;
    if (startMiles == null) {
      if (other.startMiles != null)
        return false;
    } else if (!startMiles.equals(other.startMiles))
      return false;
    if (updateTime == null) {
      if (other.updateTime != null)
        return false;
    } else if (!updateTime.equals(other.updateTime))
      return false;
    if (warrantyMobile == null) {
      if (other.warrantyMobile != null)
        return false;
    } else if (!warrantyMobile.equals(other.warrantyMobile))
      return false;
    if (warrantyName == null) {
      if (other.warrantyName != null)
        return false;
    } else if (!warrantyName.equals(other.warrantyName))
      return false;
    return true;
  }

}
