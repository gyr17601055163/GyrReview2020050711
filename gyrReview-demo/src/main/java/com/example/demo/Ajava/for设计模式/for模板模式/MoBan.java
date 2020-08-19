/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: MoBan
 * Author:   gyr
 * Date:     2020/8/7 16:51
 * Description:
 */
package com.example.demo.Ajava.for设计模式.for模板模式;

public abstract class MoBan {

    //定义一个模板方法
    public void template(){

        System.out.println("==============班长：大家来填表格了");

        //填写表格
        test();
    }


    //定义一个抽象方法
    public abstract void test();

}