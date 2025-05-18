package com.template.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedissonConfig {

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private String port;

//    @Bean
//    public RedissonClient redissonClient() {
//        Config config = new Config();
//        //单机模式  依次设置redis地址和密码 设置缓存过期时间为30秒
//        config.useSingleServer().
//                setAddress("redis://" + host + ":" + port)
//                .setTimeout(30000);
//        return Redisson.create(config);
//
//    }
}
