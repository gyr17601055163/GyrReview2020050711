/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: TestRedis
 * Author:   gyr
 * Date:     2020/9/1 21:08
 * Description:
 */
package com.example.demo.ARedis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)  //运行器
public class TestRedis {

    RedisTemplate redisTemplate = new RedisTemplate();


    @Test
    public void test1(){
        redisTemplate.opsForValue().set("zhangsan","123");
    }





}