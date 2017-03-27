package com.aidijing.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author : 披荆斩棘
 * @date : 2017/3/26
 */
@Component
public class RabbitMQConfig {
    @Value( "${rabbit.recharge.exchange.name}" )
    private String rechargeExchange;
    @Value( "${rabbit.recharge.queue.pattern.routing.key}" )
    private String rechargeRoutingKey;

    public String getRechargeExchange () {
        return rechargeExchange;
    }

    public String getRechargeRoutingKey () {
        return rechargeRoutingKey;
    }
}
