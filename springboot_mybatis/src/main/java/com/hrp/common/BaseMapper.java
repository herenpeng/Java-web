package com.hrp.common;

import tk.mybatis.mapper.additional.idlist.IdListMapper;
import tk.mybatis.mapper.additional.insert.InsertListMapper;
import tk.mybatis.mapper.annotation.RegisterMapper;
import tk.mybatis.mapper.common.Mapper;

/**
 * 这是我们自己写的通用类，本质就是一个工具类，T为实体泛型，D为实体主键泛型
 * @author hrp
 * 2020/2/22 15:34
 */
@RegisterMapper
public interface BaseMapper<T,D> extends Mapper<T>, IdListMapper<T,D>, InsertListMapper<T> {
}
