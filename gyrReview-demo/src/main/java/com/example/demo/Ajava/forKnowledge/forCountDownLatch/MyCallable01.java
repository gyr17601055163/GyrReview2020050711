package com.example.demo.Ajava.forKnowledge.forCountDownLatch;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Logger;

/**
 * 实现Callable接口
 * 创建线程的方式有三种：
 *      1.继承Thread类
 *      2.实现Runnable接口，重写里面的run方法
 *      3.实现Callable接口，重写里面的call方法
 * 其中Runnable和Callable的区别：
 *      run方法的返回值为void
 *      call方法的返回值是范型
 *      Callable接口结合Futruetask可以获取线程的返回值
 */
public class MyCallable01 implements Callable<String> {

    private CountDownLatch countDownLatch;

    public MyCallable01(CountDownLatch countDownLatch){
        this.countDownLatch = countDownLatch;
    }

    @Override
    public String call() throws Exception {
        System.out.println("----------------------"+countDownLatch.getCount());
        countDownLatch.countDown();
        return "";
    }

}
