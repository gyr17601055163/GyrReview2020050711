/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: TestUintai
 * Author:   gyr
 * Date:     2020/8/3 17:25
 * Description:
 */
package com.example.demo.Ajava.for设计模式.for代理模式.jing;

public class TestUintai {

    public static void main(String[] args) {

        //被代理对象
        TestApi testApi = new TestApiImpl();

        //代理对象
        TestApiProxy testApiProxy = new TestApiProxy(testApi);

        TestApiService service = new TestApiService();

        service.fff(testApiProxy);


    }
}