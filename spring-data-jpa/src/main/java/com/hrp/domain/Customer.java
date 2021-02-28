package com.hrp.domain;

import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author hrp
 * @date 2020/2/6 23:30
 */
@Data
@Entity
@Table(name = "cst_customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cust_id")
    private Long custId;//客户主键
    @Column(name = "cust_name")
    private String custName;//客户名称
    @Column(name = "cust_source")
    private String custSource;//客户来源
    @Column(name = "cust_level")
    private String custLevel;//客户级别
    @Column(name = "cust_industry")
    private String custIndustry;//客户所属行业
    @Column(name = "cust_phone")
    private String custPhone;//客户联系方式
    @Column(name = "cust_address")
    private String custAddress;//客户地址

//    @OneToMany(targetEntity = LinkMan.class)
//    @JoinColumn(name = "lkm_cust_id",referencedColumnName = "cust_id")

    @OneToMany(mappedBy = "customer")
    @Cascade(CascadeType.ALL)
    private Set<LinkMan> linkMans = new HashSet<>();

}
