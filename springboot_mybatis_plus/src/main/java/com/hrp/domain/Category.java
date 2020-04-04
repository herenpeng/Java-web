package com.hrp.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author hrp
 * 2020/3/21 9:45
 */
@Data
@TableName("category")
public class Category implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private Integer parent;

    @TableField(exist = false)
    private Integer cid;
    @TableField(exist = false)
    private String cname;

    public Category() {
    }

    public Category(Integer id, String name, Integer parent) {
        this.id = id;
        this.name = name;
        this.parent = parent;
    }
}
