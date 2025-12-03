package com.example.strategy;

import com.example.dao.UserDao;
import com.example.model.User;

public class DatabaseAuthentication implements AuthenticationStrategy{
	
	
	private final UserDao userDao;
	
	public DatabaseAuthentication(UserDao userDao) {
		this.userDao = userDao;
	}
	
	

	@Override
	public boolean AuthenticationCheck(String mailAddress, String password) {
		if (mailAddress == null || password == null) {
	        return false;
	    }
	    
	    User user = userDao.findUserName(mailAddress);
	    
	    // ユーザーが存在しない、またはDBのパスワードと一致しない場合は false
	    if (user == null) {
	        return false;
	    }
	    
	    // パスワードの比較のみに焦点を絞る
	    String storedPassword = user.getUserPassword();
	    
	    // 【修正後】比較結果をそのまま返す
	    return password.equals(storedPassword);
	}

}
