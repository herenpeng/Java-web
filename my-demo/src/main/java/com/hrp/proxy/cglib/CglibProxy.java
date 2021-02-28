package com.hrp.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author hrp
 * 2020/3/12 16:44
 */
public class CglibProxy implements MethodInterceptor {

    private Object target;

    public CglibProxy(Object target){
        this.target = target;
    }

    public Object createProxy() {
//      创建Cglib的核心类对象
        Enhancer enhancer = new Enhancer();
//		设置父类
        enhancer.setSuperclass(target.getClass());
//		设置回调:(类似于InvocationHandler)
        enhancer.setCallback(this);
//		创建代理对象
        Object proxy = enhancer.create();
        return proxy;
    }

    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("Cglib动态代理前置通知......");
        Object object = method.invoke(target, args);
        System.out.println("Cglib动态代理后置通知......");
        return object;
    }
}
