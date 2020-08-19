/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: TestApiImpl
 * Author:   gyr
 * Date:     2020/8/3 17:12
 * Description: 被代理对象
 */
package com.example.demo.Ajava.for设计模式.for代理模式.jing;

public class TestApiImpl implements TestApi {

    @Override
    public String eee(String str) {
        System.out.println("============被代理对象");
        return null;
    }
}