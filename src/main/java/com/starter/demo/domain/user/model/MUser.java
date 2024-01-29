package com.starter.demo.domain.user.model;

import java.util.Date;
import java.util.List;

import lombok.Data;

/**
 * ユーザマスタのエンティティクラスです。
 * @author Yuki
 *
 */
@Data
public class MUser {
	private String userId;
	private String password;
	private String userName;
	private Date birthday;
	private Integer age;
	private Integer gender;
	private Integer departmentId;
	private String role;

	// 部署
	private Department department;

	// 給料
	private List<Salary> salaryList;
}
