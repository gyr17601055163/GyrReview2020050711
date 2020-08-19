/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: MyTest
 * Author:   gyr
 * Date:     2020/8/19 15:10
 * Description:
 */
package com.example.demo.Ajava.for设计模式.for责任链模式.自定义过滤器链;

public class MyTest {
    public static void main(String[] args) {

        MyFilter filter1 = new MyFilterImpl1("A");

        MyFilter filter2 = new MyFilterImpl2("B");

        MyFilter filter3 = new MyFilterImpl3("C");


        MyFilterChain myFilterChain = new MyFilterChainImpl();

        myFilterChain.register(filter1);

        myFilterChain.register(filter2);

        myFilterChain.register(filter3);


        myFilterChain.chain();


    }
}