package com.starter.demo.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.starter.demo.domain.user.model.MUser;
import com.starter.demo.domain.user.service.UserService;
import com.starter.demo.form.UserDetailForm;

/**
 * ユーザ詳細画面の制御を行います。
 * @author Yuki
 *
 */
@Controller
@RequestMapping("/user")
public class UserDetailController {

	@Autowired
	private UserService userService;

	@Autowired
	private ModelMapper modelMapper;

	/**
	 * ユーザ情報の詳細を取得します。
	 * @param form フォーム
	 * @param model モデル
	 * @param userId ユーザid
	 * @return detail.htmlを表示します。
	 */
	@GetMapping("/detail/{userId:.+}")
	public String getUser(UserDetailForm form, Model model, @PathVariable("userId") String userId) {

		// ユーザを一件取得
		MUser user = userService.getUserOne(userId);
		user.setPassword(null);

		// MUserをformに変換
		form = modelMapper.map(user, UserDetailForm.class);

		// Modelに登録
		model.addAttribute("userDetailForm", form);

		// ユーザ詳細画面を表示
		return "user/detail";
	}

	/**
	 * ユーザを更新します。
	 * @param form フォーム
	 * @param model モデル
	 * @return list.htmlを表示します。
	 */
	@PostMapping(value = "/detail", params = "update")
	public String updateUser(UserDetailForm form, Model model) {

		// ユーザを更新
		userService.updateUserOne(form.getUserId(), form.getPassword(), form.getUserName());

		// ユーザ一覧画面にリダイレクト
		return "redirect:/user/list";
	}

	/**
	 * ユーザを削除します。
	 * @param form フォーム
	 * @param model モデル
	 * @return list.htmlを表示します。
	 */
	@PostMapping(value = "/detail", params = "delete")
	public String deleteUser(UserDetailForm form, Model model) {

		// ユーザを削除
		userService.deleteUserOne(form.getUserId());

		// ユーザ一覧画面にリダイレクト
		return "redirect:/user/list";
	}
}
