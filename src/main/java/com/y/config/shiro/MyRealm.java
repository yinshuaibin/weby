package com.y.config.shiro;


import com.y.bean.Authc;
import com.y.bean.Role;
import com.y.bean.User;
import com.y.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;


public class MyRealm extends AuthorizingRealm {

	@Autowired
	private UserService userService;

	private String salt = "666666";

	// 授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		System.out.println("调用授权----");
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
        System.out.println("登录验证");
	    UsernamePasswordToken userToken = (UsernamePasswordToken) token;
		User user = userService.getUserByUserName(userToken.getUsername());
		if(user == null){
		    return  null;
        }
		return new SimpleAuthenticationInfo(
		        user,
                user.getPassWord(),
                ByteSource.Util.bytes(user.getUserName()+salt),//username+password
                this.getClass().getName()// real name
        );
	}
}
