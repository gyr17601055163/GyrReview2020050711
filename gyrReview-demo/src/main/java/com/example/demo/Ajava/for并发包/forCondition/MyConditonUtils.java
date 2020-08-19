/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: MyConditonUtils
 * Author:   gyr
 * Date:     2020/6/26 9:46
 * Description:
 */
package com.example.demo.Ajava.for并发包.forCondition;

import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyConditonUtils {

    private Lock lock = new ReentrantLock();

    private Condition conditionA = lock.newCondition();

    private Condition conditionB = lock.newCondition();

    /**
     * conditionA等待
     */
    public void waitA(){
        //获取锁
        lock.lock();

        try {
            System.out.println("conditionA  进入等待状态");

            //当前线程进入condition的等待队列中，并释放锁
            conditionA.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {

            //释放锁
            lock.unlock();
        }

    }

    /**
     * conditionA通知
     */
    public void signalA(){
        lock.lock();

        try {
            System.out.println("conditionA  获得通知可以继续运行");

            conditionA.signal();
        }finally {
            lock.unlock();
        }

    }

    /**
     * conditionB等待
     */
    public void waitB(){
        lock.lock();

        try {

            System.out.println("conditionB  进入等待状态");

            conditionB.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /**
     * conditionB通知
     */
    public void signalB(){
        lock.lock();

        try {

            System.out.println("conditionB  获得通知可以继续运行");

            conditionB.signal();
        }finally {
            lock.unlock();
        }
    }

}