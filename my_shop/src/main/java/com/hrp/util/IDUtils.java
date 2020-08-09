package com.hrp.util;

import java.util.UUID;

/**
 * @author hrp
 * 2020/2/24 11:44
 */
public class IDUtils {

    /**
     * 唯一ID生成器，可以生成唯一ID
     *
     * @return 唯一ID
     */
    public static String generateUniqueId() {
        return UUID.randomUUID().toString() + System.currentTimeMillis();
    }
}
