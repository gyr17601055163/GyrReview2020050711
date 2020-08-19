/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: TestMyCglib00
 * Author:   gyr
 * Date:     2020/7/31 20:21
 * Description:
 */
package com.example.demo.Zreview.for设计模式.cglib;


public class TestMyCglib00 {
    public static void main(String[] args) {

        MyCglib00Api myCglib00Api = new MyCglib00Api();

        My00MethodInterceptor<MyCglib00Api> myCglib00ApiMy00MethodInterceptor =
                new My00MethodInterceptor<>(myCglib00Api);

        MyCglib00Api object = myCglib00ApiMy00MethodInterceptor.getObject(MyCglib00Api.class);

        object.ttt("555");


    }
}