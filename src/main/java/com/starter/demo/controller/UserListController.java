package com.starter.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.starter.demo.domain.user.model.MUser;
import com.starter.demo.domain.user.service.UserService;

/**
 * ユーザ一覧画面の制御を行う。
 * @author Yuki
 *
 */
@Controller
@RequestMapping("/user")
public class UserListController {

	@Autowired
	private UserService userService;

	/**
	 * ユーザ一覧画面を表示する。
	 * @return list.htmlを表示する。
	 */
	@GetMapping("/list")
	public String getUserList(Model model) {

		// ユーザ一覧取得
		List<MUser> userList = userService.getUsers();

		// Modelに登録
		model.addAttribute("userList", userList);

		// ユーザ一覧画面を表示
		return "user/list";
	}
}
