package com.aidijing.utils;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.retry.RejectAndDontRequeueRecoverer;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author : 披荆斩棘
 * @date : 2017/1/16
 */
public class RejectAndLogRecoverer extends RejectAndDontRequeueRecoverer {


    @Override
    public void recover ( Message message, Throwable cause ) {
        // 异常堆栈信息
        final String errorStackTrace = this.getStackTraceAsString( cause );
        // 异常信息
        final String errorMessage = this.errorMessage( cause );
        // 异常交换机名
        final String errorReceivedExchange = message.getMessageProperties().getReceivedExchange();
        // 异常路由key
        final String errorReceivedRoutingKey = message.getMessageProperties().getReceivedRoutingKey();
        // 这里可以记录异常的信息
        super.recover( message, cause );
    }

    private String errorMessage ( Throwable cause ) {
        return cause.getCause() != null ? cause.getCause().getMessage() : cause.getMessage();
    }

    private String getStackTraceAsString ( Throwable cause ) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter  printWriter  = new PrintWriter( stringWriter, true );
        cause.printStackTrace( printWriter );
        return stringWriter.getBuffer().toString();
    }
}
