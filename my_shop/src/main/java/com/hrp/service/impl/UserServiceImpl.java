package com.hrp.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hrp.domain.User;
import com.hrp.mapper.UserMapper;
import com.hrp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User类的业务层实现
 * @author hrp
 * 2020/2/20 20:36
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public IPage<User> findByPage(Integer currentPage, Integer size) throws Exception {
        IPage<User> page = new Page<>(currentPage,size);
        return userMapper.selectPage(page,null);
    }


    @Override
    public User findById(Integer id) throws Exception  {
        return userMapper.selectById(id);
    }

    @Override
    public void insertUser(User user) throws Exception {
        userMapper.insert(user);
    }

    @Override
    public void updateUser(User user) throws Exception{
        userMapper.updateById(user);
    }

}
