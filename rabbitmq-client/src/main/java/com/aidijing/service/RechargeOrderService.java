package com.aidijing.service;

import com.aidijing.config.RabbitMQConfig;
import com.aidijing.domain.RechargeOrder;
import com.aidijing.utils.JsonUtils;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @author : 披荆斩棘
 * @date : 2017/3/26
 * 充值订单生产
 */
@Component
public class RechargeOrderService {

    @Lazy
    @Autowired
    private AmqpTemplate amqpTemplate;

    @Autowired
    private RabbitMQConfig rabbitMQConfig;

    public void send ( RechargeOrder order ) {
        amqpTemplate.convertAndSend(
                rabbitMQConfig.getRechargeExchange(),
                rabbitMQConfig.getRechargeRoutingKey(),
                JsonUtils.GSON.toJson( order )
        );
    }
}
