/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: DanLi
 * Author:   gyr
 * Date:     2020/8/7 10:26
 * Description:
 */
package com.example.demo.Ajava.for设计模式.for单例模式.for饿汉式;

public class DanLi {

    //保有一个静态私有的自身实例
    private static DanLi danLi = new DanLi();

    //构造方法私有化
    private DanLi(){

    }


    public static DanLi getDanLi(){
        return danLi;
    }


}