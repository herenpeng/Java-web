package com.hrp.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hrp.dao.CategoryDao;
import com.hrp.domain.Category;
import com.hrp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hrp
 * 2020/3/21 10:01
 */
@Service
@Transactional(rollbackFor = {Exception.class})
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public IPage<Category> findByPage(Integer currentPage, Integer size) throws Exception {
        IPage<Category> page = new Page<>(currentPage,size);
        return page.setRecords(categoryDao.findByPage(page));
    }

    @Override
    public List<Category> findParentCategory() throws Exception {
        Map<String,Object> map = new HashMap<>(16);
        map.put("parent",0);
        return categoryDao.selectByMap(map);
    }

    @Override
    public void addCategory(Category category) throws Exception {
        int i = 1/0;
        categoryDao.insert(category);
    }

    @Override
    public Category findById(Integer id) throws Exception {
        return categoryDao.selectById(id);
    }

    @Override
    public void updateCategory(Category category) throws Exception {
        categoryDao.updateById(category);
    }

    @Override
    public void deleteCategory(Integer id) throws Exception {
        categoryDao.deleteById(id);
    }
}
