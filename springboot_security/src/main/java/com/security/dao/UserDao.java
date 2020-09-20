package com.security.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.security.domain.Role;
import com.security.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author hrp
 * 2020/3/26 19:12
 */
public interface UserDao extends BaseMapper<User> {

    /**
     * 通过用户名查找用户
     * @param username
     * @return
     */
    @Select("select * from user where username = #{username}")
    User loadUserByUsername(String username);

    /**
     * 通过用户id查找用户的所有角色
     * @param uid
     * @return
     */
    @Select("select * from role where id in (select rid from user_role where uid=#{uid})")
    List<Role> loadUserRolesById(Integer uid);

    /**
     * 查找一个
     * @param id
     * @return
     */
    User getOne(@Param("id") Integer id);

}
