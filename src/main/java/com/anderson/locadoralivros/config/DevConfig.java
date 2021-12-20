package com.anderson.locadoralivros.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.anderson.locadoralivros.sevice.DBService;

@Configuration
@Profile("dev")
public class DevConfig {

	@Autowired
	private DBService dService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;
	
	@Bean
	public boolean instanciaBaseDeDaados() {
		if(strategy.equals("create")) {
			this.dService.instanciaBaseDeDados();
		}
		return false;
	}
}
