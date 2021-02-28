package com.hrp.proxy.cglib;

/**
 * @author hrp
 * 2020/3/12 17:00
 */
public class CglibProxyTest {
    public static void main(String[] args) {
        CustomerDao customerDao = new CustomerDao();
        CustomerDao proxy = (CustomerDao) new CglibProxy(customerDao).createProxy();
        proxy.save();
        proxy.update();
        proxy.find();
        proxy.delete();
    }
}
