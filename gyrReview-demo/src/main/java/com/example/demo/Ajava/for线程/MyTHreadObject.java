/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: MyTHreadObject
 * Author:   gyr
 * Date:     2020/6/23 10:20
 * Description:
 */
package com.example.demo.Ajava.for线程;

import java.util.List;

public class MyTHreadObject implements Runnable {

    private List<Integer> list;

    public MyTHreadObject(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5000; i++){
            synchronized (MyTHreadObject.class){
                System.out.println(Thread.currentThread().getName()+"添加成功"+i);
                list.add(i);
            }
        }
    }
}