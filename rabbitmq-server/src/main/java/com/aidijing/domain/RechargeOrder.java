package com.aidijing.domain;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author : 披荆斩棘
 * @date : 2017/3/26
 */
public class RechargeOrder implements Serializable {
    private Long       id;
    private String     orderId;
    private BigDecimal amount;
    private String     description;


    @Override
    public String toString () {
        return "RechargeOrder{" +
                "id=" + id +
                ", orderId='" + orderId + '\'' +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                '}';
    }

    public Long getId () {
        return id;
    }

    public RechargeOrder setId ( Long id ) {
        this.id = id;
        return this;
    }

    public String getOrderId () {
        return orderId;
    }

    public RechargeOrder setOrderId ( String orderId ) {
        this.orderId = orderId;
        return this;
    }

    public BigDecimal getAmount () {
        return amount;
    }

    public RechargeOrder setAmount ( BigDecimal amount ) {
        this.amount = amount;
        return this;
    }

    public String getDescription () {
        return description;
    }

    public RechargeOrder setDescription ( String description ) {
        this.description = description;
        return this;
    }
}
