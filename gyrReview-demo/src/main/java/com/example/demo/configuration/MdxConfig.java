package com.example.demo.configuration;

import com.example.demo.configuration.interceptor.MdxInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class MdxConfig extends WebMvcConfigurationSupport {

    @Autowired
    private MdxInterceptor mdxInterceptor;

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        //添加拦截器并且拦截所有的请求
        registry.addInterceptor(mdxInterceptor).addPathPatterns("/**");
    }
}
