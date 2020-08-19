/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: MyCallable
 * Author:   gyr
 * Date:     2020/6/25 14:33
 * Description:
 */
package com.example.demo.Ajava.for线程.for线程返回值;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

public class MyCallable implements Callable<String> {

    private CountDownLatch countDownLatch;

    public MyCallable(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public String call() throws Exception {
        System.out.println("------------"+Thread.currentThread().getName()+"执行了该代码");
        countDownLatch.countDown(); //进行减一操作
        Thread.sleep(8000);
        return "ok";
    }

}