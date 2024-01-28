package com.starter.demo.domain.user.service;

import java.util.List;

import com.starter.demo.domain.user.model.MUser;

/**
 * ユーザサービスのインタフェースです。
 * 
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

	/**
	 * ユーザを一件取得します。
	 * @param userId ユーザid
	 * @return ユーザidで指定したユーザを返します。
	 */
	public MUser getUserOne(String userId);

	/**
	 * ユーザを更新します。
	 * @param userId ユーザid
	 * @param password パスワード
	 * @param userName ユーザ名
	 */
	public void updateUserOne(String userId, String password, String userName);

	/**
	 * ユーザを削除します。
	 * @param userId ユーザid
	 */
	public void deleteUserOne(String userId);
}
