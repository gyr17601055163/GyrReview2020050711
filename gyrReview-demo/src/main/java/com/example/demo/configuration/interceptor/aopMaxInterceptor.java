/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: aopMaxInterceptor
 * Author:   gyr
 * Date:     2020/11/19 22:27
 * Description:
 */
package com.example.demo.configuration.interceptor;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;

@Aspect
public class aopMaxInterceptor {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    /**
     * 定义切面表达式
     */
    @Pointcut("execution(public * com.example.demo.web.*.*(..))")
    public void pointCut(){

    }

    /**
     * 配置环绕通知
     * @return
     */
    @Around("pointCut() && @annotation(com.example.demo.annotation.AopMdxApi)")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //获取Servlet请求上下文的属性类
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();

        HttpServletRequest request = requestAttributes.getRequest();

        HttpServletResponse response = requestAttributes.getResponse();

        String code = request.getParameter("code");

        boolean check = codeCheck(code);
        if (check){
            return proceedingJoinPoint.proceed();
        }else{
            response.getOutputStream().print("{'msg','aop error'}");
            return null;
        }
    }

    public boolean codeCheck(String code){
        String lua="if redis.call('get',KEYS[1]) then return redis.call('del',KEYS[1]) else return 0";

        DefaultRedisScript<Long> defaultRedisScript=new DefaultRedisScript<>();

        defaultRedisScript.setResultType(Long.class);

        defaultRedisScript.setScriptText(lua);

        Long execute = redisTemplate.execute(defaultRedisScript, Collections.singletonList(code));

        if (execute==1){
            return true;
        }else{
            return false;
        }
    }


}