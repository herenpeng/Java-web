package com.hrp.dao;

/**
 * Redis实现商品秒杀
 * @author hrp
 * 2020/3/18 22:49
 */
public interface SpikeDao {
    /**
     * 将商品加入库存
     * @param key
     * @param value
     */
    void addStock(String key,String value);

    /**
     * 秒杀商品
     * @param key
     * @return
     */
    String spike(String key);
}
