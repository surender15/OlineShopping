package com.ds.onlineshopping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan({"com.ds.onlineshopping.controller","com.ds.shoppingbackend.service"})
@EnableJpaRepositories("com.ds.shoppingbackend.repository")
@EntityScan("com.ds.shoppingbackend.entity")

@SpringBootApplication
public class OnlineshoppingApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(OnlineshoppingApplication.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(OnlineshoppingApplication.class, args);
	}
}