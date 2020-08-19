/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: MySynThread
 * Author:   gyr
 * Date:     2020/6/24 0:17
 * Description:Synchronized加在普通方法上和加在静态方法上的区别
 *             Synchronized加在静态方法上 演示
 */
package com.example.demo.Ajava.for线程.forSynchronized;

import java.util.ArrayList;
import java.util.List;

public class MySynThread implements Runnable{

    private static List<Integer> list = new ArrayList<>();

    @Override
    public void run() {

        for (int i = 0; i < 50000; i++){
            add(i);
        }

    }

    /**
     * synchronized加在静态方法上，那它的锁对象就是当前实例对象的类对象，相当于类名.class
     * @param integer
     */
    public static synchronized void add(Integer integer){
        list.add(integer);
    }

    public static Integer getSize(){
        return list.size();
    }
}