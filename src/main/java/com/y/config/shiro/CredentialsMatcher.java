package com.y.config.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * 自定义密码比较器
 */
public class CredentialsMatcher extends SimpleCredentialsMatcher {
    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        UsernamePasswordToken uToken = (UsernamePasswordToken) token;
        String inPassword = new String(uToken.getPassword());
        String dbPassword = (String) info.getCredentials();
        ByteSource salt =((SimpleAuthenticationInfo)info).getCredentialsSalt();
        SimpleHash simpleHash = new SimpleHash("MD5", inPassword,salt);
        return dbPassword.equals(simpleHash.toString());
    }
}
