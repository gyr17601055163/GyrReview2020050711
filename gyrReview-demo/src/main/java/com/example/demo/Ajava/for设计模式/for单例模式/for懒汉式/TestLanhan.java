/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: TestLanhan
 * Author:   gyr
 * Date:     2020/8/7 11:37
 * Description:
 */
package com.example.demo.Ajava.for设计模式.for单例模式.for懒汉式;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TestLanhan {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        LanHan instance = LanHan.getInstance();

        /**
         * 通过多线程来测试懒汉式的线程安全性
         */
        FutureTask<LanHan> futureTask = new FutureTask<>(new Callable<LanHan>() {
            @Override
            public LanHan call() throws Exception {
                return LanHan.getInstance();
            }
        });
        Thread thread = new Thread(futureTask);
        thread.start();

        FutureTask<LanHan> futureTask2 = new FutureTask<>(new Callable<LanHan>() {
            @Override
            public LanHan call() throws Exception {
                return LanHan.getInstance();
            }
        });
        Thread thread2 = new Thread(futureTask2);
        thread2.start();

        FutureTask<LanHan> futureTask3 = new FutureTask<>(new Callable<LanHan>() {
            @Override
            public LanHan call() throws Exception {
                return LanHan.getInstance();
            }
        });
        Thread thread3 = new Thread(futureTask3);
        thread3.start();

        LanHan lanHan = futureTask.get();
        LanHan lanHan2 = futureTask2.get();
        LanHan lanHan3 = futureTask3.get();

        /*System.out.println(i+"---1---"+(lanHan == lanHan2));
        System.out.println(i+"---2---"+(lanHan3 == lanHan2));
        System.out.println(i+"---3---"+(lanHan == lanHan3));*/

        System.out.println(lanHan == lanHan2);
        System.out.println(lanHan == lanHan3);
        System.out.println(lanHan2 == lanHan3);

    }
}