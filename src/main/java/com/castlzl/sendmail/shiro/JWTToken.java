package com.castlzl.sendmail.shiro;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author leiziliang
 * @version 1.0
 * @date 2020/3/12 20:38
 */
public class JWTToken implements AuthenticationToken {

    private String token;

    public JWTToken(String token) {
        this.token = token;
    }


    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
