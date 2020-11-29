/**
 * Copyright (C), 2018-2020, TODO有限公司
 * FileName: Stock
 * Author:   gyr
 * Date:     2020/11/29 14:08
 * Description:
 */
package com.example.demo.A分布式锁.forRedis;

import lombok.Data;

import java.io.Serializable;

/**
 * 库存表
 */
@Data
public class Stock implements Serializable {
    //库存表ID
    private Long id;
    //商品ID
    private Long goodsId;
    //用户ID
    private String userId;
    //库存
    private Long stock;
}