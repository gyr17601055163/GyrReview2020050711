/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: MyFilterChainImpl
 * Author:   gyr
 * Date:     2020/8/19 14:56
 * Description:
 */
package com.example.demo.Ajava.for设计模式.for责任链模式.自定义过滤器链;

import java.util.ArrayList;
import java.util.List;

public class MyFilterChainImpl implements MyFilterChain {


    private List<MyFilter> filters;

    private int count = 0;


    public MyFilterChainImpl(){
        filters = new ArrayList<>();
    }


    @Override
    public void chain() {
        if (count < filters.size()){
            MyFilter myFilter = filters.get(count);
            count++;
            myFilter.doFilter(this);
        }
    }

    @Override
    public void register(MyFilter filter) {
        filters.add(filter);
    }
}