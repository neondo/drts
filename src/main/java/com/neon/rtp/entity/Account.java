//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.neon.rtp.entity;






import java.io.Serializable;
import java.math.BigDecimal;



public class Account implements Serializable {


    private Long id;

    private Long userId;

    private BigDecimal currentBalance;

    private BigDecimal virtualBalance;

    private BigDecimal totalCharge;

    private BigDecimal totalCost;

    private BigDecimal inviteTotalCommission;

    private BigDecimal inviteCanWithdrawCommission;

    private BigDecimal detectionTotalCommission;

    private BigDecimal detectionCanWithdrawCommission;

    private BigDecimal invoiceBalance;

    private BigDecimal totalTransferOut;

    private BigDecimal totalTransferIn;

    private String extend;

    private static final long serialVersionUID = -2829274355787246964L;

    public Account() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public BigDecimal getCurrentBalance() {
        return this.currentBalance;
    }

    public void setCurrentBalance(BigDecimal currentBalance) {
        this.currentBalance = currentBalance;
    }

    public BigDecimal getVirtualBalance() {
        return this.virtualBalance;
    }

    public void setVirtualBalance(BigDecimal virtualBalance) {
        this.virtualBalance = virtualBalance;
    }

    public BigDecimal getTotalCharge() {
        return this.totalCharge;
    }

    public void setTotalCharge(BigDecimal totalCharge) {
        this.totalCharge = totalCharge;
    }

    public BigDecimal getTotalCost() {
        return this.totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public BigDecimal getInviteTotalCommission() {
        return this.inviteTotalCommission;
    }

    public void setInviteTotalCommission(BigDecimal inviteTotalCommission) {
        this.inviteTotalCommission = inviteTotalCommission;
    }

    public BigDecimal getInviteCanWithdrawCommission() {
        return this.inviteCanWithdrawCommission;
    }

    public void setInviteCanWithdrawCommission(BigDecimal inviteCanWithdrawCommission) {
        this.inviteCanWithdrawCommission = inviteCanWithdrawCommission;
    }

    public BigDecimal getDetectionTotalCommission() {
        return this.detectionTotalCommission;
    }

    public void setDetectionTotalCommission(BigDecimal detectionTotalCommission) {
        this.detectionTotalCommission = detectionTotalCommission;
    }

    public BigDecimal getDetectionCanWithdrawCommission() {
        return this.detectionCanWithdrawCommission;
    }

    public void setDetectionCanWithdrawCommission(BigDecimal detectionCanWithdrawCommission) {
        this.detectionCanWithdrawCommission = detectionCanWithdrawCommission;
    }

    public BigDecimal getInvoiceBalance() {
        return this.invoiceBalance;
    }

    public void setInvoiceBalance(BigDecimal invoiceBalance) {
        this.invoiceBalance = invoiceBalance;
    }

    public BigDecimal getTotalTransferOut() {
        return this.totalTransferOut;
    }

    public void setTotalTransferOut(BigDecimal totalTransferOut) {
        this.totalTransferOut = totalTransferOut;
    }

    public BigDecimal getTotalTransferIn() {
        return this.totalTransferIn;
    }

    public void setTotalTransferIn(BigDecimal totalTransferIn) {
        this.totalTransferIn = totalTransferIn;
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
        sb.append(", userId=").append(this.userId);
        sb.append(", currentBalance=").append(this.currentBalance);
        sb.append(", virtualBalance=").append(this.virtualBalance);
        sb.append(", totalCharge=").append(this.totalCharge);
        sb.append(", totalCost=").append(this.totalCost);
        sb.append(", inviteTotalCommission=").append(this.inviteTotalCommission);
        sb.append(", inviteCanWithdrawCommission=").append(this.inviteCanWithdrawCommission);
        sb.append(", detectionTotalCommission=").append(this.detectionTotalCommission);
        sb.append(", detectionCanWithdrawCommission=").append(this.detectionCanWithdrawCommission);
        sb.append(", invoiceBalance=").append(this.invoiceBalance);
        sb.append(", totalTransferOut=").append(this.totalTransferOut);
        sb.append(", totalTransferIn=").append(this.totalTransferIn);
        sb.append(", extend=").append(this.extend);
        sb.append("]");
        return sb.toString();
    }
}
