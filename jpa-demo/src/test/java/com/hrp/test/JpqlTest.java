package com.hrp.test;

import com.hrp.util.JpaUtils;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

/**
 * @author hrp
 * @date 2020/2/7 11:04
 */
public class JpqlTest {

    /**
     * 查询所有
     */
    @Test
    public void testFinAll(){
        EntityManager em = JpaUtils.getEntityManager();
        //3、获取事务对象,开启事务
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        //4、完成增删改查操作
        String jpal = "from Customer";
        Query query = em.createQuery(jpal);
        List list = query.getResultList();
        for (Object obj : list) {
            System.out.println(obj);
        }
        //5、提交事务或者回滚事务
        transaction.commit();
        //6、释放资源
        em.close();
    }

    /**
     * 倒序
     */
    @Test
    public void testOrder(){
        EntityManager em = JpaUtils.getEntityManager();
        //3、获取事务对象,开启事务
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        //4、完成增删改查操作
        String jpal = "from Customer order by custId desc";
        Query query = em.createQuery(jpal);
        List list = query.getResultList();
        for (Object obj : list) {
            System.out.println(obj);
        }
        //5、提交事务或者回滚事务
        transaction.commit();
        //6、释放资源
        em.close();
    }

    /**
     * 统计
     */
    @Test
    public void testCount(){
        EntityManager em = JpaUtils.getEntityManager();
        //3、获取事务对象,开启事务
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        //4、完成增删改查操作
        String jpal = "select count(custId) from Customer";
        Query query = em.createQuery(jpal);
        Object result = query.getSingleResult();
        System.out.println(result);
        //5、提交事务或者回滚事务
        transaction.commit();
        //6、释放资源
        em.close();
    }

    /**
     * 分页查询
     */
    @Test
    public void testPaged(){
        EntityManager em = JpaUtils.getEntityManager();
        //3、获取事务对象,开启事务
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        //4、完成增删改查操作
        String jpal = "from Customer";
        Query query = em.createQuery(jpal);
        query.setFirstResult(0);//从0开始查，不包含0
        query.setMaxResults(1);//每页最大结果数
        List list = query.getResultList();
        for (Object obj : list) {
            System.out.println(obj);
        }
        //5、提交事务或者回滚事务
        transaction.commit();
        //6、释放资源
        em.close();
    }

    /**
     * 条件查询
     */
    @Test
    public void testCondition(){
        EntityManager em = JpaUtils.getEntityManager();
        //3、获取事务对象,开启事务
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        //4、完成增删改查操作
        String jpal = "from Customer where custName like ?";
        Query query = em.createQuery(jpal);
        query.setParameter(1,"刘%");
        List list = query.getResultList();
        for (Object obj : list) {
            System.out.println(obj);
        }
        //5、提交事务或者回滚事务
        transaction.commit();
        //6、释放资源
        em.close();
    }

}
