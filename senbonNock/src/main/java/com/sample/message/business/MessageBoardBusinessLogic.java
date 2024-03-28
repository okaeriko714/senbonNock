/**
 *掲示板一覧画面での業務処理を担当するクラス
 * 
 */
package com.sample.message.business;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import com.sample.message.check.MessageBoardRegisterCheck;
import com.sample.message.common.DBManager;
import com.sample.message.dao.MessageDao;
import com.sample.message.dao.MessageEntity;

public class MessageBoardBusinessLogic {

	//メッセージを検索する
	public static List<MessageEntity> searchMessage() {
		Connection con = null;
		List<MessageEntity> messages = null;

		try {
			//データベースの接続を取得する
			con = DBManager.getConnection();

			//メッセージテーブルアクセス用のDAOを生成し、メソッドを呼び出す。
			MessageDao messageDao = new MessageDao(con);
			messages = messageDao.getMessageList(con);

			//検索結果がない場合、エラーを発生させる。
			//今回は発生させない

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return messages;

	}
	
	
	
	

	//メッセージを登録する bean削除した
	public static void registerMessage(String title,String content,Timestamp registerdate) {
		Connection con = null;
//		List<MessageEntity> messages = null;
		
		//入力チェック
		MessageBoardRegisterCheck.checkInputData(title, content);
		System.out.println("入力チェックまで何とかできたよ");
		
		//Timestamp registerdate = null;
		//タイトル　日付までを入れて、entityの作成★
		MessageEntity entity = new MessageEntity(title, content, registerdate); 
		
		try {
			//データベースの接続を取得する
			con = DBManager.getConnection();

			//メッセージテーブルアクセス用のDAOを生成し、メソッドを呼び出す。
			MessageDao messageDao = new MessageDao(con);
			messageDao.register(con, entity);

			//検索結果がない場合、エラーを発生させる。
			//今回は発生させない

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
