package com.jwt.test;

import java.util.UUID;

/**
 * @description: Jwt常量类
 * @author: 何任鹏
 * @create: 2020/8/9 19:29
 */
public class Constant {

    public static final String JWT_ID = UUID.randomUUID().toString();

    /**
     * 加密密文
     */
    public static final String JWT_SECRET = "woyebuzhidaoxiediansha";
    public static final int JWT_TTL = 60*60*1000;  //millisecond
}
