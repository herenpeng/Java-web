package com.hrp.service;

/**
 * @author hrp
 * 2020/3/18 22:47
 */
public interface SpikeService {
    /**
     * 将商品加入库存
     * @param stock
     */
    void addStock(int stock);

    /**
     * 秒杀商品
     * @return
     */
    String spike() ;
}
