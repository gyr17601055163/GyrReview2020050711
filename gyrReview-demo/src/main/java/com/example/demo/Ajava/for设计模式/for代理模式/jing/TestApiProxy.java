/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: TestApiProxy
 * Author:   gyr
 * Date:     2020/8/3 17:22
 * Description:
 */
package com.example.demo.Ajava.for设计模式.for代理模式.jing;

public class TestApiProxy implements TestApi {

    //代理对象中要保有一个被代理对象的实例
    private TestApi testApi;

    public TestApiProxy(TestApi testApi) {
        this.testApi = testApi;
    }

    @Override
    public String eee(String str) {

        System.out.println("----------方法之前----------");

        String eee = testApi.eee(str);

        System.out.println("----------方法之后----------");

        return eee;
    }
}