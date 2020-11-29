/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: RedisLockListen
 * Author:   gyr
 * Date:     2020/11/29 18:15
 * Description:
 */
package com.example.demo.A分布式锁.forRedis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

/**
 * @author HP
 */
@Configuration
public class RedisMessageConfig {

    @Autowired
    private MyRedisListen myRedisListen;

    @Bean
    public RedisMessageListenerContainer getRedisMessageListenerContainer(RedisConnectionFactory redisConnectionFactory){

        RedisMessageListenerContainer redisMessageListenerContainer=new RedisMessageListenerContainer();

        redisMessageListenerContainer.setConnectionFactory(redisConnectionFactory);

        redisMessageListenerContainer.addMessageListener(myRedisListen,new PatternTopic("LOCK"));

        return redisMessageListenerContainer;
    }
}