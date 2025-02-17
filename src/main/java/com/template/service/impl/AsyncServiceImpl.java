package com.template.service.impl;

import com.template.service.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AsyncServiceImpl implements AsyncService {

    @Override
    @Async
    public void async() {
        log.info("Service:"+Thread.currentThread().getName());
    }
}
