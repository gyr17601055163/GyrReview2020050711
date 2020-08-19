/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: My00Test
 * Author:   gyr
 * Date:     2020/7/31 20:40
 * Description:
 */
package com.example.demo.Zreview.for设计模式.jdk;


import java.lang.reflect.Proxy;

public class My00Test {

    public static void main(String[] args) {

        My00Api my00Api = new My00ApiImpl();

        My00InvacationHandler my00InvacationHandler = new My00InvacationHandler(my00Api);

        My00Api obj = (My00Api) Proxy.newProxyInstance(My00ApiImpl.class.getClassLoader(), My00ApiImpl.class.getInterfaces(), my00InvacationHandler);

        obj.getTest("000");

    }

}