package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.dto.UserDto;
import com.example.model.User;
import com.example.strategy.AuthenticationStrategy;

public class UserDao extends BaseDao{
	
	private BaseDao basedao;
	public UserDao(BaseDao basedao) {
		this.basedao = basedao;
	}
	
	
	public User findUserName(String mailAddress) {
	    
	    // loadDriver() は削除
	    User user = null;
	    
	    String SQL_SELECT_LOGIN = "SELECT USER_NAME,MAIL_ADDRESS,USER_PASSWORD FROM t_user where MAIL_ADDRESS = ?";
	    
	    // this.basedao を使用して Connection を取得
	    try (Connection conn = this.basedao.getConnection(); 
	            PreparedStatement ps = conn.prepareStatement(SQL_SELECT_LOGIN))	{
	        
	        ps.setString(1,mailAddress);
	        
	        try (ResultSet rs = ps.executeQuery()) {
	            
	            if (rs.next()) {
	                user = new User();
	                user.setUserName(rs.getString("USER_NAME"));
	                user.setMailAddress(rs.getString("MAIL_ADDRESS")); 
	                user.setUserPassword(rs.getString("USER_PASSWORD"));
	            }
	        }
	           	
	    }catch (SQLException e){
	        // 開発環境では詳細なログ出力が有用
	        System.err.println("SQL Error finding user: " + e.getMessage());
	        // 本番環境ではより安全なログ記録と例外の再スローを検討
	    }
	    
	    return user;
	}


}
