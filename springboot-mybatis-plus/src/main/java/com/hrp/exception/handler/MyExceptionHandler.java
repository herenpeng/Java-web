package com.hrp.exception.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理类
 * @author herenpeng
 * @since 2020-09-13 15:45
 */
@ControllerAdvice(value = {"com.hrp"})
public class MyExceptionHandler {


    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ResponseEntity exceptionHandler(HttpServletRequest request, Exception e) {
        e.printStackTrace();
        return null;
    }


}
