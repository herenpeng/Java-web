package com.security.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.security.dao.MenuDao;
import com.security.domain.Menu;
import com.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

/**
 * @author hrp
 * 2020/3/26 15:12
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true,securedEnabled=true,jsr250Enabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Autowired
    private MenuDao menuDao;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        List<Menu> menus = menuDao.getAllMenus();

        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry authorizeRequests = http.authorizeRequests();

        menus.stream().forEach(menu->{
            authorizeRequests.antMatchers(menu.getPattern()).hasAnyRole(menu.getName());
        });

        //其余所有请求都需要登录后认证才能访问能访问
        authorizeRequests.anyRequest().authenticated();

        http.formLogin()
                //定义一个URI，未登录时，访问一个需要登录之后才能访问的接口，会自动跳转到处理方法上
                .loginPage("/login")
                //定义登录请求的表单提交处理接口，Security默认帮我们实现了
                .loginProcessingUrl("/doLogin")
                //定义登录成功的时候，访问index请求
                .defaultSuccessUrl("/index")
                //登录失败请求login请求
                .failureForwardUrl("/login")
                //和表单登录相关的接口统统都直接通过,不进行拦截
                .permitAll()
                // 登录成功的处理器
//                .successHandler(new AuthenticationSuccessHandler() {
//                    @Override
//                    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
//                        response.setContentType("application/json;charset=utf-8");
//                        PrintWriter writer = response.getWriter();
//                        HashMap<Object, Object> map = new HashMap<>();
//                        map.put("status", 200);
//                        map.put("msg", authentication.getPrincipal());
//                        writer.write(new ObjectMapper().writeValueAsString(map));
//                        writer.flush();
//                        writer.close();
//                    }
//                })
                 //登录失败的处理器
                .failureHandler(new AuthenticationFailureHandler() {
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
                        response.setContentType("application/json;charset=utf-8");
                        PrintWriter writer = response.getWriter();
                        HashMap<Object, Object> map = new HashMap<>(16);
                        map.put("status", 401);
                        if (e instanceof LockedException) {
                            map.put("msg", "账号被锁定，登录失败");
                        } else if (e instanceof BadCredentialsException) {
                            map.put("msg", "用户名或密码错误，登录失败");
                        } else if (e instanceof DisabledException) {
                            map.put("msg", "账号被禁用，登录失败");
                        } else if (e instanceof CredentialsExpiredException) {
                            map.put("msg", "密码过期，登录失败");
                        } else if (e instanceof AccountExpiredException) {
                            map.put("msg", "账号过期，登录失败");
                        } else {
                            map.put("msg", "登录失败");
                        }
                        writer.write(new ObjectMapper().writeValueAsString(map));
                        writer.flush();
                        writer.close();
                    }
                });

        http.logout().logoutUrl("doLogout")
                .logoutSuccessUrl("/login").permitAll();

        // 关闭CSRF防御，方便用postman进行接口测试
        http.csrf().disable();
    }
}
