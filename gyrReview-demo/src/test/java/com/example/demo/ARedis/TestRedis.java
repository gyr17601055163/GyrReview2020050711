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

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//通过@RunWith 和 @SpringBootTest启动spring容器
@SpringBootTest  //使用@SpringBootTest后，Spring将加载所有被管理的bean
@RunWith(SpringRunner.class)  //运行器
public class TestRedis {

    RedisTemplate redisTemplate = new RedisTemplate();

    @Test
    public void test1(){
        redisTemplate.opsForValue().set("zhangsan","123");
    }


    @Test
    public void test2(){
        //08 11 13 30 32  02 06
        String args_="08 11 13 30 32+02 06";
        String[] argsAttr = args_.split("\\+");
        //argsAttr[0]=red,argsAttr[1]=blue

        /**
         * red
         */
        Integer frontSectionSum = getFrontSectionSum(argsAttr[0]);
        Integer headWithEndSum = getHeadWithEndSum(argsAttr[0]);
        String zeroOneTwo = getZeroOneTwo(argsAttr[0]);

        /**
         * blue
         */

        /**
         * composite
         */



    }

    //red和值
    public Integer getFrontSectionSum(String red){
        String[] redAttr = red.split(" ");
        Integer redsum=0;
        for (int i = 0; i < redAttr.length; i++){
            Integer red_ = Integer.valueOf(redAttr[i]);
            redsum += red_;
        }
        System.out.println("----------red------前区和值为："+redsum);
        return redsum;
    }

    //首尾和
    public Integer getHeadWithEndSum(String red){
        String[] redAttr = red.split(" ");
        Integer integer = Integer.valueOf(redAttr[0]);
        Integer integer1 = Integer.valueOf(redAttr[4]);
        int i = integer + integer1;
        System.out.println("----------red------首尾和为："+i);
        return i;
    }

    //012
    public String getZeroOneTwo(String red){
        String[] redAttr = red.split(" ");
        Map<String,Integer> redMap=new HashMap<>();
        Integer zeroCount=0;
        Integer oneCount=0;
        Integer twoCount=0;
        for (int i = 0; i < redAttr.length; i++){
            Integer red_ = Integer.valueOf(redAttr[i]);
            if (red_ % 3 == 0){
                redMap.put("0",zeroCount++);
            }else if (red_ % 3 == 1){
                redMap.put("1",oneCount++);
            }else if (red_ % 3 == 2){
                redMap.put("2",twoCount++);
            }
        }

        System.out.println("----------red------012为："+zeroCount+":"+oneCount+":"+twoCount);
        return zeroCount+":"+oneCount+":"+twoCount;
    }





}