package com.hrp.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hrp.domain.Product;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.List;

/**
 * @author hrp
 * 2020/3/21 21:20
 */
public interface ProductService {

    /**
     * 分页查询商品
     * @param currentPage
     * @param size
     * @return
     * @throws Exception
     */
    IPage<Product> findByPage(Integer currentPage, Integer size) throws Exception;


    /**
     * 保存产品信息
     * @param product
     * @throws Exception
     */
    void saveProduct(Product product) throws Exception;

    /**
     * 通过ID查找产品信息
     * @param id
     * @return
     * @throws Exception
     */
    Product findById(Integer id) throws Exception;

    /**
     * 更新商品信息
     * @param product
     * @throws Exception
     */
    void updateProduct(Product product) throws Exception;

    /**
     * 查找今日热卖产品列表
     * @return
     * @throws Exception
     */
    List<Product> findTodayHot() throws Exception;

    /**
     * 查找最新上架
     * @return
     * @throws Exception
     */
    List<Product> findNewarrival() throws Exception;
}
