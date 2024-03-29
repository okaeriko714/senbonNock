/**
 * 掲示板の登録処理時の入力チェック処理を行う。
 */

package com.sample.message.check;

import java.util.ArrayList;
import java.util.List;

public class MessageBoardRegisterCheck {

	public static List<String> checkInputData(String title, String content) {
		// Initialize an empty list to store error messages
		List<String> errorMessages = new ArrayList<>();

		System.out.println("1:" + errorMessages.size());
		//正規表現パターンを定義
		String pattern = "^[^ -~｡-ﾟ]+";

		// Check title
		if (title.isEmpty()) {
			errorMessages.add("タイトルを入力してください。");
		} else {
			// Check if title contains only full-width characters
			boolean isFullWidth = title.matches(pattern);
			if (!isFullWidth) {
				errorMessages.add("タイトルは全角文字で入力してください。");
			}
			if (title.length() > 20) {
				errorMessages.add("タイトルは２０字以内で入力してください。");
			}
		}

		// Check content
		if (content.isEmpty()) {
			errorMessages.add("投稿内容を入力してください。");
		} else if (content.length() > 100) {
			errorMessages.add("投稿内容は１００字以内で入力してください。");
		}

		return errorMessages;
	}
}
