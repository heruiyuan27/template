package com.template;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@Slf4j
@SpringBootApplication
public class MyApplication {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(MyApplication.class);
        Environment environment = application.run(args).getEnvironment();
        log.info("项目启动成功");
        if ("dev".equals(environment.getProperty("spring.profiles.active"))) {
            log.info("Swagger文档地址:http://localhost:{}{}/doc.html",
                    environment.getProperty("server.port"),
                    environment.getProperty("server.servlet.context-path"));
        }
    }
}
