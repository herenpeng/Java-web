package com.hrp.test;

import com.hrp.dao.CustomerDao;
import com.hrp.dao.LinkManDao;
import com.hrp.domain.Customer;
import com.hrp.domain.LinkMan;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author hrp
 * @date 2020/2/7 16:51
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class OneToManyTest {

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private LinkManDao linkManDao;

    @Test
    @Transactional
    @Rollback(false)
    public void testAdd(){
        Customer customer = new Customer();
        customer.setCustName("罗旻");
        LinkMan linkMan = new LinkMan();
        linkMan.setLkmName("张三");
        /**
         * 发送了三条SQL语句，两条insert（插入两个对象数据），一条update（更新联系人的外键）
         */
        customer.getLinkMans().add(linkMan);
        customerDao.save(customer);
        linkManDao.save(linkMan);
    }

    @Test
    @Transactional
    @Rollback(false)
    public void testAdd2(){
        Customer customer = new Customer();
        customer.setCustName("杨幂");
        LinkMan linkMan = new LinkMan();
        linkMan.setLkmName("李四");
        /**
         * 发送了两条insert语句，直接更新连个对象
         */
        linkMan.setCustomer(customer);
        customerDao.save(customer);
        linkManDao.save(linkMan);
    }

    @Test
    @Transactional
    @Rollback(false)
    public void testAdd3(){
        Customer customer = new Customer();
        customer.setCustName("柳岩");
        LinkMan linkMan = new LinkMan();
        linkMan.setLkmName("猫小胖");
        //当客户放弃了外键维护权的时候，就不能在在这里customer.getLinkMans().add(linkMan);
        linkMan.setCustomer(customer);
        customerDao.save(customer);
        linkManDao.save(linkMan);
    }

    @Test
    @Transactional
    @Rollback(false)
    public void testCascadeAdd(){
        Customer customer = new Customer();
        customer.setCustName("迪丽热巴");
        LinkMan linkMan = new LinkMan();
        linkMan.setLkmName("古力娜扎");
        linkMan.setCustomer(customer);
//        linkManDao.save(linkMan);
        customerDao.save(customer);
    }

    @Test
    @Transactional
    @Rollback(false)
    public void testCascadeRemove(){
        Customer customer = customerDao.findById(1L).get();
        System.out.println(customer);
        customerDao.delete(customer);
    }






}
