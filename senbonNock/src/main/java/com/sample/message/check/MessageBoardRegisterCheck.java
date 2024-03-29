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
		String pattern = "^[^ -~｡-ﾟ]"+"^[ァ-ヴー]+$";
		

		// Check title
		if (title.isEmpty()) {
			errorMessages.add("1.タイトルを入力してください。");
			System.out.println("2:" + errorMessages.size());
		} else {
			// Check if title contains only full-width characters
			boolean isFullWidth = title.matches(pattern);
			if (!isFullWidth) {
				errorMessages.add("2. タイトルは全角文字で入力してください。");
				System.out.println("3:" + errorMessages.size());
			}
			if (title.length() > 20) {
				errorMessages.add("3. タイトルは２０字以内で入力してください。");
				System.out.println("4:" + errorMessages.size());
			}
		}

		// Check content
		if (content.isEmpty()) {
			errorMessages.add("1. 投稿内容を入力してください。");
			System.out.println("5:" + errorMessages.size());
		} else if (content.length() > 100) {
			errorMessages.add("2. 投稿内容は１００字以内で入力してください。");
			System.out.println("6:" + errorMessages.size());
		}

		return errorMessages;
	}
}
