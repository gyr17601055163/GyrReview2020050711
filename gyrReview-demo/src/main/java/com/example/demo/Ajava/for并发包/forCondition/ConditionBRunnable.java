/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: ConditionBRunnable
 * Author:   gyr
 * Date:     2020/6/27 9:03
 * Description:
 */
package com.example.demo.Ajava.for并发包.forCondition;

public class ConditionBRunnable implements Runnable {

    private MyConditonUtils myConditonUtils;

    public ConditionBRunnable(MyConditonUtils myConditonUtils) {
        this.myConditonUtils = myConditonUtils;
    }

    @Override
    public void run() {
        myConditonUtils.waitB();
        System.out.println("------B---获得通知 继续运行--------");
    }
}