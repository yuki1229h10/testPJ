package com.starter.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

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
}
