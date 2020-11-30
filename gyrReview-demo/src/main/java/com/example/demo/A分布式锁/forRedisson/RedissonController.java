package com.example.demo.A分布式锁.forRedisson;

import com.example.demo.common.util.UID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedissonController {

    @Autowired
    private RedissonLockService redissonLockService;

    @RequestMapping("redissonLock")
    public String redissonLock(){
        String userId = UID.getUUID16();
        redissonLockService.updateStock("100",userId);
        return "ok";
    }

}
