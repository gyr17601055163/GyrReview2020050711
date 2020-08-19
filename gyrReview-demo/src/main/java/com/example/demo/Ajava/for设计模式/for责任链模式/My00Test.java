/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: My00Test
 * Author:   gyr
 * Date:     2020/8/19 15:30
 * Description:
 */
package com.example.demo.Ajava.for设计模式.for责任链模式;

public class My00Test {
    public static void main(String[] args) {

        My00InterfaceImpl1 my00Interface1 = new My00InterfaceImpl1("A");
        My00InterfaceImpl1 my00Interface2 = new My00InterfaceImpl1("B");
        My00InterfaceImpl1 my00Interface3 = new My00InterfaceImpl1("C");


        my00Interface1.setMy00Interface(my00Interface2);
        my00Interface2.setMy00Interface(my00Interface3);


        my00Interface1.ttt();
    }
}