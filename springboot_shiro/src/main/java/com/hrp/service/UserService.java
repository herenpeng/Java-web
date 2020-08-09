package com.hrp.service;

import com.hrp.domain.User;
import com.hrp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * {{文件描述}}
 *
 * @author 何任鹏
 * @version 1.0
 * @date 2020年05月07日
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User findUserByName(String username) {
        User user = userRepository.findUserByUsername(username);
        return user;
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }
}
