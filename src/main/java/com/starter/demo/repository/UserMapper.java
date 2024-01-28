package com.starter.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.starter.demo.domain.user.model.MUser;

/**
 * ユーザマスタテーブル用のリポジトリーです。
 * @author Yuki
 *
 */
@Mapper
public interface UserMapper {

	/**
	 * ユーザ登録を行います。
	 * @param user ユーザ
	 * @return データベースへの挿入が成功した場合は1、それ以外の場合は0を返します。
	 */
	public int insertOne(MUser user);

	/**
	 * 複数のユーザを検索します。
	 * @return ユーザのリストを返却します。
	 */
	public List<MUser> findMany();

	/**
	 * ユーザを取得します。
	 * @param userId ユーザid
	 * @return 指定されたユーザidに対応するユーザ情報を返します。
	 */
	public MUser findOne(String userId);

	/**
	 * ユーザ情報を更新します。
	 * @param userId ユーザid
	 * @param password パスワード
	 * @param userName ユーザ名
	 */
	public void updateOne(@Param("userId") String userId, @Param("password") String password,
			@Param("userName") String userName);

	/**
	 * 指定されたユーザidに対応するユーザをデータベースから削除します。
	 * @param userId 削除対象のユーザid
	 * @return 削除が成功した場合は1を返し、それ以外の場合は0を返します。
	 */
	public int deleteOne(@Param("userId") String userId);
}
