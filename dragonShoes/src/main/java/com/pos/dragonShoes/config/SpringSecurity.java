package com.pos.dragonShoes.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SpringSecurity {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public static BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable()
				.authorizeHttpRequests((authorize) ->
						authorize.requestMatchers("/member/**").permitAll()
								.requestMatchers("/admin/**").permitAll()
								.requestMatchers(HttpMethod.GET,"/css/**","/assets/**","/js/**","/images/**").permitAll()
								.requestMatchers("/admin/adminHome").hasRole("ADMIN")
								.requestMatchers("/member/memberHome").hasRole("MEMBER")
				).formLogin(
						form -> form
								.loginPage("/adminLogin")
								.loginProcessingUrl("/admin/adminLogin")
								.defaultSuccessUrl("/adminHome")
								.permitAll()
				).formLogin(
						form -> form
								.loginPage("/memberLogin")
								.loginProcessingUrl("/member/memberLogin")
								.defaultSuccessUrl("/memberHome")
								.permitAll()
				).logout(
						logout -> logout
								.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
								.permitAll()
				);
		return http.build();	
	}
	
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth
				.userDetailsService(userDetailsService)
				.passwordEncoder(passwordEncoder());
	}
}
