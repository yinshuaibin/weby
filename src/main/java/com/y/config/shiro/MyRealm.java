package com.y.config.shiro;


import com.y.bean.Authc;
import com.y.bean.Role;
import com.y.bean.User;
import com.y.service.UserService;
import com.y.utils.Md5Utils;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;


@Slf4j
public class MyRealm extends AuthorizingRealm {

	@Autowired
	private UserService userService;

	// 授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		log.info("调用授权");
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		// 根据当前登录用户,查询对应角色和权限
		Subject subject = SecurityUtils.getSubject();
		User user = (User) subject.getPrincipal();
        for(Role role :user.getRoles()){
            authorizationInfo.addRole(role.getRoleName());
            for(Authc authc:role.getAuthcs()){
                authorizationInfo.addStringPermission(authc.getAuthcName());
            }
        }
		return authorizationInfo;
	}

	// 登录,认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        log.info("登录验证");
	    UsernamePasswordToken userToken = (UsernamePasswordToken) token;
		User user = userService.getUserByUserName(userToken.getUsername());
		if(user == null){
		    return  null;
        }
		return new SimpleAuthenticationInfo(
		        user,
                user.getPassword(),
                ByteSource.Util.bytes(Md5Utils.salt),//盐一般为username+salt 但此处直接使用
                this.getClass().getName()// real name
        );
	}
}
