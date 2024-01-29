package com.starter.demo.domain.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.starter.demo.domain.user.model.MUser;
import com.starter.demo.domain.user.service.UserService;
import com.starter.demo.repository.UserMapper;

/**
 * ユーザサービスの実装クラスです。Mapperのメソッドを呼び出します。
 * @author Yuki
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper mapper;

	/**
	 * ユーザ登録を行います。
	 */
	@Override
	public void signup(MUser user) {
		user.setDepartmentId(1);
		user.setRole("ROLE_GENERAL");
		mapper.insertOne(user);
	}

	/**
	 *ユーザ検索を行います。
	 */
	@Override
	public List<MUser> getUsers(MUser user) {
		return mapper.findMany(user);
	}

	/**
	 *ユーザの取得を行います。
	 */
	@Override
	public List<MUser> getUsers() {
		return mapper.findMany();
	}

	/**
	 *ユーザを一件取得します。
	 */
	@Override
	public MUser getUserOne(String userId) {
		return mapper.findOne(userId);
	}

	/**
	 *ユーザを更新します。
	 */
	@Transactional
	@Override
	public void updateUserOne(String userId, String password, String userName) {
		mapper.updateOne(userId, password, userName);

		// チェック用
		//		int i = 1 / 0;
	}

	/**
	 *ユーザを削除します。
	 */
	@Override
	public void deleteUserOne(String userId) {
		mapper.deleteOne(userId);
	}

}
