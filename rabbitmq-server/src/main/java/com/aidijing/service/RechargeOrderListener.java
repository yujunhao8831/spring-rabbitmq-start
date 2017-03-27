package com.aidijing.service;

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
public class RechargeOrderListener {

    @Lazy
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void onMessage ( String orderJson ) {

        final RechargeOrder order = JsonUtils.GSON.fromJson( orderJson, RechargeOrder.class );
        // 消费订单
        System.err.println( "order =  " + order );

    }

}
