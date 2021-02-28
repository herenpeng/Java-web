package com.hrp.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hrp.domain.User;

import java.util.List;

/**
 * User类的业务层接口
 *
 * @author hrp
 * 2020/2/20 20:35
 */
public interface UserService {

    /**
     * 分页查找所有的用户
     *
     * @param currentPage
     * @param size
     * @return
     * @throws Exception
     */
    IPage<User> findByPage(Integer currentPage, Integer size) throws Exception;

    /**
     * 获取所有的用户信息
     *
     * @return
     * @throws Exception
     */
    List<User> findList() throws Exception;

    /**
     * 通过用户id查找用户
     *
     * @param id
     * @return
     * @throws Exception
     */
    User findById(Integer id) throws Exception;

    /**
     * 保存一个用户
     *
     * @param user
     * @throws Exception
     */
    void insertUser(User user) throws Exception;

    /**
     * 更新用户信息
     *
     * @param user
     * @throws Exception
     */
    void updateUser(User user) throws Exception;
}
