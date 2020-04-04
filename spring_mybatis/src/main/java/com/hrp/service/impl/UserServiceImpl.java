package com.hrp.service.impl;

import com.hrp.dao.UserDao;
import com.hrp.domain.User;
import com.hrp.service.UserService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

/**
 * @author hrp
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findAll() throws Exception {
        return userDao.findAll();
    }

    @Override
    public void deleteUser(Integer id) throws Exception {
        userDao.deleteUser(id);
        int i = 1/0;
    }

    @Override
    public void save(User user) throws Exception {
        userDao.saveUser(user);
    }

}
