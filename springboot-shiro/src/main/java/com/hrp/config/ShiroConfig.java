package com.hrp.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * {{文件描述}}
 *
 * @author 何任鹏
 * @version 1.0
 * @date 2020年05月07日
 */
@Configuration
public class ShiroConfig {
    @Bean
    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        Map<String, String> filterChainDefinitionMap = new HashMap<String, String>();
        //设置登录的URL，如果用户在没有登录的时候访问需要登录才能访问的API的时候，就会直接跳转到该URL下
        shiroFilterFactoryBean.setLoginUrl("/login");
        //访问未经授权的API时，会跳转到该URL下
        shiroFilterFactoryBean.setUnauthorizedUrl("/unauthc");
        //用户登录成功后跳转到该URL中
        shiroFilterFactoryBean.setSuccessUrl("/home/index");

        filterChainDefinitionMap.put("/*", "anon");
        filterChainDefinitionMap.put("/authc/index", "authc");
        filterChainDefinitionMap.put("/authc/admin", "roles[admin]");
        filterChainDefinitionMap.put("/authc/renewable", "perms[Create,Update]");
        filterChainDefinitionMap.put("/authc/removable", "perms[Delete]");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        // 散列算法
        hashedCredentialsMatcher.setHashAlgorithmName(PasswordHelper.ALGORITHM_NAME);
        // 散列次数
        hashedCredentialsMatcher.setHashIterations(PasswordHelper.HASH_ITERATIONS);
        return hashedCredentialsMatcher;
    }

    /**
     * 将自己实现的Realm添加到Spring容器中
     *
     * @return
     */
    @Bean
    public EnceladusShiroRealm shiroRealm() {
        EnceladusShiroRealm shiroRealm = new EnceladusShiroRealm();
        shiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return shiroRealm;
    }

    /**
     * 配置安全管理器
     *
     * @return
     */
    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(shiroRealm());
        return securityManager;
    }

    /**
     * 密码加密工具
     *
     * @return
     */
    @Bean
    public PasswordHelper passwordHelper() {
        return new PasswordHelper();
    }
}