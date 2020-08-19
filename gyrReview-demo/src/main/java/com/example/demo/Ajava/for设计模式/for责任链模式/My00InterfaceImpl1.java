/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: My00InterfaceImpl1
 * Author:   gyr
 * Date:     2020/8/19 15:24
 * Description:
 */
package com.example.demo.Ajava.for设计模式.for责任链模式;

public class My00InterfaceImpl1 extends MyAbstrct implements My00Interface {

    private String name;

    public My00InterfaceImpl1(String name){
        this.name = name;
    }

    @Override
    public void ttt() {
        System.out.println("------------"+name);
        if (getMy00Interface() != null){
            getMy00Interface().ttt();
        }

    }
}