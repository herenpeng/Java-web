package com.hrp.domain;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author hrp
 * 2020/2/20 20:18
 */
@Data
@TableName("user")
public class User implements Serializable {
    @TableId(type = IdType.AUTO)
    @Excel(name = "ID", orderNum = "0", width = 15)
    private Integer id;
    @Excel(name = "用户名", orderNum = "1", width = 15)
    private String username;
    private String password;
    @Excel(name = "姓名", orderNum = "2", width = 15)
    private String name;

    private Integer gender;
    @TableField(exist = false)
    @Excel(name = "性别", orderNum = "3", width = 15)
    private String genderStr;
    @Excel(name = "出生日期", orderNum = "4", width = 30, format = "yyyy-MM-dd")
    private Date birthday;
    @Excel(name = "手机号码", orderNum = "5", width = 15)
    private String phone;
    private String picture;
    private String address1;
    private String address2;
    private String address3;
    private Integer power;
    @TableField(exist = false)
    @Excel(name = "角色",orderNum = "6",width = 15)
    private String powerStr;

    public String getGenderStr() {
        if (gender != null) {
            if (gender == 1) {
                return "男";
            } else {
                return "女";
            }
        }
        return null;
    }

    public String getPowerStr() {
        if (power != null) {
            if (power == 1) {
                return "普通用户";
            } else if (power == 2) {
                return "普通管理员";
            } else if (power == 3) {
                return "超级管理员";
            }
        }
        return null;
    }
}
