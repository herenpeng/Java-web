package com.hrp.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author hrp
 * 2020/3/9 10:10
 */
@Data
public class User {
    private Long id;
    private String username;
    private String password;
    private String name;
    private Integer gender;
    private Date birthday;
    private String phone;
    private String picture;
    private String address1;
    private String address2;
    private String address3;
    private Integer power;
}
