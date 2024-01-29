package com.starter.demo.form;

import java.util.Date;

import com.starter.demo.domain.user.model.Department;

import lombok.Data;

/**
 * ユーザフォーム
 * @author Yuki
 *
 */
@Data
public class UserDetailForm {
	private String userId;
	private String password;
	private String userName;
	private Date birthday;
	private Integer age;
	private Integer gender;

	// 部署
	private Department department;
}
