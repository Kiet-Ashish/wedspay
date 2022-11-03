package com.wedspay.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WedspaySecurityConfig {

	@Autowired
	private DataSource dataSource;

	@Bean
	public UserDetailsService getUserDetailService() {
		return new UserDetailsServiceImpl();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();

		daoAuthenticationProvider.setUserDetailsService(this.getUserDetailService());
		daoAuthenticationProvider.setPasswordEncoder(this.passwordEncoder());

		return daoAuthenticationProvider;
	}

	@Bean
	public UserDetailsManager userDetailsManager() {
		return new JdbcUserDetailsManager(dataSource);
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
			throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		return http.csrf().disable().authorizeRequests().antMatchers("/").permitAll()
				.antMatchers("/user/**").hasRole("USER").and()
				.formLogin().loginPage("/user/showMyLoginPage")
				.loginProcessingUrl("/authenticateTheUser")
				.defaultSuccessUrl("/user/home", true)
				.permitAll()
				.and()
				.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
				.permitAll()
				.and()
				.build();
	}
}
