package com.hrp.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author hrp
 * 2020/3/21 21:09
 */
@Data
@TableName("product")
public class Product {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private String picture;
    private String desc;
    private Double price;
    private Integer stock;
    private Date date;
    private Integer sales;
    @TableField(value = "category_id",el = "category.id")
    private Category category;
    @TableField(exist = false)
    private String categoryName;

}
