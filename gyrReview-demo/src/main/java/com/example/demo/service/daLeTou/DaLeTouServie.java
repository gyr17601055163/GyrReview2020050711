/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: DaLeTouServie
 * Author:   gyr
 * Date:     2020/8/22 22:08
 * Description:
 */
package com.example.demo.service.daLeTou;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DaLeTouServie {


    public String getData(){
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

        //选出的0-11加上1赋值给h变量变成了1-12
        int h=(int)(Math.random()*12)+1;

        int i;

        for(;;){

            //选出的0-11加上1赋值给i变量变成了1-12
            i=(int)(Math.random()*12)+1;

            //如果i等于h，下面重新随机选，只有不等于h才跳出此循环
            if(i==h){

                i=(int)(Math.random()*12)+1;

            }else{

                break;

            }

        }

        System.out.print("\t\t");

        JSONArray jsonArray1 = new JSONArray();

        int q[]={a,b,c,d,e};

        //对数组作升序排列
        Arrays.sort(q);

        for(int j=0;j<q.length;j++){

            System.out.print(q[j]+"\t");

            jsonArray1.add(q[j]);

        }

        System.out.print("┼"+"\t");

        JSONArray jsonArray2 = new JSONArray();

        int s[]={h,i};

        Arrays.sort(s);

        for(int j=0;j<s.length;j++){

            System.out.print(s[j]+"\t");

            jsonArray2.add(s[j]);

        }


        System.out.print("\t\n");

        System.out.print("\t\n");

        System.out.print("\t\n");

        return jsonArray1+"┼"+jsonArray2;
    }
}