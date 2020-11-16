package com.example.demo.Ajava.forKnowledge.forCountDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TestCountDownLatch {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        CountDownLatch countDownLatch = new CountDownLatch(4);

        FutureTask<String> futureTask1 = new FutureTask<>(new MyCallable01(countDownLatch));
        Thread thread1 = new Thread(futureTask1);
        thread1.start();

        FutureTask<String> futureTask2 = new FutureTask<>(new MyCallable01(countDownLatch));
        Thread thread2 = new Thread(futureTask2);
        thread2.start();

        FutureTask<String> futureTask3 = new FutureTask<>(new MyCallable01(countDownLatch));
        Thread thread3 = new Thread(futureTask3);
        thread3.start();

        FutureTask<String> futureTask4 = new FutureTask<>(new MyCallable01(countDownLatch));
        Thread thread4 = new Thread(futureTask4);
        thread4.start();

        countDownLatch.await();

        String s1 = futureTask1.get();
        String s2 = futureTask2.get();
        String s3 = futureTask3.get();
        String s4 = futureTask4.get();


    }
}
