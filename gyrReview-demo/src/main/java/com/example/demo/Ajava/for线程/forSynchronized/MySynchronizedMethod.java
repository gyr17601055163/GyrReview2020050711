/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: MySynchronizedMethod
 * Author:   gyr
 * Date:     2020/6/23 23:43
 * Description: Synchronized加在普通方法上和加在静态方法上的区别
 *              Synchronized加在普通方法上 演示
 */
package com.example.demo.Ajava.for线程.forSynchronized;

import java.util.List;

public class MySynchronizedMethod implements Runnable{

    private List<Integer> list;

    public MySynchronizedMethod(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50000; i++){
            this.add(i);
        }
    }

    /**
     * synchronized加在普通方法上，那它的锁对象就是当前方法所在类的类实例（类实例：每新nuw一个对象就是一个实例对象）
     * @param integer
     */
    public synchronized void add(Integer integer){
        list.add(integer);
    }
}