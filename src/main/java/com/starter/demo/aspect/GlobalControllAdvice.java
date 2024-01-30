package com.starter.demo.aspect;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Webアプリケーション全体の例外処理を行うクラスです。(実装忘れ防止)
 * @author Yuki
 *
 */
@ControllerAdvice
public class GlobalControllAdvice {

	/**
	 * データベース関連の例外処理を行うメソッドです。
	 * @param e データベースアクセス時に発生した例外です。
	 * @param model ビューにデータを渡すために使用します。
	 * @return errorを表示します。
	 */
	@ExceptionHandler(DataAccessException.class)
	public String dataAccessExceptionHandler(DataAccessException e, Model model) {

		// 空文字をセット
		model.addAttribute("error", "");

		// メッセージをModelに登録
		model.addAttribute("message", "DataAccessExceptionが発生しました");

		// HTTPのエラーコード(500)をModelに登録
		model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR);

		return "error";
	}

	/**
	 * その他の例外処理を行います。
	 * @param e データベースアクセス時に発生した例外です。
	 * @param model ビューにデータを渡すために使用します。
	 * @return errorを表示します。
	 */
	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception e, Model model) {

		// 空文字をセット
		model.addAttribute("error", "");

		// メッセージをModelに登録
		model.addAttribute("message", "Exceptionが発生しました");

		// HTTPのエラーコード(500)をModelに登録
		model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR);

		return "error";
	}
}
