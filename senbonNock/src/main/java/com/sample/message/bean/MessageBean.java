/**
 * 掲示板一覧画面のメッセージ一件分の情報を表すJavaBeanクラス
 */

package com.sample.message.bean;

import java.security.Timestamp;

public class MessageBean extends MessageBoardListBean {
	
	//メンバ変数
	private Timestamp registerDate;
	
	
	//引数なしのコンストラクタの定義
	public MessageBean() {
	}
	
	//setterメソッドの定義
	//getterメソッドの定義
	public Timestamp getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Timestamp registerDate) {
		this.registerDate = registerDate;
	}

}
