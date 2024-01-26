package com.starter.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.slf4j.Slf4j;

/**
 * ログアウトの制御を行う。
 * @author Yuki
 *
 */
@Controller
@Slf4j
public class LogoutController {

	/**
	 * ログイン画面にリダイレクトする。
	 * @return login.htmlにリダイレクトする。
	 */
	@PostMapping("/logout")
	public String postLogout() {
		log.info("ログアウト");
		return "redirect:/login";
	}
}