package com.unknow.realm;

import com.unknow.entity.User;
import com.unknow.mapper.UserMapper;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by hotman on 16/7/18.
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserMapper userMapper;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        User user =  userMapper.selectPassAndStatus(username);

        if (user == null) {
            throw new UnknownAccountException();
        }

        if (user.getStatus() == 0 ){
            throw new LockedAccountException();
        }

        return new SimpleAuthenticationInfo(username,user.getLoginPassword(),getName());

    }
}
