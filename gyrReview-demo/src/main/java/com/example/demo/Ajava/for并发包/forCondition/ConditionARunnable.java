/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: ConditionARunnable
 * Author:   gyr
 * Date:     2020/6/27 9:02
 * Description:
 */
package com.example.demo.Ajava.for并发包.forCondition;

public class ConditionARunnable implements Runnable {

    private MyConditonUtils myConditonUtils;

    public ConditionARunnable(MyConditonUtils myConditonUtils) {
        this.myConditonUtils = myConditonUtils;
    }

    @Override
    public void run() {

        myConditonUtils.waitA();
        System.out.println("------A---获得通知 继续运行--------");
    }
}