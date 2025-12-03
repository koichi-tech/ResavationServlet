package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BaseDao {

		//-------------------------------------------
		//データベースへの接続情報
		//-------------------------------------------

		//JDBCドライバの相対パス
		//※バージョンによって変わる可能性があります（MySQL5系の場合は「com.mysql.jdbc.Driver」）
		protected final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";

		//接続先のデータベース
		//※データベース名が「test_db」でない場合は該当の箇所を変更してください
		protected final String JDBC_URL    = "jdbc:mysql://localhost/hino_db?characterEncoding=UTF-8&serverTimezone=Asia/Tokyo&useSSL=false";

		//接続するユーザー名
		//※ユーザー名が「test_user」でない場合は該当の箇所を変更してください
		protected final String USER_ID     = "koichi";

		//接続するユーザーのパスワード
		//※パスワードが「test_pass」でない場合は該当の箇所を変更してください
		protected final String USER_PASS   = "testadd12345";
		
		
		public void loadDriver() {
			//-------------------------------------------
			//JDBCドライバのロード
			//-------------------------------------------
			try {
				Class.forName(DRIVER_NAME);       //JDBCドライバをロード＆接続先として指定
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		

		public Connection getConnection() throws SQLException {
			
			return DriverManager.getConnection(JDBC_URL, USER_ID, USER_PASS);
			
		}
		
		
		public void closeConnection(Connection conn) {
			
			if(conn != null) {
				try {
					conn.close();
				}catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	


}
