package com.starter.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * ログインの制御を行う。
 * @author Yuki
 *
 */
@Controller
public class LoginController {

	/**
	 * ログイン画面を表示する。
	 * @return login.htmlを表示します。
	 */
	@GetMapping("/login")
	public String getLogin() {
		return "login/login";
	}

	/**
	 * ユーザ一覧画面にリダイレクトする。
	 * @return list.htmlにリダイレクトする。
	 */
	@PostMapping("/login")
	public String postLogin() {
		return "redirect:/user/list";
	}
}
