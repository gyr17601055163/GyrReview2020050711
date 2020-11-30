package com.example.demo.A分布式锁.forRedisson;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Mapper
@Repository
public interface RedissonLockDao {

    @Select("select bs.id,bs.goods_Id,bs.stock from base_stock bs where bs.goods_Id=#{goodsid}")
    public Map<String,Object> getStock(String goodsid);

    @Update("update base_stock bs set bs.stock=#{stock} where bs.goods_Id=#{goodsId}")
    public boolean updateStock(Map<String,Object> stock);
}
