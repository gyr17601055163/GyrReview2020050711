package com.example.demo.ARedis;

import com.example.demo.entity.TestUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestRedisApi {

    //使用json进行序列化
    @Autowired
    RedisTemplate redisTemplate;
    //使用Jackson2JsonRedisSerializer进行序列化
    @Autowired
    RedisTemplate redisTemplate1;
    //使用GenericJackson2JsonRedisSerializer进行序列化
    @Autowired
    RedisTemplate redisTemplate2;
    //使用JDK进行序列化
    @Autowired
    RedisTemplate redisTemplate3;

    /**
     * Redis如何降低内存得占用
     */
    @Test
    public void test_cunchu_01(){
        long startTime = System.currentTimeMillis();
        Map<String,Integer> map=new HashMap<>();
        for (int i=0; i<100000; i++){
            map.put("user_"+i,i);
        }
        redisTemplate.opsForValue().multiSet(map);
        long endTime = System.currentTimeMillis();

        System.out.println("test_cunchu_01--------使用时间"+(endTime-startTime)/1000.0);
    }

    //通过控制key数量，来降低内存得使用
    @Test
    public void test_cunchu_02(){
        long startTime = System.currentTimeMillis();

        Map<String,Integer> map=new HashMap<>();
        for (int i=1;i<=100000;i++){
            map.put("user_"+i,i);
            if (i%10000==0){
                redisTemplate.opsForHash().putAll(i,map);
                map.clear();
            }
        }

        long endTime = System.currentTimeMillis();
        System.out.println("test_cunchu_02--------使用时间"+(endTime-startTime)/1000.0);
    }

    @Test
    public void test_cunchu_01_(){
        long startTime = System.currentTimeMillis();
        Map<String,Object> map=new HashMap<>();
        for (int i=0;i<100000;i++){
            TestUser ttt=new TestUser();
            ttt.setUserName("userName"+i);
            ttt.setPassWord("Password"+i);
            map.put("user_"+i,ttt);
        }
        redisTemplate.opsForValue().multiSet(map);
        long endTime = System.currentTimeMillis();
        System.out.println("test_cunchu_02--------使用时间"+(endTime-startTime)/1000.0);
    }

    //通过控制key数量，来降低内存得使用
    @Test
    public void test_cunchu_02_(){
        long startTime = System.currentTimeMillis();
        Map<String,Object> map=new HashMap<>();
        for (int i=1;i<=100000;i++){
            TestUser ttt=new TestUser();
            ttt.setUserName("userName"+i);
            ttt.setPassWord("Password"+i);
            map.put("user_"+i,ttt);
            if (i%10000==0){
                redisTemplate.opsForHash().putAll(i,map);
                map.clear();
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("test_cunchu_02--------使用时间"+(endTime-startTime)/1000.0);
    }

    //不同的序列化方式它所占用的内存是不一样的




}
