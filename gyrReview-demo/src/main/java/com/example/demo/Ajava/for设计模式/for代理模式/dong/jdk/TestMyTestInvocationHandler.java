/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: TestMyTestInvocationHandler
 * Author:   gyr
 * Date:     2020/7/21 23:36
 * Description:
 */
package com.example.demo.Ajava.for设计模式.for代理模式.dong.jdk;

import java.lang.reflect.Proxy;

public class TestMyTestInvocationHandler {

    public static void main(String[] args) {

        //得有一个InvocationHandler的实例
        MyTestInvocationHandler myTestInvocationHandler = new MyTestInvocationHandler();

        Class<TestMapper> testMapperClass = TestMapper.class;

        Class<?>[] classes = {testMapperClass};

        /**
         * 获取代理对象（使用JDK底层提供的Proxy类）
         * args1：类加载器
         * args2：一个接口类型的类数组
         * args3：InvocationHandler的实例
         * return：返回一个代理对象
         */
        TestMapper mapper = (TestMapper) Proxy.newProxyInstance(testMapperClass.getClassLoader(), classes, myTestInvocationHandler);

        mapper.queryUserList("张三");

    }
}