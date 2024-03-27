/**
 *DB接続を管理するためのクラス
 */

package com.sample.message.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
	private static DBManager instance; // インスタンス

	//データベース接続先
	private static final String url = "jdbc:mysql://localhost:3306/senbonnock";
	//ユーザ名
	private static final String user = "root";
	//パスワード名
	private static final String password = "password";

	//データベースの接続
	public static Connection getConnection() throws SQLException {
		Connection con = null;
		
		try {
//			 #lass.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			System.out.println("DBへ接続成功！");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ここでエラー！");
//			throw e;
		}
		return con;
	}

	public static DBManager getInstance() {

		if (instance == null) {
			instance = new DBManager(); // インスタンスが存在しない場合、新しいインスタンスを作成
		}
		return instance; // 既存のインスタンスを返す
	}

	public void close(Connection con) throws SQLException {
	        if (con != null) {
	            try {
	                con.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	                // エラーハンドリング
	            }
	        }

	}
}
