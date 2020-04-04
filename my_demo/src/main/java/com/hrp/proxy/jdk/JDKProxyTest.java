package com.hrp.proxy.jdk;

/**
 * @author hrp
 * 2020/3/12 16:57
 */
public class JDKProxyTest {
    public static void main(String[] args) {
        UserDao userDao = new UserDaoImpl();
        UserDao proxy = (UserDao) new JDKProxy(userDao).createProxy();
        proxy.save();
        proxy.update();
        proxy.find();
        proxy.delete();
    }
}
