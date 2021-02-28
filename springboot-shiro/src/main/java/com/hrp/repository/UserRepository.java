package com.hrp.repository;

import com.hrp.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * User持久层接口
 *
 * @author 何任鹏
 * @version 1.0
 * @date 2020年05月07日
 */
public interface UserRepository extends JpaRepository<User,Long>, JpaSpecificationExecutor<User> {

    /**
     * 通过用户名来查找用户信息
     * @param username
     * @return
     */
    User findUserByUsername(String username);
}
