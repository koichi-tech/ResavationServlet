package com.example.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class AbstractDao extends BaseDao{

	
	// INSERT用：SQL文を子クラスで定義するために抽象メソッドとする
    protected abstract String getInsertSql();
    
    // INSERT用：PreparedStatementのパラメータ設定ロジックを子クラスで定義する
    protected abstract void setInsertParameters(PreparedStatement ps, Object dto) throws SQLException;
    
    // SELECT用：SQL文を子クラスで定義するために抽象メソッドとする
    protected abstract String getSelectAllSql();
    
    // SELECT用：ResultSetの結果を子クラスのDTOにマッピングするロジックを定義する
    // 戻り値はList<Object>として、子クラスでキャストする
    protected abstract List<?> mapResultSetToList(ResultSet rs) throws SQLException;
    
    
	
	
	
}
