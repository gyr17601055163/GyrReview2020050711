/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: MyMethodInterceptor
 * Author:   gyr
 * Date:     2020/7/27 9:59
 * Description: cglib动态代理既可以为类做代理，也可以为接口做代理
 */
package com.example.demo.Ajava.for设计模式.for代理模式.dong.cglib;

import com.alibaba.fastjson.JSON;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MyMethodInterceptor<T> implements MethodInterceptor {

    private Object object;

    public MyMethodInterceptor(Object object) {
        this.object = object;
    }

    /**
     * 一般习惯性写法：会在该类的内部直接获取一个代理对象出来start
     */

    private Enhancer enhancer = new Enhancer();

    /**
     * @param tClass 被代理对象的类类
     * @return 被代理对象
     */
    public T getObject(Class<?> tClass){

        //设置被代理对象的superclass
        enhancer.setSuperclass(tClass);

        //设置被代理对象运行时的代理方法的回调
        enhancer.setCallback(this);

        //创建被代理对象
        T t = (T)enhancer.create();

        return t;
    }
    /**
     * 一般习惯性写法：会在该类的内部直接获取一个代理对象出来end
     */

    /**
     * @param o 代理对象
     * @param method 要执行的代理对象的代理方法
     * @param objects 方法中间的参数
     * @param methodProxy 代理方法对象
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println(method.getName()+"---->"+ JSON.toJSONString(objects));

        //对被代理类中的代理发方法进行增强 - start
        /**
         * 参数一：原实例对象
         * 参数二：方法参数
         */
        method.invoke(object,objects);
        //对被代理类中的代理发方法进行增强 - end

        return null;
    }
}