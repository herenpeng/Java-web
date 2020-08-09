package com.hrp.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hrp.dao.UserDao;
import com.hrp.domain.User;
import com.hrp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author hrp
 * 2020/3/20 15:23
 */
@Service
@Transactional(rollbackFor = {Exception.class})
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public IPage<User> selectPage(Integer currentPage, Integer size) throws Exception{
        IPage<User> page = new Page<>(currentPage,size);
        return userDao.selectPage(page,null);
    }

    @Override
    public void deleteById(Integer id) throws Exception {
        userDao.deleteById(id);
    }

    @Override
    public void insert(User user) throws Exception {
        userDao.insert(user);
    }

    @Override
    public void update(User user) throws Exception {
        userDao.updateById(user);
    }
}
