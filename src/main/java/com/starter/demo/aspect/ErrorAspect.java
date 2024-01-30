package com.starter.demo.aspect;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * 例外処理のログ確認を行うクラスです。
 * @author Yuki
 *
 */
@Aspect
@Component
@Slf4j
public class ErrorAspect {

	@AfterThrowing(value = "execution(* *..*..*(..))&&"
			+ "(bean(*Controller)||bean(*Service)||bean(*Repository))", throwing = "ex")
	public void throwingNull(DataAccessException ex) {

		// 例外処理の内容(ログ出力) ※一部保留
		log.error("DataAcccessExceptionが発生しました");
	}
}