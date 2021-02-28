package com.hrp.test;

import com.hrp.enums.ExceptionEnum;
import com.hrp.exception.MyException;
import org.junit.Test;

/**
 * @author hrp
 * 2020/3/22 20:56
 */
public class ExceptionTest {

    @Test
    public void test() throws MyException {
        throw new MyException(ExceptionEnum.REQUEST_ERROR);
    }

}
