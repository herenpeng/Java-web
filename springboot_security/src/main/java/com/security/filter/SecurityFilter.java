package com.security.filter;

import com.security.dao.MenuDao;
import com.security.domain.Menu;
import com.security.domain.Role;
import lombok.SneakyThrows;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

/**
 * @author 何任鹏
 * 2020/7/25 18:31
 */
@Component
public class SecurityFilter implements FilterInvocationSecurityMetadataSource {

    private MenuDao menuDao;

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        //这里需要强转称FilterInvocation的原因是因为要获取请求的url。
        String requestUrl = ((FilterInvocation) object).getRequestUrl();
//        System.out.println(requestUrl);
//        List<Menu> menus = menuDao.selectList();
//        for (Menu menu : menus) {
//            if (pathMatcher.match(menu.getPattern(),requestUrl)) {
//                List<Role> roles = menu.getRoles();
//                String[] rolesStr = new String[roles.size()];
//                for (int i = 0; i < roles.size(); i++) {
//                    rolesStr[i] = roles.get(i).getName();
//                }
//                //传递的是需要的角色数组
//                return SecurityConfig.createList(rolesStr);
//            }
//        }
        if("/login".equals(requestUrl) || "/doLogin".equals(requestUrl) || "/index".equals(requestUrl)) {
            return SecurityConfig.createList("ROLE_default");
        }
        return SecurityConfig.createList("ROLE_admin");
    }



    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
