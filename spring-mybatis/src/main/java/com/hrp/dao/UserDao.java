package com.hrp.dao;

import com.hrp.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author hrp
 */
public interface UserDao {

    /**
     * 查找所有用户
     * @return
     * @throws Exception
     */
    @Select("select * from tb_user")
    List<User> findAll() throws Exception;

    /**
     * 根据id删除用户
     * @param id
     * @throws Exception
     */
    @Delete("delete from tb_user where id = #{id}")
    void deleteUser(Integer id) throws Exception;

    /**
     * 保存用户
     * @param user
     * @throws Exception
     */
    @Insert("insert into tb_user(name,password) values(#{name},#{password})")
    void saveUser(User user) throws Exception;

}
