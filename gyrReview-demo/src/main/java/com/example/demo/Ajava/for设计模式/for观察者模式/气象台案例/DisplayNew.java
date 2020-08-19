/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: DisplayNew
 * Author:   gyr
 * Date:     2020/8/19 12:48
 * Description:
 */
package com.example.demo.Ajava.for设计模式.for观察者模式.气象台案例;


/**
 * 显示当前天气的公告牌
 */
public class DisplayNew implements Display,Watcher {

    private WatcherData watcherData;

    private float wendu;//温度
    private float shidu;//湿度
    private float qiya;//气压


    public DisplayNew(WatcherData watcherData){
        this.watcherData = watcherData;
        //将自己注册成为观察者
        this.watcherData.registerWatcher(this);
    }


    @Override
    public void display() {
        System.out.println("当前温度为：" + this.wendu + "℃");
        System.out.println("当前湿度为：" + this.shidu);
        System.out.println("当前气压为：" + this.qiya);
    }

    @Override
    public void update() {
        this.wendu = watcherData.getWendu();
        this.shidu = watcherData.getShidu();
        this.qiya = watcherData.getQiya();
        display();
    }
}