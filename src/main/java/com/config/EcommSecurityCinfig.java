package com.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.ecomm.service.CustomeUserService;

@Configuration
@EnableWebSecurity
public class EcommSecurityCinfig extends WebSecurityConfigurerAdapter{

	@Autowired
	CustomeUserService customeUserService;
	
	
	 @Override
	    public void configure(WebSecurity web) throws Exception {
	        web.ignoring().antMatchers("/v2/api-docs",
	                                   "/configuration/ui",
	                                   "/swagger-resources/**",
	                                   "/configuration/security",
	                                   "/swagger-ui.html",
	                                   "/webjars/**");
	    }
	 
	 
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		.authorizeRequests()
		.antMatchers("/user/add").permitAll()
		.antMatchers("/swagger-ui/**").permitAll()
		.antMatchers("/user/**").hasRole("ADMIN")
		.antMatchers("/cart/**").hasRole("USER")
		.antMatchers("/cart/**").hasRole("USER")
		.antMatchers("/product/**").hasRole("ADMIN")
		.antMatchers("/order/**").hasRole("ADMIN")
		.anyRequest()
		.authenticated()
		.and()
		.httpBasic();
		
		
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.userDetailsService(customeUserService);
		super.configure(auth);
	}
	
	
	

}
