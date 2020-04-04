package com.hrp.enums;

import lombok.AllArgsConstructor;

/**
 * @author hrp
 * 2020/3/22 21:00
 */
@AllArgsConstructor
public enum  ExceptionEnum {
    /**
     * 代码错误异常
     */
    CODE_ERROR(500,"代码错误"),
    REQUEST_ERROR(400,"请求错误"),
    ;

    private Integer statusCode;
    private String message;
}
