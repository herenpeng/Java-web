package com.hrp.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hrp.domain.Category;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author hrp
 * 2020/3/21 13:31
 */
public interface CategoryDao extends BaseMapper<Category> {

    /**
     * 查找品牌分类信息
     *
     * @param page
     * @return
     * @throws Exception
     */
    @Select("select p.id,p.name,c.id cid,c.name cname from category p left join category c on p.id = c.parent where p.parent = 0")
    List<Category> findByPage(IPage<Category> page) throws Exception;
}
