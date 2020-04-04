package com.hrp.test;

import com.hrp.domain.Customer;
import com.hrp.util.JpaUtils;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * @author hrp
 * @date 2020/2/6 23:43
 */
public class JpaTest {

    @Test
    public void testSave() {
        EntityManager em = JpaUtils.getEntityManager();
        //3、获取事务对象,开启事务
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        //4、完成增删改查操作
        Customer customer = new Customer();
        customer.setCustName("曾桦涛");
        customer.setCustIndustry("学校");
        //保存
        em.persist(customer);
        //5、提交事务或者回滚事务
        transaction.commit();
        //6、释放资源
        em.close();
//        factory.close();
    }

    /**
     * 立即查询
     */
    @Test
    public void testFind(){
        EntityManager em = JpaUtils.getEntityManager();
        //3、获取事务对象,开启事务
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        //4、完成增删改查操作
        Customer customer = em.find(Customer.class, 1L);
        //保存
        System.out.println(customer);
        //5、提交事务或者回滚事务
        transaction.commit();
        //6、释放资源
        em.close();
    }

    /**
     * 延迟加载（懒加载）,得到的是代理对象。
     */
    @Test
    public void testGet(){
        EntityManager em = JpaUtils.getEntityManager();
        //3、获取事务对象,开启事务
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        //4、完成增删改查操作
        Customer customer = em.getReference(Customer.class,2L);
        System.out.println(customer);
        //5、提交事务或者回滚事务
        transaction.commit();
        //6、释放资源
        em.close();
    }

    /**
     * 删除操作
     */
    @Test
    public void testRemove(){
        EntityManager em = JpaUtils.getEntityManager();
        //3、获取事务对象,开启事务
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        //4、完成增删改查操作
        Customer customer = em.find(Customer.class, 1L);
        em.remove(customer);
        //5、提交事务或者回滚事务
        transaction.commit();
        //6、释放资源
        em.close();
    }

    /**
     * 更新
     */
    @Test
    public void testUpdate(){
        EntityManager em = JpaUtils.getEntityManager();
        //3、获取事务对象,开启事务
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        //4、完成增删改查操作
        Customer customer = em.find(Customer.class, 2L);
        customer.setCustName("刘亦菲");
        em.merge(customer);
        //5、提交事务或者回滚事务
        transaction.commit();
        //6、释放资源
        em.close();
    }

}
