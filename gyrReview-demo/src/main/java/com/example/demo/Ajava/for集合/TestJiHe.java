/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: TestJiHe
 * Author:   gyr
 * Date:     2020/6/28 14:06
 * Description:
 */
package com.example.demo.Ajava.for集合;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Vector;

public class TestJiHe {

    List arrayList = new ArrayList();

    List linkedList = new LinkedList();

    List vector = new Vector();


    Map map = new LinkedHashMap();

    public static void main(String[] args) {


        int a=(int)(Math.random()*35)+1;

        int b;

        for(;;){

            //选出的0-34加上1赋值给b变量变成了1-35
            b=(int)(Math.random()*35)+1;

            //如果b等于a，下面重新随机选，只有不等于a才跳出此循环
            if(b==a){

                b=(int)(Math.random()*35)+1;

            }else{

                break;

            }

        }


        int c;

        for(;;){

            c=(int)(Math.random()*35)+1;//选出的0-34加上1赋值给c变量变成了1-35

            if(c==a||c==b){//如果c等于a或c等于b下面重新选，只有不等于a才跳出此循环

                c=(int)(Math.random()*35)+1;

            }else{

                break;

            }

        }


        int d;//d和上面选b选c代码大同小异

        for(;;){

            d=(int)(Math.random()*35)+1;

            if(d==a||d==b||d==c){

                d=(int)(Math.random()*35)+1;

            }else{

                break;

            }

        }


        int e;//e和上面选b选c代码大同小异

        for(;;){

            e=(int)(Math.random()*35)+1;

            if(e==a||e==b||e==c||e==d){

                e=(int)(Math.random()*35)+1;

            }else{

                break;

            }

        }


        System.out.print("\t\n");

        System.out.print("\t\n");

        System.out.print("\t\n");


        int h=(int)(Math.random()*12)+1;//选出的0-11加上1赋值给h变量变成了1-12

        int i;

        for(;;){

            i=(int)(Math.random()*12)+1;//选出的0-11加上1赋值给i变量变成了1-12

            if(i==h){//如果i等于h，下面重新随机选，只有不等于h才跳出此循环

                i=(int)(Math.random()*12)+1;

            }else{

                break;

            }

        }


        System.out.print("体彩大乐透选号：["+a+" "+b+" "+c+" "+d+" "+e+" + "+h+" "+i+"]");

        System.out.print("\t\n");

        System.out.print("\t\n");

        System.out.print("\t\n");

    }

}