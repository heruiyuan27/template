package com.template.strategy.pay;

import com.template.model.enums.PayEnum;
import org.springframework.stereotype.Component;

@Component
public class UnionPay implements PayStrategy {
    @Override
    public PayEnum getPayEnum() {
        return PayEnum.UnionPay;
    }

    @Override
    public String pay(int money) {
        return "UnionPay-" + money;
    }
}
