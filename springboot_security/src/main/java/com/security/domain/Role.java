package com.security.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author hrp
 * 2020/3/26 19:11
 */
@Data
@TableName("role")
public class Role {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private String description;
}
