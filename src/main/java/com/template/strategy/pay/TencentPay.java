package com.template.strategy.pay;

import com.template.model.enums.PayEnum;
import org.springframework.stereotype.Component;

@Component
public class TencentPay implements PayStrategy {
    @Override
    public PayEnum getPayEnum() {
        return PayEnum.TencentPay;
    }

    @Override
    public String pay(int money) {
        return "TencentPay-" + money;
    }
}
