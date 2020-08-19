/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: LanHan
 * Author:   gyr
 * Date:     2020/8/7 11:34
 * Description:
 */
package com.example.demo.Ajava.for设计模式.for单例模式.for懒汉式;

import java.io.Serializable;

public class LanHan implements Serializable {

    private static LanHan lanHan;

    //构造方法私有化
    private LanHan(){

    }

    public static LanHan getInstance(){

        //保证线程安全
        synchronized (LanHan.class){
            if (lanHan == null){
                lanHan = new LanHan();
                return lanHan;
            }else {
                return lanHan;
            }
        }

    }

}