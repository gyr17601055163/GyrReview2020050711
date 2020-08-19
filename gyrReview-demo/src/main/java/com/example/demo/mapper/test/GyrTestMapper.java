/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: GyrTestMapper
 * Author:   gyr
 * Date:     2020/6/19 18:09
 * Description:
 */
package com.example.demo.mapper.test;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface GyrTestMapper {

    public List<Map<String,Object>> queryTest();

}