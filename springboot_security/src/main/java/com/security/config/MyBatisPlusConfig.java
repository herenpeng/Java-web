package com.security.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author hrp
 * 2020/3/26 20:46
 */
@Configuration
@MapperScan("com.security.dao")
public class MyBatisPlusConfig {
    /**
     * 分页插件的Java配置
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
