package com.example.service;

import com.example.strategy.AuthenticationStrategy;

public class AuthService {

private final AuthenticationStrategy authenticationStrategy;
    
    // コンストラクタで認証戦略を受け取る
    public AuthService(AuthenticationStrategy strategy) {
        this.authenticationStrategy = strategy;
    }
    
    /**
     * 認証戦略を使用して認証を実行します。
     */
    public boolean login(String username, String password) {
        return authenticationStrategy.AuthenticationCheck(username, password);
    }
}
