package com.hrp.test;

import com.hrp.dao.CustomerDao;
import com.hrp.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

/**
 * @author hrp
 * @date 2020/2/7 13:02
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class JpqlTest {

    @Autowired
    private CustomerDao customerDao;

    @Test
    public void tsetFindJpql(){
        Customer customer = customerDao.findJpql("刘亦菲");
        System.out.println(customer);
    }

    @Test
    public void tsetfindByCustNameAndCustId(){
        Customer customer = customerDao.findByCustNameAndCustId("刘亦菲",2L);
        System.out.println(customer);
    }


    @Test
    @Transactional
    @Rollback(false)
    public void tsetUpdateCustomer(){
        customerDao.updateCustomer(2,"刘茜茜");
        Customer customer = customerDao.findById(2L).get();
        System.out.println(customer);
    }

    @Test
    public void testFindSQL(){
        List<Object[]> list = customerDao.findSql();
        for (Object[] objects : list) {
            System.out.println(Arrays.toString(objects));
        }
    }

    @Test
    public void testFindSQLWhere(){
        List<Object[]> list = customerDao.findSqlWhere("刘茜茜");
        for (Object[] objects : list) {
            System.out.println(Arrays.toString(objects));
        }
    }

    @Test
    public void testFindBy(){
        List<Customer> list = customerDao.findByCustNameLike("刘%");
        for (Customer customer : list) {
            System.out.println(customer);
        }
    }







}
