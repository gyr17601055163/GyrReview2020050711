/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: Test000
 * Author:   gyr
 * Date:     2020/8/19 12:59
 * Description:
 */
package com.example.demo.Ajava.for设计模式.for观察者模式.气象台案例;

import java.util.ArrayList;
import java.util.List;

public class Test000 {
    public static void main(String[] args) {

        WatcherData watcherData = new WatcherData();

        DisplayNew displayNew = new DisplayNew(watcherData);

        DisplayWeiLai weiLai = new DisplayWeiLai(watcherData);


        List<Float> weiLaiList = new ArrayList<>();
        weiLaiList.add(22f);
        weiLaiList.add(23f);
        weiLaiList.add(24f);
        weiLaiList.add(25f);
        weiLaiList.add(262f);
        weiLaiList.add(27f);
        weiLaiList.add(20f);

        watcherData.setData(22f,0.8f,1.2f,weiLaiList);


    }
}