package com.starter.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

/**
 * セキュリティ設定クラスです。
 * @author Yuki
 *
 */
@Configuration
public class SecurityConfig {

	/**
	 * セキュリティの対象外を設定します。
	 * @return 何を書けばいいのかわかりません。
	 */
	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return web -> web.ignoring().requestMatchers("/webjars/**", "/css/**", "/js/**", "/h2-console/**");
	}

	/**
	 * Spring Securityのフィルターチェーンを設定するメソッドです。
	 * @param http HttpSecurityオブジェクト
	 * @return SecurityFilterChainオブジェクトを返します。
	 * @throws Exception 例外
	 */
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(authz -> authz.requestMatchers("/login").permitAll().requestMatchers("/user/signup")
				.permitAll().anyRequest().authenticated());

		return http.csrf().disable();
		// ログイン不要ページの設定		

		//		http.formLogin(login -> login.loginProcessingUrl("/login").loginPage("/login").failureUrl("/login?error")
		//				.usernameParameter("userId").passwordParameter("password").defaultSuccessUrl("/user/list", true))
		//				.logout(logout -> logout.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutUrl("/logout")
		//						.logoutSuccessUrl("/login?logout"))
		//				.authorizeHttpRequests(authz -> authz.requestMatchers("/login", "/user/signup", "/error").permitAll()
		//						.requestMatchers("/admin").hasAuthority("ROLE_ADMIN").anyRequest().authenticated());

		//
	}
}
