/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: MyFilterImpl1
 * Author:   gyr
 * Date:     2020/8/19 14:55
 * Description:
 */
package com.example.demo.Ajava.for设计模式.for责任链模式.自定义过滤器链;

public class MyFilterImpl1 implements MyFilter {

    private String name;

    public MyFilterImpl1(String name){
        this.name = name;
    }

    @Override
    public void doFilter(MyFilterChain chain) {
        System.out.println("=======自己的filter业务======"+name);
        chain.chain();
    }
}