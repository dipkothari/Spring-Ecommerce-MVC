package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.cart.dao.cartDao;
import com.cart.dao.cartpDao;

@Configuration

@ComponentScan({ "com.servlet" })

public class addConfig {

	
	/*
	 * @Bean public InternalResourceViewResolver viewresolver() {
	 * InternalResourceViewResolver iv = new InternalResourceViewResolver();
	 * iv.setPrefix("view/"); iv.setSuffix(".jsp"); return iv; }
	 */
	
	@Bean
	public cartDao getcartDao() {
		return new cartDao();
	}
	
	@Bean
	public cartpDao getcartpDao() {
		return new cartpDao();
	}
	 
}
