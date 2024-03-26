/**
 * エンコーディング処理をするためのFilterクラス
 */

package com.sample.message.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class EncodingFilter implements Filter {
	private String encoding = "UTF-8"; // エンコーディングを設定

	
	public void init(FilterConfig filterConfig) throws ServletException {
		// 初期化処理（必要なら）
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding(encoding); // リクエストのエンコーディングを設定
		response.setCharacterEncoding(encoding); // レスポンスのエンコーディングを設定
		chain.doFilter(request, response); // 次のフィルターまたはサーブレットを呼び出す
	}

	
	public void destroy() {
		// 終了処理（必要なら）

	}
}
