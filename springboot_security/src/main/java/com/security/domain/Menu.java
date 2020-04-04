package com.security.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.List;

/**
 * @author hrp
 * 2020/3/27 11:40
 */
@Data
@TableName("menu")
public class Menu {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String pattern;

    @TableField(exist = false)
    private String name;
    @TableField(exist = false)
    private String description;

}
