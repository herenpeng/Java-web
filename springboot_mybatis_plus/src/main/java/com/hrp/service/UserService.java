package com.hrp.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hrp.domain.User;

/**
 * @author hrp
 * 2020/3/20 15:14
 */
public interface UserService {

    /**
     * 分页查找用户信息
     *
     * @param currentPage 当前页码
     * @param size        每页页码大小
     * @return
     * @throws Exception
     */
    IPage<User> selectPage(Integer currentPage, Integer size) throws Exception;

    /**
     * 通过用户id删除用户
     *
     * @param id
     * @throws Exception
     */
    void deleteById(Integer id) throws Exception;

    /**
     * 添加用户信息
     *
     * @param user
     * @throws Exception
     */
    void insert(User user) throws Exception;

    /**
     * 通过用户id修改用户信息
     *
     * @param user
     */
    void update(User user) throws Exception;


}
