package com.template.controller;

import com.template.common.resp.CommonResponse;
import com.template.common.resp.DataResponse;
import com.template.event.PaySuccessEvent;
import com.template.model.enums.PayEnum;
import com.template.strategy.pay.PayStrategy;
import com.template.strategy.pay.PayStrategyFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
public class PayController {

    @Resource
    private PayStrategyFactory payStrategyFactory;

    @Resource
    private ApplicationEventPublisher applicationEventPublisher;

    @RequestMapping(value = "/pay", method = RequestMethod.GET)
    public DataResponse<String> pay(int type, int money) {
        PayStrategy payStrategy = payStrategyFactory.getPayStrategy(PayEnum.fromCode(type));
        String res = payStrategy.pay(money);
        return DataResponse.success(res);
    }

    @RequestMapping(value = "/paySuccess", method = RequestMethod.GET)
    public CommonResponse paySuccess() {
        applicationEventPublisher.publishEvent(new PaySuccessEvent(this, "小明支付成功"));
        return CommonResponse.success();
    }

}
