/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: TestThreadPoolExecutor
 * Author:   gyr
 * Date:     2020/6/24 22:25
 * Description:
 */
package com.example.demo.Ajava.for线程;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestThreadPoolExecutor {

    public static void main(String[] args) {

        LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<>();

        List<Integer> list = new ArrayList<>();

        //创建线程池
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4,4,60, TimeUnit.SECONDS,linkedBlockingQueue);

        //执行任务1
        threadPoolExecutor.execute(new MyTHreadObject(list));

        //执行任务2
        threadPoolExecutor.execute(new MyTHreadObject(list));

        //关闭线程池
        threadPoolExecutor.shutdown();

    }

}