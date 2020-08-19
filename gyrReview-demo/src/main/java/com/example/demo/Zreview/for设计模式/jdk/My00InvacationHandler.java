/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: My00InvacationHandler
 * Author:   gyr
 * Date:     2020/7/31 20:35
 * Description:
 */
package com.example.demo.Zreview.for设计模式.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class My00InvacationHandler implements InvocationHandler {

    private My00Api my00Api;

    public My00InvacationHandler(My00Api my00Api) {
        this.my00Api = my00Api;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("--------0-----------");
        my00Api.getTest(args[0].toString());
        System.out.println("--------1-----------");
        return null;
    }
}