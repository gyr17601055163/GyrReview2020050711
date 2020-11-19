/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: aopMaxInterceptor
 * Author:   gyr
 * Date:     2020/11/19 22:27
 * Description:
 */
package com.example.demo.configuration.interceptor;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class aopMaxInterceptor {

    /**
     * 定义切面表达式
     */
    @Pointcut("execution(public * com.example.demo.web.*.*(..))")
    public void pointCut(){

    }



}