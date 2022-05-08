package com.ytt.shiro.service.realm;

import com.ytt.shiro.service.SecurityService;
import com.ytt.shiro.service.impl.SecurityServiceImpl;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.StringUtils;

public class DefinationRealm extends AuthorizingRealm {
    /**
     * @Description 鉴权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * @Description 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //从AuthenticationToken中获取登录名称
        String loginName = (String) authenticationToken.getPrincipal();
        SecurityService securityService = new SecurityServiceImpl();
        String password = securityService.findPasswordByLoginName(loginName);
        if(!StringUtils.hasText(password)){
            throw new UnknownAccountException("账户不存在");
        }

        //传递账号和密码
        return new SimpleAuthenticationInfo(loginName,password,getName());
    }
}
