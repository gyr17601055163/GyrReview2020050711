/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: TestMyTest02InvocationHandler
 * Author:   gyr
 * Date:     2020/7/22 10:51
 * Description:
 */
package com.example.demo.Ajava.for设计模式.for代理模式.dong.jdk;

import java.lang.reflect.Proxy;

public class TestMyTest02InvocationHandler {

    public static void main(String[] args) {

        TestMapper testMapper = new TestMapperImpl();

        //invocationHandler实例
        MyTest02InvocationHandler myTest02InvocationHandler = new MyTest02InvocationHandler(testMapper);

        TestMapper testMapper1 = (TestMapper)Proxy.newProxyInstance(TestMapperImpl.class.getClassLoader(), TestMapperImpl.class.getInterfaces(), myTest02InvocationHandler);

        testMapper1.queryUserList("000");

    }
}