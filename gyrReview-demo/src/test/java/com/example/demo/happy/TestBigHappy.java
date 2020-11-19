package com.example.demo.happy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestBigHappy {


    @Test
    public void test1(){
        System.out.println("-------------------------------11");
        String[] arr11=                        {"03,09","01,09","03,07","02,05","02,06","02,07","05,11"};
        test2(arr11);
        System.out.println("-------------------------------10");
        String[] arr10={"06,12","08,09","03,07","04,10","04,12","04,07","02,08","09,12","07,09","07,10"};
        test2(arr10);
        System.out.println("-------------------------------09");
        String[] arr09={"04,12","04,10","06,12","03,11","02,07","02,08","04,11","07,11","05,12","11,12"};
//                       +2 +0   +4 -1   -3 +5   +1 -1   +2 +4   +2 -1   -2 -2   +2 +1   +2 -3   -4 -2
        test2(arr09);
        System.out.println("-------------------------------arr2008");
        String[] arr2008={"01,02","01,12","04,08","04,10","02,03","06,12","04,09","04,08","08,10","09,10"};
//                         +3+10   +3 +2   +2 +4   -1 +1   0  +4   -4 -4   0  +2   +3 +3   +3 +2   +2 +2
        test2(arr2008);
        System.out.println("-------------------------------arr1908");
        String[] arr1908={"02,07","02,07","03,04","07,09","01,07","08,11","02,07","07,12","06,08","03,12"};
        test2(arr1908);
    }

    public void test2(String[] arr){
        int one=0;
        int two=0;
        int sum1=0;
        int sum2=0;
        for (int i=0;i<arr.length;i++){
            String[] split = arr[i].split(",");
            sum1+=Integer.valueOf(split[0]);
            sum2+=Integer.valueOf(split[1]);
            System.out.println(arr[i]+"："+(Integer.valueOf(split[0])%3)+"   "+(Integer.valueOf(split[1])%3)+"  |  " +
                    ""+(Integer.valueOf(split[0])%3)%2+"   "+(Integer.valueOf(split[1])%3)%2+"  |  " +
                    ""+(((Integer.valueOf(split[0])%3)%2)==((Integer.valueOf(split[1])%3)%2)?0:1));
            if (((Integer.valueOf(split[0])%3)%2)==((Integer.valueOf(split[1])%3)%2)){
                one++;
            }else{
                two++;
            }
        }
        System.out.println(sum1+","+sum2+"                   "+(sum1+sum2));
        System.out.println("                                 "+one+"  "+two);
    }
}
