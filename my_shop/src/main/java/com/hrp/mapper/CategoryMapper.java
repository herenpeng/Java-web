package com.hrp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hrp.domain.Category;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author hrp
 * 2020/3/21 9:47
 */
public interface CategoryMapper extends BaseMapper<Category> {

    /**
     * 查找商品分类信息
     * @param page
     * @return
     * @throws Exception
     */
    @Select("select p.id,p.name,c.id cid,c.name cname from category p left join category c on p.id = c.parent where p.parent = 0")
    List<Category> findByPage(IPage<Category> page) throws Exception;

    /**
     * 查找所有商品分类信息
     * @return
     */
    @Select("select p.id,p.name,c.id cid,c.name cname from category p right join category c on p.id = c.parent where p.parent = 0")
    List<Category> findAll() throws Exception;
}
