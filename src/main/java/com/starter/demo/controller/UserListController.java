package com.starter.demo.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.starter.demo.domain.user.model.MUser;
import com.starter.demo.domain.user.service.UserService;
import com.starter.demo.form.UserListForm;

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

	@Autowired
	private ModelMapper modelMapper;

	/**
	 * ユーザ一覧画面を表示する。
	 * @param form フォーム
	 * @param model モデル
	 * @return list.htmlを返却する。
	 */
	@GetMapping("/list")
	public String getUserList(@ModelAttribute UserListForm form, Model model) {

		// formをMUserクラスに変換
		MUser user = modelMapper.map(form, MUser.class);

		// ユーザ検索
		List<MUser> userList = userService.getUsers(user);

		// Modelに登録
		model.addAttribute("userList", userList);

		// ユーザ一覧画面を表示
		return "user/list";
	}

	/**
	 * ユーザ検索処理を行う。
	 * @param form フォーム
	 * @param model モデル
	 * @return list.htmlを表示する。
	 */
	@PostMapping("/list")
	public String postUserList(@ModelAttribute UserListForm form, Model model) {

		// formをMUserクラスに変換
		MUser user = modelMapper.map(form, MUser.class);

		// ユーザ検索
		List<MUser> userList = userService.getUsers(user);

		// Modelに登録
		model.addAttribute("userList", userList);

		// ユーザ一覧画面を表示
		return "user/list";
	}
}
