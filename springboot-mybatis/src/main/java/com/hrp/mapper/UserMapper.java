package com.hrp.mapper;

import com.hrp.common.BaseMapper;
import com.hrp.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * 这里需要注意几个点，同样是导包问题
 *      第一：@Mapper注解的包是mybatis的
 *      第二：这里的BaseMapper是我们自己写的那个，不是tk.mybatis(通用Mapper)的
 * @author hrp
 * @date 2020/2/7 22:16
 */
@Mapper
public interface UserMapper extends BaseMapper<User,Integer> {
}
