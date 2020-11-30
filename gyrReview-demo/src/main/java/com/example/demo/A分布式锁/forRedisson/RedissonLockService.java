package com.example.demo.A分布式锁.forRedisson;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class RedissonLockService {

    @Autowired
    private RedissonLockDao redissonLockDao;
    @Autowired
    private RedissonClient redissonClient;

    public void updateStock(String goodsId,String userId){
        //获取锁
        RLock lock = redissonClient.getLock(goodsId);
        try {
            //获取锁
            lock.lock(50,TimeUnit.SECONDS);
            //获取库存
            Map<String, Object> stock = redissonLockDao.getStock(goodsId);
            //修改库存
            int stock1 = Integer.parseInt(stock.get("stock").toString()) - 1;
            stock.put("stock",stock1);
            //更新库存
            redissonLockDao.updateStock(stock);
        }finally {
            //释放锁
            lock.unlock();
        }

    }
}
