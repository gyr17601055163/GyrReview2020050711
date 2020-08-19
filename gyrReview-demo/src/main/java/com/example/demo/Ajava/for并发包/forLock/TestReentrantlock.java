/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: TestReentrantlock
 * Author:   gyr
 * Date:     2020/7/7 16:11
 * Description:
 */
package com.example.demo.Ajava.for并发包.forLock;

import java.util.concurrent.locks.ReentrantLock;

public class TestReentrantlock {
    public static void main(String[] args) {

        ReentrantLock reentrantLock = new ReentrantLock();

        MyThread thread1 = new MyThread(reentrantLock);
        MyThread thread2 = new MyThread(reentrantLock);

        thread1.start();
        thread2.start();


    }
}