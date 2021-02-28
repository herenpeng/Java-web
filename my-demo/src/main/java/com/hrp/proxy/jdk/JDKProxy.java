package com.hrp.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author hrp
 * 2020/3/12 16:37
 */
public class JDKProxy implements InvocationHandler {

    private Object target;

    public JDKProxy(Object target){
        this.target = target;
    }

    public Object createProxy() {
        Object proxy = Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), this);
        return proxy;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("JDK动态代理前置通知......");
        Object object = method.invoke(target, args);
        System.out.println("JDK动态代理后置通知......");
        return object;
    }
}
