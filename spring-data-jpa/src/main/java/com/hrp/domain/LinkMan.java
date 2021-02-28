package com.hrp.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * @author hrp
 * @date 2020/2/7 16:32
 */
@Data
@Entity
@Table(name = "cst_linkman")
public class LinkMan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lkm_id")
    private Long lkmId;//联系人编号
    @Column(name = "lkm_name")
    private String lkmName;//联系人姓名
    @Column(name = "lkm_gender")
    private String lkmGender;//联系人性别
    @Column(name = "lkm_phone")
    private String lkmPhone;//联系人办公电话
    @Column(name = "lkm_mobile")
    private String lkmMobile;//联系人移动电话
    @Column(name = "lkm_email")
    private String lkmEmail;//联系人邮箱
    @Column(name = "lkm_position")
    private String lkmPosition;//联系人职务
    @Column(name = "lkm_memo")
    private String lkmMemo;//联系人备注

    @ManyToOne(targetEntity = Customer.class)
    @JoinColumn(name  = "lkm_cust_id",referencedColumnName = "cust_id")
    private Customer customer;

}
