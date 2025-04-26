package com.template.strategy.pay;

import com.template.model.enums.PayEnum;
import org.springframework.stereotype.Component;

@Component
public class AliPay implements PayStrategy {
    @Override
    public PayEnum getPayEnum() {
        return PayEnum.AliPay;
    }

    @Override
    public String pay(int money) {
        return "Alipay-" + money;
    }
}
