package com.example.demo.Zreview.forTest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TestObject {

    public static void main(String[] args) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        int week = -1;
        try {
            Date date = sdf.parse("2020-10-04");
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            week = cal.get(Calendar.DAY_OF_WEEK);
            System.out.println(week);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //ReadWriteLock
        //ReentrantReadWriteLock


    }
}
