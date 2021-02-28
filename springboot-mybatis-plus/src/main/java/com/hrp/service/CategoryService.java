package com.hrp.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hrp.domain.Category;

import java.util.List;

/**
 * @author hrp
 * 2020/3/21 10:01
 */
public interface CategoryService {

    /**
     * 查找品牌分类信息
     * @param currentPage
     * @param size
     * @return
     * @throws Exception
     */
    IPage<Category> findByPage(Integer currentPage, Integer size) throws Exception;

    /**
     * 查找所有的父类别
     * @return
     * @throws Exception
     */
    List<Category> findParentCategory() throws Exception;

    /**
     * 添加商品类别
     * @param category
     * @throws Exception
     */
    void addCategory(Category category) throws Exception;

    /**
     * 通过id查找一个Category
     * @param id
     * @return
     * @throws Exception
     */
    Category findById(Integer id) throws Exception;

    /**
     * 更新商品类型
     * @param category
     * @throws Exception
     */
    void updateCategory(Category category) throws Exception;

    /**
     * 通过id删除商品类型
     * @param id
     * @throws Exception
     */
    void deleteCategory(Integer id) throws Exception;
}
