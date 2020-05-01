package com.hrp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hrp.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author hrp
 * 2020/3/21 21:19
 */
public interface ProductMapper extends BaseMapper<Product> {

    /**
     * 分页查询商品
     * @param page
     * @return
     * @throws Exception
     */
    @Select("select p.id,p.name,p.picture,p.desc,p.price,p.stock,p.date,p.sales,c.name category_name from product p left join category c on p.category_id = c.id")
    List<Product> findByPage(IPage<Product> page) throws Exception;

    /**
     * 保存产品信息
     * @param product
     */
    @Insert("insert into product (`name`,`desc`,`price`,`sales`,`stock`,`date`,`category_id`) values (#{name},#{desc},#{price},#{sales},#{stock},#{date},#{category.id})")
    void saveProduct(Product product) throws Exception;

    /**
     * 用过用户id查找商品
     * @param id
     * @return
     */
    @Select("select p.id,p.name,p.picture,p.desc,p.price,p.stock,p.date,p.sales,c.name category_name from product p left join category c on p.category_id = c.id where p.id = #{id}")
    Product findById(Integer id) throws Exception;

    /**
     * 查找今日热卖商品
     * @return
     */
    @Select("select `picture`,`desc`,`price` from product order by sales desc limit 0,10;")
    List<Product> findTodayHot();

    /**
     * 查找最新上架商品
     * @return
     */
    @Select("select `picture`,`desc`,`price` from product order by date desc limit 0,10;")
    List<Product> findNewarrival();
}
