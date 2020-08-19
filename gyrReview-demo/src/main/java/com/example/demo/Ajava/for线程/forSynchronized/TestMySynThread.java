/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: TestMySynThread
 * Author:   gyr
 * Date:     2020/6/24 0:20
 * Description:
 */
package com.example.demo.Ajava.for线程.forSynchronized;

import java.util.ArrayList;
import java.util.List;

public class TestMySynThread {

    public static void main(String[] args) throws InterruptedException {

        MySynThread mySynThread1 = new MySynThread();
        Thread thread1 = new Thread(mySynThread1);
        thread1.start();

        MySynThread mySynThread2 = new MySynThread();
        Thread thread2 = new Thread(mySynThread2);
        thread2.start();

        thread1.join();
        thread2.join();

        Integer size = MySynThread.getSize();
        System.out.println("===+++===>"+size);

    }

}