package com.security.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.security.domain.UserRole;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

/**
 * @author hrp
 * 2020/3/26 21:18
 */
public interface UserRoleDao extends BaseMapper<UserRole> {

    /**
     * 维护用户的角色关系
     * @param uid
     * @param rid
     */
    @Insert("insert into user_role(uid,rid) values(#{uid},#{rid})")
    void saveUserRole(@Param("uid") Integer uid, @Param("rid") Integer rid);
}
