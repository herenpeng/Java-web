package com.security.service;

import com.security.dao.UserDao;
import com.security.dao.UserRoleDao;
import com.security.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author hrp
 * 2020/3/26 21:06
 */
@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserRoleDao userRoleDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.loadUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户" + username + "不存在！");
        }
        user.setRoles(userDao.loadUserRolesById(user.getId()));
        return user;
    }



    @Transactional(rollbackFor = Exception.class)
    public void insertUser(User user) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.insert(user);
        user.getRoles().stream()
                .forEach(role->userRoleDao.saveUserRole(user.getId(),role.getId()));
    }


}
