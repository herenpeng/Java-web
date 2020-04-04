package com.hrp.service;

import com.hrp.domain.User;

import java.util.List;

/**
 * @author hrp
 */
public interface UserService {

    /**
     * 查找所有用户
     * @return
     * @throws Exception
     */
    List<User> findAll() throws Exception;

    /**
     * 根据id删除用户
     * @param id
     * @throws Exception
     */
    void deleteUser(Integer id) throws Exception;


    /**
     * 保存用户
     * @param user
     * @throws Exception
     */
    void save(User user) throws Exception;
}
