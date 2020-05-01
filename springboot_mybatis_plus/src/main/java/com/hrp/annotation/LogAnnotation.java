package com.hrp.annotation;

import java.lang.annotation.*;

/**
 * @author hrp
 * 2020/4/16 22:23
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogAnnotation {
}
