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
		
		loadDriver();
		User user = null;
		
        String SQL_SELECT_LOGIN = "SELECT USER_NAME,MAIL_ADDRESS,USER_PASSWORD FROM users where MAIL_ADDRESS = ?";
        try (Connection conn = getConnection(); 
                PreparedStatement ps = conn.prepareStatement(SQL_SELECT_LOGIN))	{
			    ps.setString(1,mailAddress);
			    
			    try (ResultSet rs = ps.executeQuery()) {
		            
		            // ?に値を入れたい：ここで結果セットからデータを取り出してUserオブジェクトを作成します
		            // ユーザーが見つかった場合
		            if (rs.next()) {
		                user = new User();
		                // ResultSetからUSER_NAME列とUSER_PASSWORD列の値を取得し、Userオブジェクトに設定
		                user.setUserName(rs.getString("USER_NAME"));
		                user.setMailAddress(rs.getString("MAIL_ADDRESS")); 
		                user.setUserPassword(rs.getString("USER_PASSWORD"));
		            }
		        }
		   	
		}catch (SQLException e){
			System.err.println("SQL Error finding user: " + e.getMessage());
		}
		
		return user;
	}
	
	
	public List<UserDto> doSelect() {
        List<UserDto> answerList = new ArrayList<>();
        String SQL_SELECT_LOGIN = "SELECT MAIL_ADDRESS,USER_PASSWORD FROM users";
        try (Connection conn = DriverManager.getConnection(JDBC_URL, USER_ID, USER_PASS);
             PreparedStatement pstmt = conn.prepareStatement(SQL_SELECT_LOGIN);
             ResultSet rs = pstmt.executeQuery()) {
             
            // 結果セットをAnswerオブジェクトに詰め替える
        	// ResultSet rs から値をDTOにセットする部分
        	while (rs.next()) {
        	    UserDto answer = new UserDto();
        	    
        	    // 1. UserName: String型
        	    answer.setUserName(rs.getString("userName"));
        	    
        	    // 2. UserPassword: String型
        	    answer.setUserPassword(rs.getString("userPassword"));
        	     
        	    
        	    answerList.add(answer);
        	}
        } catch (SQLException e) {
            e.printStackTrace();
            // 実際には例外をスローするなど、より丁寧なエラー処理が必要
        }
        return answerList;
    }


}
