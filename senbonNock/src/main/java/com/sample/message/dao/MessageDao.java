/**
 * 掲示板メッセージのDBアクセス用クラス
 */

package com.sample.message.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MessageDao {

	//データベース接続
	private Connection con;

	//コンストラクタ
	public MessageDao(Connection con) {
		this.con = con;
	}

	//格納したメッセージを全て取得
	public List<MessageEntity> getMessageList(Connection con) throws SQLException {

		String sql = "SELECT * FROM MESSAGE";
		System.out.println("格納したメッセージを取得するSQL実行されたよ");
		PreparedStatement stmt = null;
		ResultSet res = null;
		List<MessageEntity> messages = new ArrayList<>();

		try {
			stmt = con.prepareStatement(sql);
			res = stmt.executeQuery();

			while (res.next()) {
				MessageEntity message = new MessageEntity();
				message.setTitle(res.getString("TITLE"));
				message.setContent(res.getString("CONTENT"));
				message.setRegisterDate(res.getTimestamp("REGISTERDATE"));
				messages.add(message);
				System.out.println("データ取得したよ");
				//						res.getString("TITLE"),
				//						res.getString("CONTENT"),
				//						res.getTimestamp("REGISTERDATE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("ここ");
			throw e;
			
			// エラーハンドリング
		} finally {
			if (res != null) {
				res.close();
			}
			if (stmt != null) {
				stmt.close();
			}
		}
		return messages;
	}

	//メッセージ登録
	public void register(Connection con, MessageEntity entity) throws SQLException {

		String sql = "INSERT INTO MESSAGE VALUES(default,?,?,CURRENT_TIME)";
		System.out.println("格納したメッセージを登録するSQL実行されたよ!");
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, entity.getTitle());
		stmt.setString(2, entity.getContent());
		//stmt.setTimestamp(3, entity.getRegisterDate() );
		
		System.out.println(stmt);
		
		//SQL文の実行
		int res = stmt.executeUpdate();
		//stmt.setRegisterDate(res.getTimestamp("REGISTERDATE"));

		//		try {
		//			stmt = con.prepareStatement(sql);
		//			ResultSet res = stmt.executeQuery();

		//			if (res.next()) {
		//				messsage = new Message(
		//						res.getString("TITLE"),
		//						res.getString("CONTENT"),
		//						res.getTimestamp("REGISTERDATE"));
		//			}
		//		} catch (SQLException e) {
		//            e.printStackTrace();
		//            throw e;
		//            // エラーハンドリング
		//		}finally {
		//			if (res != null) {
		//				res.close();
		//			}
		//			if (stmt != null) {
		//				stmt.close();
		//			}
		//		}
		//		return message;
	}

	//SQL実行オブジェクト生成
	//PreparedStatement stmt = con.prepareStatement(sql);
	//SQL実行
	//ResultSet rs = stmt.executeQuery();
	//SQL実行結果からデータを取得
	//List<MessageEntity> list = new ArrayList<>();

	//		//メッセージ検索
	//		public ArrayList<MessageEntity> findAllItem() throws SQLException {
	//			ArrayList<MessageEntity> proList = new ArrayList<>();
	//			String sql = "SELECT * FROM message";
	//			PreparedStatement stmt = null;
	//			ResultSet res = null;
	//			
	//			return proList;
	//
	//		}

}
