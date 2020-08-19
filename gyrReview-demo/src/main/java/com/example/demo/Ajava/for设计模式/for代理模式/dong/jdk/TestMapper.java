/**
 * Copyright (C),2018-2020, XXX有限公司
 * FileName: MyUserMapper
 * Author:   gyr
 * Date:     2020/7/21 23:31
 * Description:被代理接口--->模仿MyBatis的mapper层实现
 * History:
 */
package com.example.demo.Ajava.for设计模式.for代理模式.dong.jdk;


import java.util.List;
import java.util.Map;

public interface TestMapper {

    //查询user列表接口
    public List<Map<String,Object>> queryUserList(String str);


}