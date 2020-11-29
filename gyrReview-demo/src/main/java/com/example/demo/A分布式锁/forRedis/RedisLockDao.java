/**
 * Copyright (C),2018-2020, XXX有限公司
 * FileName: RedisLockDao
 * Author:   gyr
 * Date:     2020/11/29 14:07
 * Description:
 * History:
 */
package com.example.demo.A分布式锁.forRedis;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface RedisLockDao {

    @Select("select bs.id,bs.goods_id,bs.stock from base_stock bs where bs.goods_id=#{goodsId}")
    public Stock getStockByGoodsId(String goodsId);

    @Update("update base_stock bs set bs.stock=#{stock} where bs.goods_id=#{goodsId}")
    public boolean updateStock(Stock stock);
}