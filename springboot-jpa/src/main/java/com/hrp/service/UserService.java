package com.hrp.service;

import com.hrp.domain.User;
import org.springframework.data.domain.Page;

/**
 * @author hrp
 * 2020/2/23 10:01
 */
public interface UserService {

    /**
     * 分页查询用户数据
     * @param pageNum
     * @param pageSize
     * @return
     */
    Page<User> findByPage(Integer pageNum, Integer pageSize);

}
