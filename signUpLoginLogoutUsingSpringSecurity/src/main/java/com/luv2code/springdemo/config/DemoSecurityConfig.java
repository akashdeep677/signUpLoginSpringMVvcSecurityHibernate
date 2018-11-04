package com.luv2code.springdemo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

import com.luv2code.springdemo.customSuccessHandler.CustomSuccessHandler;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	// add a reference to our security data source
	
	@Qualifier("javaconfig")
	@Autowired
	private DataSource securityDatasource;
	
	@Autowired
    CustomSuccessHandler customSuccessHandler;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests().
		antMatchers("/").permitAll()
		.antMatchers("/index.jsp").permitAll()
		.antMatchers("/customer/**").permitAll().
		antMatchers("/**").hasRole("USERS").
		anyRequest().authenticated().and().
		formLogin().loginPage("/showMyLoginPage").
		loginProcessingUrl("/authenticateTheUser").successHandler(customSuccessHandler).
		permitAll().
		and().logout().permitAll();
		
		
		
		}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// use jdbc authentication
		auth.jdbcAuthentication().dataSource(securityDatasource);
	
	}

		
}
