package com.hrp.exception;

import com.hrp.enums.ExceptionEnum;
import lombok.*;

/**
 * @author hrp
 * 2020/3/22 20:53
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyException extends Exception {
    private ExceptionEnum exceptionEnum;
}
