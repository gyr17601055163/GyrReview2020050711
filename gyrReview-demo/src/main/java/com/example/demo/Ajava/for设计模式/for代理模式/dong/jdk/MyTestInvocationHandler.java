/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: MyTestInvocationHandler
 * Author:   gyr
 * Date:     2020/7/21 23:34
 * Description:
 */
package com.example.demo.Ajava.for设计模式.for代理模式.dong.jdk;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyTestInvocationHandler implements InvocationHandler {

    /**
     * @param proxy 被代理对象
     * @param method 被代理的方法
     * @param args 被代理方法的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        //进行连接数据库查询user列表的操作start
        /**
         * 1.获取数据库连接
         * 2.获取sql语句
         * 3.请求数据库
         * 4.处理请求结果
         */
        //进行连接数据库查询user列表的操作end

        System.out.println("执行的方法名："+method.getName()+",方法的参数："+ JSON.toJSONString(args));

        //返回结果
        return null;
    }
}