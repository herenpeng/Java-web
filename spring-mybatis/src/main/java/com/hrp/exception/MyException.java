package com.hrp.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;

/**
 * @author hrp
 */

@ControllerAdvice
public class MyException{
    /**
     * 该注解的值为需要处理的异常类型的字节码对象数组
     * @param request 固定参数HttpServletRequest，不写会报错
     * @param ex 固定参数Exception，不写会报错
     * @return 自定义，可以是String，也可以是ModelAndView
     */
    @ExceptionHandler({RuntimeException.class, FileNotFoundException.class})
    public String myException(HttpServletRequest request, Exception ex) {
        request.setAttribute("message",ex.getMessage());
        return "error";
    }
}
