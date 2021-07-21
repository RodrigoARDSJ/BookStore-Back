package com.rodrigo.bookstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.rodrigo.bookstore.service.DBService;

@Configuration
@Profile("dev")
public class DevConfig {

	@Autowired
	private DBService dbService;

	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;

	public boolean instanciarBaseDeDados() {
		if (strategy.equals("update")) {
			this.dbService.instanciarBaseDeDados();

		}
		return false;
	}
}
