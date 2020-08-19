/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: MyCallable
 * Author:   gyr
 * Date:     2020/6/19 20:12
 * Description:
 */
package com.example.demo.Ajava.for设计模式.for单例模式;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

/**
 * 创建线程的方式之一：实现Callable接口，并实现其中的call()方法
 */
public class MyCallable implements Callable<ForDanLiObject> {

    private CountDownLatch countDownLatch;

    public MyCallable(CountDownLatch countDownLatch){
        this.countDownLatch = countDownLatch;
    }

    @Override
    public ForDanLiObject call() throws Exception {

        ForDanLiObject singleObject = ForDanLiEnum.SINGLE.getSingle();
        /**
         * 【CountDownLatch同步计数器，当计数器数值减为0时，所有受其影响而等待的线程将会被激活】
         * CountDownLatch典型用法：1、某一线程在开始运行前等待n个线程执行完毕。将CountDownLatch的计数器初始化为new CountDownLatch(n)，
         * 每当一个任务线程执行完毕，就将计数器减1 countdownLatch.countDown()，当计数器的值变为0时，在CountDownLatch上await()的线程就会被唤醒。
         * 一个典型应用场景就是启动一个服务时，主线程需要等待多个组件加载完毕，之后再继续执行。
         */
        countDownLatch.countDown();        //计数器减1
        return singleObject;
    }
}