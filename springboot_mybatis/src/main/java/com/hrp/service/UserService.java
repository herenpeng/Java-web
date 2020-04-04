package com.hrp.service;

import com.hrp.domain.User;

import java.util.List;

/**
 * @author hrp
 * 2020/2/22 14:44
 */
public interface UserService {

    /**
     * 查找所有用户信息
     * @return
     */
    List<User> findAll();
}
