/**
 * 掲示板メッセージテーブルのレコード情報を表すEntityクラス
 */

package com.sample.message.dao;

import java.sql.Timestamp;

public class MessageEntity {

	//タイトル
	private String title;
	//内容
	private String content;
	//登録日時
	private Timestamp registerdate;

	//コンストラクタ？いる？
	public MessageEntity() {
	}

	//コンストラクタ
	public MessageEntity(String title, String content, Timestamp registerdate) {
		this.title = title;
		this.content = content;
		this.registerdate = registerdate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getRegisterDate() {
		return registerdate;
	}

	public void setRegisterDate(Timestamp registerDate) {
		this.registerdate = registerDate;
	}

}
