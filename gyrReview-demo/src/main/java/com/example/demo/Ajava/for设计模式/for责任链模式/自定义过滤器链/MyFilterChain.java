/**
 * Copyright (C),2018-2020, XXX有限公司
 * FileName: MyFilterChain
 * Author:   gyr
 * Date:     2020/8/19 14:54
 * Description:
 * History:
 */
package com.example.demo.Ajava.for设计模式.for责任链模式.自定义过滤器链;


public interface MyFilterChain {


    public void chain();


    public void register(MyFilter filter);

}