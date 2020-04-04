package com.hrp.test;

import com.hrp.dao.CustomerDao;
import com.hrp.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.data.web.PageableDefault;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.lang.model.element.VariableElement;
import javax.persistence.criteria.*;
import java.util.List;

/**
 * @author hrp
 * @date 2020/2/7 15:47
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class SpecTest {

    @Autowired
    private CustomerDao customerDao;

    /**
     * 条件查询
     */
    @Test
    public void testSpec() {
        Specification<Customer> spec = new Specification<Customer>() {
            @Override
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
                //获取比较的属性
                Path<Object> custName = root.get("custName");
                Predicate like = builder.like(custName.as(String.class), "刘%");
                return like;
            }
        };
        Sort sort = new Sort(Sort.Direction.DESC,"custId");
        List<Customer> list = customerDao.findAll(spec,sort);
        for (Customer customer : list) {
            System.out.println(customer);
        }
    }

    /**
     * 分页查询
     */
    @Test
    public void testSpec2(){
        Pageable pageable = PageRequest.of(0,2);

        Page<Customer> page = customerDao.findAll(pageable);

        System.out.println(page.getContent());//获取集合列表
        System.out.println(page.getTotalElements());//获取总条数
        System.out.println(page.getTotalPages());//获取总页数
    }






}
