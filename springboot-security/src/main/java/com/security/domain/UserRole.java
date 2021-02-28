package com.security.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author hrp
 * 2020/3/26 21:16
 */
@Data
@TableName("user_role")
public class UserRole {
    private Integer uid;
    private Integer rid;

    public UserRole() {
    }

    public UserRole(Integer uid, Integer rid) {
        this.uid = uid;
        this.rid = rid;
    }
}
