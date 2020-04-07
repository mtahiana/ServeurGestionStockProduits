package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;
	
	protected void configure(HttpSecurity http) throws Exception {
		http
		.httpBasic()
			.and()
				.authorizeRequests().antMatchers("/**").hasRole("ADMIN")
				.antMatchers("/api/**")
					.hasRole("USER").and()
					.csrf().disable().headers().frameOptions().disable();
	}
	
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		auth./*inMemoryAuthentication()*/userDetailsService(userDetailsService).passwordEncoder(
				NoOpPasswordEncoder.getInstance())
		/*.withUser("user").password("password1")
				.roles("USER").and().withUser("admin").password("password2")
				.roles("USER", "ADMIN")*/ ;
	}
}
