/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: RedisLockController
 * Author:   gyr
 * Date:     2020/11/29 19:01
 * Description:
 */
package com.example.demo.A分布式锁.forRedis;

import com.example.demo.common.util.UID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisLockController {

    @Autowired
    private RedisLockService redisLockService;

    @RequestMapping("lock")
    public String updateLock(){

        String uuid16 = UID.getUUID16();

        redisLockService.updateStock("100",uuid16);

        return "ok";
    }
}