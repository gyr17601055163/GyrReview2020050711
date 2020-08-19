/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: TestSynchronized
 * Author:   gyr
 * Date:     2020/6/23 23:58
 * Description: synchronized加在普通方法上的测试代码（如果synchronized加在普通方法上，在创建线程的时候创建两个实例，
 *              那么synchronized锁将不起作用，下面是测试打码）
 */
package com.example.demo.Ajava.for线程.forSynchronized;

import java.util.ArrayList;
import java.util.List;

public class TestSynchronized {

    public static void main(String[] args) throws InterruptedException {

        List<Integer> list = new ArrayList<>();

        MySynchronizedMethod mySyn1 = new MySynchronizedMethod(list);
        Thread threadA = new Thread(mySyn1);
        threadA.start();

        MySynchronizedMethod mySyn2 = new MySynchronizedMethod(list);
        Thread threadB = new Thread(mySyn2);
        threadB.start();

        threadA.join();
        threadB.join();

        System.out.println("---===>"+list.size());
    }

}