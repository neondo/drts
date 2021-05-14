package com.neon.rtp.model;

import java.math.BigDecimal;

/**
 * @author Neon
 * @date 2021/5/10 22:00
 */
public class Order{

    private Long id;

    private BigDecimal amount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
