/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: TsetCglib
 * Author:   gyr
 * Date:     2020/7/27 21:46
 * Description:
 */
package com.example.demo.Ajava.for设计模式.for代理模式.dong.cglib;

public class TsetCglib {
    public static void main(String[] args) {

        MyMethodInterceptor<TestCglibApi> myMethodInterceptor = new MyMethodInterceptor<>(new TestCglibApi());

        //获取代理对象
        TestCglibApi cglibApi = myMethodInterceptor.getObject(TestCglibApi.class);

        //调用被代理对的代理方法
        cglibApi.getMethod("0000");


    }
}