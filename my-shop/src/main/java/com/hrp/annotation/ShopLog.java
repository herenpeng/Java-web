package com.hrp.annotation;

import java.lang.annotation.*;

/**
 * 日志注解，被该注解标识的controller接口将会被AOP记录日志
 *
 * @author hrp
 * 2020/4/16 22:23
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ShopLog {
}
