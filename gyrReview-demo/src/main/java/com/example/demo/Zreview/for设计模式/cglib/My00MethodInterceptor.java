/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: My00MethodInterceptor
 * Author:   gyr
 * Date:     2020/7/31 20:10
 * Description:
 */
package com.example.demo.Zreview.for设计模式.cglib;

import com.alibaba.fastjson.JSON;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class My00MethodInterceptor<T> implements MethodInterceptor {

    private MyCglib00Api myCglib00Api;

    public My00MethodInterceptor(MyCglib00Api myCglib00Api) {
        this.myCglib00Api = myCglib00Api;
    }

    private Enhancer enhancer = new Enhancer();

    public T getObject(Class<?> tClass){
        enhancer.setSuperclass(tClass);

        enhancer.setCallback(this);

        T o = (T)enhancer.create();

        return o;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println(method.getName()+"===="+ JSON.toJSONString(objects));
        method.invoke(myCglib00Api,objects);

        return null;
    }
}