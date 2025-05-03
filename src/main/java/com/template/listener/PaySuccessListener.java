package com.template.listener;

import com.template.event.PaySuccessEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PaySuccessListener {

    @EventListener
    public void email(PaySuccessEvent event) {
        log.info("支付成功，发送邮件：" + "{}，测试成功", event.getMsg());
    }

    @EventListener
    public void phone(PaySuccessEvent event) {
        log.info("支付成功，发送短信：" + "{}，测试成功", event.getMsg());
    }
}
