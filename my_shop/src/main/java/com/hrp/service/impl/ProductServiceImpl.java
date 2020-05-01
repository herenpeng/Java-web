package com.hrp.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hrp.domain.Product;
import com.hrp.mapper.ProductMapper;
import com.hrp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author hrp
 * 2020/3/21 21:21
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public IPage<Product> findByPage(Integer currentPage, Integer size) throws Exception {
        IPage<Product> page = new Page<>(currentPage,size);
        return page.setRecords(productMapper.findByPage(page));
    }

    @Override
    public void saveProduct(Product product) throws Exception {
        product.setDate(new Date());
        product.setSales(0);
        productMapper.saveProduct(product);
    }

    @Override
    public Product findById(Integer id) throws Exception{
        return productMapper.findById(id);
    }

    @Override
    public void updateProduct(Product product) throws Exception {
        productMapper.updateById(product);
    }

    @Override
    public List<Product> findTodayHot() throws Exception {
        return productMapper.findTodayHot();
    }

    @Override
    public List<Product> findNewarrival() throws Exception {
        return productMapper.findNewarrival();
    }
}
