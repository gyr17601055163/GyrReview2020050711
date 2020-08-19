/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: DisplayWeiLai
 * Author:   gyr
 * Date:     2020/8/19 12:55
 * Description:
 */
package com.example.demo.Ajava.for设计模式.for观察者模式.气象台案例;

import java.util.List;

public class DisplayWeiLai implements Display,Watcher {

    private WatcherData watcherData;

    private List<Float> weiLaiTianQi;//未来几天的温度


    public DisplayWeiLai(WatcherData watcherData){
        this.watcherData = watcherData;
        this.watcherData.registerWatcher(this);
    }


    @Override
    public void display() {
        System.out.println("未来几天的气温");
        for (int i = 0; i < weiLaiTianQi.size(); i++){
            System.out.println("第" + i + "天:" + weiLaiTianQi.get(i) + "℃");
        }
    }

    @Override
    public void update() {
        this.weiLaiTianQi = this.watcherData.getWeiLaiTianQi();
        display();
    }
}