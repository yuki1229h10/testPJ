package com.starter.demo.application.service;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

/**
 * ユーザ関連の制御を行う。
 * @author Yuki
 *
 */
@Service
public class UserApplicationService {

	@Autowired
	private MessageSource messageSource;

	/**
	 * 性別のMapを生成する。
	 * @param locale 言語
	 * @return 性別の分類を表すMap。キーは性別の文字列（"男性"、"女性"）で、値は対応する整数コード（1、2）です。
	 */
	public Map<String, Integer> getGenderMap(Locale locale) {
		Map<String, Integer> genderMap = new LinkedHashMap<>();
		String male = messageSource.getMessage("male", null, locale);
		String female = messageSource.getMessage("female", null, locale);
		genderMap.put(male, 1);
		genderMap.put(female, 2);
		return genderMap;
	}
}
