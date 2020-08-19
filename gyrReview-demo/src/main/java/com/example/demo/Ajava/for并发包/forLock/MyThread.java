/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: MyThread
 * Author:   gyr
 * Date:     2020/7/7 15:38
 * Description:
 */
package com.example.demo.Ajava.for并发包.forLock;

import java.util.concurrent.locks.ReentrantLock;

public class MyThread extends Thread {

    private ReentrantLock reentrantLock;


    public MyThread(ReentrantLock reentrantLock) {
        this.reentrantLock = reentrantLock;
    }

    public void run(){
        reentrantLock.lock();

        try {

            for (int i = 0; i < 10; i++){
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(500);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }

    }

}