/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: RedisLockUtil
 * Author:   gyr
 * Date:     2020/11/29 14:16
 * Description:
 */
package com.example.demo.A分布式锁.forRedis;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;

import java.util.Collections;

/**
 * RedisLock工具类
 */
public class RedisLockUtil {

    /**
     * 获取锁
     * @param redisTemplate
     * @param goodsId 商品id
     * @param userId 用户id
     * @param expire key的过期时间
     * @return
     */
    public static boolean getLock(RedisTemplate<String,String> redisTemplate,String goodsId,String userId,String expire){
        //使用redis的setNx命令实现获取锁功能，setNx设置key成功，设置过期时间，否则返回0
        String lua="if redis.call('setNx',KEYS[1],ARGV[1])==1 then return redis.call('expire',KEYS[1],ARGV[2]) else return 0 end";

        DefaultRedisScript<Long> defaultRedisScript=new DefaultRedisScript<>();
        defaultRedisScript.setResultType(Long.class);
        defaultRedisScript.setScriptText(lua);

        Long execute = redisTemplate.execute(defaultRedisScript, Collections.singletonList(goodsId), userId, expire);

        if (execute==1){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 释放锁
     * @param redisTemplate
     * @param goodsId 商品id
     * @param userId 用户id
     * @return
     */
    public static boolean unLock(RedisTemplate<String,String> redisTemplate,String goodsId,String userId){
        String lua="if redis.call('get',KEYS[1])==ARGV[1] then return redis.call('del',KEYS[1]) else return 0 end";

        DefaultRedisScript<Long> defaultRedisScript=new DefaultRedisScript<>();
        defaultRedisScript.setResultType(Long.class);
        defaultRedisScript.setScriptText(lua);

        Long execute = redisTemplate.execute(defaultRedisScript, Collections.singletonList(goodsId), userId);
        if (execute==1){
            return true;
        }else {
            return false;
        }
    }
}