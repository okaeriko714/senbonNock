package com.sample.message.bean;

import java.io.Serializable;
import java.util.List;

public class MessageBoardListBean implements Serializable {

	//メンバ変数
	private String title;
	private String content;
	private List<MessageBean> messageBeanList;

	//引数なしのコンストラクタの定義
	public MessageBoardListBean() {
	}

	//setterメソッドの定義
	//getterメソッドの定義
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setName(String content) {
		this.content = content;
	}

	public  List<MessageBean> getMessageBeanList() {
		return messageBeanList;
	}

	public void setMessageBeanList(List<MessageBean> messageBeanList) {
		this.messageBeanList = messageBeanList;
	}
}
