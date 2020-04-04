package com.hrp.dao;

import com.hrp.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author hrp
 * @date 2020/2/7 12:57
 */
public interface CustomerDao extends JpaRepository<Customer,Long>, JpaSpecificationExecutor<Customer> {

    @Query(value = "from Customer where custName = ?1")
    Customer findJpql(String custName);

    Customer findByCustNameAndCustId(String name,Long id);


    @Query("update Customer set custName = ?2 where custId = ?1")
    @Modifying
    void updateCustomer(long custId,String custName);


    @Query(value = "select * from cst_customer",nativeQuery = true)
    public List<Object[]> findSql();

    @Query(value = "select * from cst_customer where cust_name = ?1",nativeQuery = true)
    public List<Object[]> findSqlWhere(String name);

    List<Customer> findByCustNameLike(String custName);

//=========================jpa动态查询===========================================




}
