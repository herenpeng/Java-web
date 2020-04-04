package com.hrp.dao;

import com.hrp.domain.User;

import java.util.List;

/**
 * @author hrp
 */
public interface UserDao {

    /**
     * 查询所有用户
     * @return
     */
    List<User> findAll();
}