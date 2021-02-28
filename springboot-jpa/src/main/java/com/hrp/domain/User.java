package com.hrp.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author hrp
 * @date 2020/2/7 22:30
 */
@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
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
