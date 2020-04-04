package com.security.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.security.domain.Menu;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author hrp
 * 2020/3/27 11:41
 */
public interface MenuDao extends BaseMapper<Menu> {


    /**
     * 获取所有权限
     * @return
     * @throws Exception
     */
    @Select("select m.id,m.pattern,r.name,r.description from menu m left join role_menu rm on m.id = rm.mid left join role r on r.id = rm.rid")
    List<Menu> getAllMenus() throws Exception;

}
