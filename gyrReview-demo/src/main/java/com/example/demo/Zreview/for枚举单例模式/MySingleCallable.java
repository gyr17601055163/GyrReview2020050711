/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: MySingleCallable
 * Author:   gyr
 * Date:     2020/6/19 21:55
 * Description:
 */
package com.example.demo.Zreview.for枚举单例模式;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

public class MySingleCallable implements Callable<ForSingleObject> {

    private CountDownLatch countDownLatch;

    public MySingleCallable(CountDownLatch countDownLatch){
        this.countDownLatch = countDownLatch;
    }

    @Override
    public ForSingleObject call() throws Exception {
        ForSingleObject singleObject = ForSingleEnum.SINGLE.getSingleObject();
        countDownLatch.countDown();
        return singleObject;
    }
}