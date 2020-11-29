/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: MyRedisListen
 * Author:   gyr
 * Date:     2020/11/29 18:23
 * Description:
 */
package com.example.demo.A分布式锁.forRedis;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author gyr
 */
@Component
public class MyRedisListen implements MessageListener {

    @Autowired
    private RedisLockService redisLockService;

    @Override
    public void onMessage(Message message, byte[] bytes) {

        String body=new String(message.getBody());

        String channel=new String(message.getChannel());

        Map<String,Object> stock = JSON.parseObject(body, Map.class);

        System.out.println("++++++++++++++++进入Reids消息队列");

        if (channel.equals("LOCK")){
            redisLockService.updateStock(stock.get("goodsId").toString(),stock.get("userId").toString());
        }
    }
}