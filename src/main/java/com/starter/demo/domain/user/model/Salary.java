package com.starter.demo.domain.user.model;

import lombok.Data;

/**
 * 給料テーブルのエンティティクラスです。
 * @author Yuki
 *
 */
@Data
public class Salary {
	private String userId;
	private String yearMonth;
	private Integer salary;
}
