package com.starter.demo.controller;

import java.util.Locale;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.starter.demo.application.service.UserApplicationService;
import com.starter.demo.domain.user.model.MUser;
import com.starter.demo.domain.user.service.UserService;
import com.starter.demo.form.GroupOrder;
import com.starter.demo.form.SignupForm;

import lombok.extern.slf4j.Slf4j;

/**
 * サインアップの制御を行う。
 * @author Yuki
 *
 */
@Controller
@RequestMapping("/user")
@Slf4j
public class SignupController {

	@Autowired
	private UserApplicationService userApplicationService;

	@Autowired
	private UserService userService;

	@Autowired
	private ModelMapper modelMapper;

	/**
	 * ユーザ登録画面を表示する。
	 * @param model モデル
	 * @return signup.htmlを表示します。
	 */
	@GetMapping("/signup")
	public String getSignup(Model model, Locale locale, @ModelAttribute SignupForm form) {
		Map<String, Integer> genderMap = userApplicationService.getGenderMap(locale);
		model.addAttribute("genderMap", genderMap);

		return "user/signup";
	}

	/**
	 * ユーザ登録処理を行う。
	 * @return login.htmlへリダイレクトします。
	 */
	@PostMapping("/signup")
	public String postSignup(Model model, Locale locale, @ModelAttribute @Validated(GroupOrder.class) SignupForm form,
			BindingResult bindingResult) {

		// 入力チェック結果
		if (bindingResult.hasErrors()) {
			// NG:ユーザ登録画面に戻ります
			return getSignup(model, locale, form);
		}

		log.info(form.toString());

		// formをMUserクラスに変換
		MUser user = modelMapper.map(form, MUser.class);

		// ユーザ登録
		userService.signup(user);

		// ログイン画面にリダイレクト
		return "redirect:/login";
	}
}
