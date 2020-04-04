package com.hrp.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author hrp
 * @date 2020/2/7 10:46
 */
public class JpaUtils {

    private static EntityManagerFactory factory;

    static {
        //1、加载配置文件创建工厂，（实体管理器工厂）对象
        factory = Persistence.createEntityManagerFactory("myJpa");
    }

    /**
     * //2、通过实体管理器工厂，获取实体管理器
     * @return
     */
    public static EntityManager getEntityManager() {
        return factory.createEntityManager();
    }

}
