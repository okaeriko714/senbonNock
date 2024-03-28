/**
 * 掲示板リスト画面でのリクエストを処理する。
 */

package com.sample.message.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import com.sample.message.business.MessageBoardBusinessLogic;
import com.sample.message.dao.MessageEntity;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/messageBoardList")

//掲示板リスト画面でのリクエストを処理する
public class MessageBoardListServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)

			throws IOException, ServletException {

		//エンコーディング方式の指定
		request.setCharacterEncoding("UTF-8");

		//リクエストパラメータの取得
		String title = request.getParameter("title");

		String content = request.getParameter("content");
		Timestamp registerdate  = null;

		// すべてのメッセージを取得(メッセージ検索)
		List<MessageEntity> messages = MessageBoardBusinessLogic.searchMessage();
		System.out.println("サーブレットに戻ってきた!");
		System.out.println(messages);

		//メッセージを登録
		MessageBoardBusinessLogic.registerMessage(title, content,registerdate);

		//リクエストオブジェクトにリクエストパラメーターを格納
		request.setAttribute("messages", messages);
		
		System.out.println(registerdate);
		//フォワード（画面遷移）する。
		//getServletContext().getRequestDispatcher("/jsp/defaultMenu.jsp").forward(request, response);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/defaultMenu.jsp");
		dispatcher.forward(request, response);
		System.out.println("フォワード");
		
	}

}
