package com.aidijing.service;

import com.aidijing.domain.RechargeOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Created by 披荆斩棘 on 2017/3/26.
 */

@ContextConfiguration( "classpath:applicationContext.xml" )
@RunWith( SpringJUnit4ClassRunner.class )
public class RechargeOrderServiceTest {
    @Autowired
    private RechargeOrderService rechargeOrderService;

    @Test
    public void send () throws Exception {
        RechargeOrder order = new RechargeOrder();
        order.setId( 1L )
             .setAmount( BigDecimal.valueOf( 100 ) )
             .setDescription( "100元" )
             .setOrderId( UUID.randomUUID().toString() );
        rechargeOrderService.send( order );
    }

    @Test
    public void asyncSend () throws Exception {
        RechargeOrder order = new RechargeOrder();
        order.setId( 1L )
             .setAmount( BigDecimal.valueOf( 100 ) )
             .setDescription( "100元" )
             .setOrderId( UUID.randomUUID().toString() );
    }

}