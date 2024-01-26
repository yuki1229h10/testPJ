package com.starter.demo.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ModelMapperをBeanに登録します。
 * @author Yuki
 *
 */
@Configuration
public class JavaConfig {

	/**
	 * ModelMapperをBeanとして登録します。
	 * @return ModelMapperの新しいインスタンス
	 */
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
