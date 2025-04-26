package com.template.strategy.pay;

import com.template.model.enums.PayEnum;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class PayStrategyFactory implements ApplicationContextAware {

    private final Map<PayEnum, PayStrategy> payMap = new ConcurrentHashMap<>();

    @Override
    // 通过applicationContext获取所有策略实现类，在工厂中维护
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, PayStrategy> beanMap = applicationContext.getBeansOfType(PayStrategy.class);
        beanMap.values().forEach(v -> payMap.put(v.getPayEnum(), v));
    }

    // 简单工厂，通过枚举获取策略实现类
    public PayStrategy getPayStrategy(PayEnum payEnum) {
        return payMap.get(payEnum);
    }
}
