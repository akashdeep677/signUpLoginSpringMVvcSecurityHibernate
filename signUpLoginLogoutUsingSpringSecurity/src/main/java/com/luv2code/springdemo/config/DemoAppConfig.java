package com.luv2code.springdemo.config;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.luv2code.springdemo")
@PropertySource("classpath:persistence-mysql.properties")
public class DemoAppConfig {

	/*// define a bean for viewResolver
	@Bean
	public ViewResolver viewResolver() {
		
		InternalResourceViewResolver viewResolver =
				new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}*/
	
	@Autowired
	private Environment env;
	
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	
	// define a bean for our security datasource
	
	@Bean(name="javaconfig")
	public DataSource securityDataSource() {
		
		// create connection pool
		ComboPooledDataSource securityDataSource = new ComboPooledDataSource();
		// set jdbc driver class
		try {
			securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException exc ) {
			throw new RuntimeException(exc);
		}
		
		//log the connection props NOT COMpulsory
		logger.info(">>>jdbc.url = "+env.getProperty("jdbc.url"));
		logger.info(">>>jdbc.user = "+env.getProperty("jdbc.user"));
		
		// set database connection props
		securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		securityDataSource.setUser(env.getProperty("jdbc.user"));
		securityDataSource.setPassword(env.getProperty("jdbc.password"));

		//set connection pool
		securityDataSource.setInitialPoolSize(
				strToInt("connection.pool.initialPoolSize"));
		securityDataSource.setMinPoolSize(
				strToInt("connection.pool.minPoolSize"));
		securityDataSource.setMaxPoolSize(
				strToInt("connection.pool.maxPoolSize"));
		securityDataSource.setMaxIdleTime(
				strToInt("connection.pool.maxIdleTime"));
		
		return securityDataSource;
		
	}
	
	//need a helper method 
	// to read environment env property value and convert
	//into int type . for our connection pool
	
	private int strToInt (String propName) {
		
		String propVal = env.getProperty(propName);
		
		int intPropVal = Integer.parseInt(propVal);
		return intPropVal;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
