/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: TestCyclicBarrier
 * Author:   gyr
 * Date:     2020/6/25 18:39
 * Description:
 */
package com.example.demo.Ajava.for并发包;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestCyclicBarrier {
    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(4);

        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(4);

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4,6,60, TimeUnit.SECONDS,arrayBlockingQueue);

        test(threadPoolExecutor,cyclicBarrier);

        //CyclicBarrier和CountDownLatch的区别是：CountDownLatch只能用一次，而CyclicBarrier可重用，至需要调用reset()方法重新设置一下就可以重新用了
        cyclicBarrier.reset();

        test(threadPoolExecutor,cyclicBarrier);

        threadPoolExecutor.shutdown();

    }

    public static void test(ThreadPoolExecutor threadPoolExecutor,CyclicBarrier cyclicBarrier){
        threadPoolExecutor.execute(new MyRunnable2(cyclicBarrier,5000));
        threadPoolExecutor.execute(new MyRunnable2(cyclicBarrier,1000));
        threadPoolExecutor.execute(new MyRunnable2(cyclicBarrier,3000));
        threadPoolExecutor.execute(new MyRunnable2(cyclicBarrier,2000));
    }
}