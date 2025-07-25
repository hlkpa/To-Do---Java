package com.project.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

 
 @Bean
 public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	 
	
		return http.
				 authorizeHttpRequests(requests -> requests
						 	.requestMatchers("/").permitAll()
							.requestMatchers("/register").permitAll()
							.anyRequest().authenticated()
					)
				 .formLogin(form -> form
						 .defaultSuccessUrl("/",true)
						 )
				 .logout(config -> config.logoutSuccessUrl("/"))
				.build();
				
	}
 
 
 
 
 
 @Bean
 public PasswordEncoder passwordEncoder() {
     return new BCryptPasswordEncoder();
 }
 
}