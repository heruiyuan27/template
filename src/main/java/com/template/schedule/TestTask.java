package com.template.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TestTask {

    @Scheduled(cron = "*/6 * * * * ?")
    public void executeTask() {
        log.info("定时任务执行时间: {}", System.currentTimeMillis());
    }
}
