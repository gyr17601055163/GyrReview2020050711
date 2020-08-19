/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: MyTest02InvocationHandler
 * Author:   gyr
 * Date:     2020/7/22 10:48
 * Description:
 */
package com.example.demo.Ajava.for设计模式.for代理模式.dong.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyTest02InvocationHandler implements InvocationHandler {

    private TestMapper testMapper;

    public MyTest02InvocationHandler(TestMapper testMapper) {
        this.testMapper = testMapper;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("--------invoke---------");
        testMapper.queryUserList(args[0].toString());
        System.out.println("--------invoke2---------");

        return null;
    }
}