package com.hrp.dao;

import com.hrp.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author hrp
 * @date 2020/2/7 22:31
 */
public interface UserDao extends JpaRepository<User,Long>, JpaSpecificationExecutor<User> {
}
