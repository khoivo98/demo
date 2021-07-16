package com.laptrinhjavaweb.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import com.laptrinhjavaweb.security.CustomSuccessHandler;
import com.laptrinhjavaweb.service.impl.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SercurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomUserDetailsService customUserDetailsServicel;

	@Autowired
	private CustomSuccessHandler customSuccessHandler;
	
	@Autowired
	private DataSource dataSource;
	 
	// ma hoa password
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		
		http.authorizeRequests()
				.antMatchers("/", "/home","/login","/logout","/register","/api/register").permitAll() // Cho phép tất cả mọi người truy cập vào 2 địa chỉ này
				.antMatchers("/admin/**","/api/**").hasAnyAuthority("ADMIN","MANAGER")
				.antMatchers("/api/user/**").hasAuthority("USER")
				//Ko có quyền vẫn đăng nhập Ngoại lệ AccessDeniedException sẽ ném ra.
				.and().exceptionHandling().accessDeniedPage("/accessDenied");
		 http.authorizeRequests().and().formLogin() // Cho phép người dùng xác thực bằng form login
				.loginProcessingUrl("/j_spring_security_check") // Submit URL
				.loginPage("/login") .permitAll()
				.successHandler(customSuccessHandler)
				.failureUrl("/login?error")
		 		.and()
		 		.logout()
		 		.logoutUrl("/logout")
		 		.logoutSuccessUrl("/login?logoutSuccess")
		 		.permitAll();;
	     // Cấu hình Remember Me.
	        http.authorizeRequests().and() //
	                .rememberMe().tokenRepository(this.persistentTokenRepository()) //
	                .tokenValiditySeconds(15* 24 * 60 * 60);
	             
	 
	}

	// kiem tra
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetailsServicel).passwordEncoder(passwordEncoder());
	}
	
	
	//remeber
	@Bean
	 public PersistentTokenRepository persistentTokenRepository() {
	     JdbcTokenRepositoryImpl db = new JdbcTokenRepositoryImpl();
	     db.setDataSource(dataSource);
	     return db;
	}
}
