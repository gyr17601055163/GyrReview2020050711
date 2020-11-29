/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: RedisLockService
 * Author:   gyr
 * Date:     2020/11/29 18:37
 * Description:
 */
package com.example.demo.A分布式锁.forRedis;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RedisLockService {

    @Autowired
    private RedisLockDao redisLockDao;
    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    public void updateStock(String goodsId,String userId){

        //获取锁
        boolean lock = RedisLockUtil.getLock(redisTemplate, goodsId, userId, "50");

        if (lock){
            //获取锁成功
            try {
                //先获取库存
                Stock stock = redisLockDao.getStockByGoodsId(goodsId);
                //库存做减一操作
                stock.setStock(stock.getStock()-1);
                redisLockDao.updateStock(stock);
                System.out.println("-------------------锁库存成功，当前库存为："+stock.getStock());
            }finally {
                //释放锁
                RedisLockUtil.unLock(redisTemplate,goodsId,userId);
            }
        }else {

            Map<String,Object> map=new HashMap<>();
            map.put("goodsId",Long.valueOf(goodsId));
            map.put("userId",userId);
            System.out.println("---------->"+ JSON.toJSONString(map));

            //获取锁失败，加入到Redis消息队列，去尝试获取锁
            redisTemplate.convertAndSend("LOCK",JSON.toJSONString(map));
        }
    }
}