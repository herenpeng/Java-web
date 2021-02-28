package com.hrp.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * @author hrp
 * @date 2020/2/6 23:30
 */
@Data
@Entity
@Table(name = "cst_customer")
public class Customer {
    /**
     * 客户主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cust_id")
    private Long custId;
    /**
     * 客户名称
     */
    @Column(name = "cust_name")
    private String custName;
    /**
     * 客户来源
     */
    @Column(name = "cust_source")
    private String custSource;
    /**
     * 客户级别
     */
    @Column(name = "cust_level")
    private String custLevel;
    /**
     * 客户所属行业
     */
    @Column(name = "cust_industry")
    private String custIndustry;
    /**
     * 客户联系方式
     */
    @Column(name = "cust_phone")
    private String custPhone;
    /**
     * 客户地址
     */
    @Column(name = "cust_address")
    private String custAddress;

}
