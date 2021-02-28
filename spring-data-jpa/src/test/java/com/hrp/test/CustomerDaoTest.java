package com.hrp.test;

import com.hrp.dao.CustomerDao;
import com.hrp.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author hrp
 * @date 2020/2/7 13:02
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class CustomerDaoTest {

    @Autowired
    private CustomerDao customerDao;

    /**
     * 查询一个客户
     */
    @Test
    public void testFindOne() {
        Customer customer =  customerDao.findById(2L).get();
        System.out.println(customer);
    }

    /**
     * 客户对象没有id，save是保存操作
     */
    @Test
    public void testSave(){
        Customer customer = new Customer();
        customer.setCustName("刘兴福");
        customer.setCustIndustry("学校");
        customerDao.save(customer);
    }

    /**
     * 更新按照对象中的值，全部更新
     */
    @Test
    public void testUpdate(){
        Customer customer = customerDao.findById(4L).get();
        customer.setCustName("龚志强");
        customerDao.save(customer);
    }

    /**
     * 查询一个客户
     */
    @Test
    public void testDelete(){
        customerDao.deleteById(4L);
    }

    /**
     * 查询所有客户
     */
    @Test
    public void testFindAll(){
        List<Customer> list = customerDao.findAll();
        for (Customer customer : list) {
            System.out.println(customer);
        }
    }

    /**
     * 测试统计查询，查询客户总数量
     */
    @Test
    public void testCount(){
        long count = customerDao.count();
        System.out.println(count);
    }

    /**
     * 判断一条数据是否存在
     */
    @Test
    public void testExistsById(){
        boolean flag = customerDao.existsById(2L);
        System.out.println(flag);
    }


}
