/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: BaseController
 * Author:   gyr
 * Date:     2020/11/19 22:15
 * Description:
 */
package com.example.demo.web;

import com.example.demo.common.util.UID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class BaseController {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    /**
     * 生成code的接口
     * @return
     */
    @RequestMapping("getCode")
    public String getCode(){
        //生成code
        String uuid16 = UID.getUUID16();
        //将code存入redis中并设置过期时间
        redisTemplate.opsForValue().set(uuid16,"",1, TimeUnit.HOURS);
        return uuid16;
    }

}