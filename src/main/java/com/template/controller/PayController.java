package com.template.controller;

import com.template.common.resp.DataResponse;
import com.template.model.enums.PayEnum;
import com.template.strategy.pay.PayStrategy;
import com.template.strategy.pay.PayStrategyFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
public class PayController {

    @Resource
    private PayStrategyFactory payStrategyFactory;

    @RequestMapping(value = "/pay", method = RequestMethod.GET)
    public DataResponse<String> pay(int type, int money) {
        PayStrategy payStrategy = payStrategyFactory.getPayStrategy(PayEnum.fromCode(type));
        String res = payStrategy.pay(money);
        return DataResponse.success(res);
    }

}
