package com.hrp.config;


import com.hrp.domain.User;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * 密码加密工具类
 *
 * @author 何任鹏
 * @version 1.0
 * @date 2020年05月07日
 */
public class PasswordHelper {
    private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
    // 基础散列算法
    public static final String ALGORITHM_NAME = "md5";
    // 自定义散列次数
    public static final int HASH_ITERATIONS = 2;

    public void encryptPassword(User user) {
        // 随机字符串作为salt因子，实际参与运算的salt我们还引入其它干扰因子
        user.setSalt(randomNumberGenerator.nextBytes().toHex());
        String newPassword = new SimpleHash(ALGORITHM_NAME, user.getPassword(),
                ByteSource.Util.bytes(user.getCredentialsSalt()), HASH_ITERATIONS).toHex();
        user.setPassword(newPassword);
    }
}