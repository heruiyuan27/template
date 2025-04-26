package com.template.strategy.pay;

import com.template.model.enums.PayEnum;

public interface PayStrategy {

    PayEnum getPayEnum();

    String pay(int money);
}
