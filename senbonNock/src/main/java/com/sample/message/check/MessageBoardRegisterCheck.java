/**
 * 掲示板の登録処理時の入力チェック処理を行う。
 */

package com.sample.message.check;

import java.util.ArrayList;
import java.util.List;

import com.sample.message.exception.BusinessLogicException;

public class MessageBoardRegisterCheck {

	public static List<String> checkInputData(String title, String content) {
		// Initialize an empty list to store error messages
		List<String> errorMessages = new ArrayList<>();

		// Check title
		if (title.isEmpty()) {
			errorMessages.add("【タイトルについて】\n1.タイトルを入力してください。（優先度１）");

		} else {
			// Check if title contains only full-width characters
			//        boolean isFullWidth = title.matches("[\\p{IsHiragana}\\p{IsKatakana}\\p{IsCJKUnifiedIdeographs}]+");
			boolean isFullWidth = title.matches("[\\\\p{IsHiragana}\\\\p{IsKatakana}\\\\p{IsIdeographic}]+");
			if (!isFullWidth) {
				errorMessages.add("【タイトルについて】\n2. タイトルは全角文字で入力してください。（優先度２）");
			}
			if (title.length() > 20) {
				errorMessages.add("【タイトルについて】\n3. タイトルは２０字以内で入力してください。（優先度２）");
			}
		}

		// Check content
		if (content.isEmpty()) {
			errorMessages.add("【投稿内容】\n1. 投稿内容を入力してください。（優先度１）");
		} else if (content.length() > 100) {
			errorMessages.add("【投稿内容】\n2. 投稿内容は１００字以内で入力してください。（優先度２）");
		}

		if (!errorMessages.isEmpty()) {
			throw new BusinessLogicException("入力エラーが発生しました。");
		}
		return errorMessages;
	}
}
