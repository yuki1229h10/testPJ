package com.starter.demo.domain.user.service;

import java.util.List;

import com.starter.demo.domain.user.model.MUser;

/**
 * ユーザサービスのインタフェースです。
 * @author Yuki
 *
 */
public interface UserService {

	/**
	 * ユーザ登録を行います。
	 * @param user ユーザ
	 */
	public void signup(MUser user);

	/**
	 * ユーザ取得を行います。
	 * @return ユーザのリストを返します。
	 */
	public List<MUser> getUsers();
}
