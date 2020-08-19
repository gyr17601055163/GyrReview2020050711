/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: ConditionBThread
 * Author:   gyr
 * Date:     2020/6/26 12:57
 * Description:
 */
package com.example.demo.Ajava.for并发包.forCondition;

public class ConditionBThread /*implements Runnable*/ extends Thread {

    private MyConditonUtils myConditonUtils;

    public ConditionBThread(MyConditonUtils myConditonUtils) {
        this.myConditonUtils = myConditonUtils;
    }

    @Override
    public void run() {

        myConditonUtils.waitB();
        System.out.println("------B---获得通知 继续运行--------");
    }
}