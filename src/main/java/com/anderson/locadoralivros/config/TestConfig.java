package com.anderson.locadoralivros.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;


import com.anderson.locadoralivros.sevice.DBService;

@Configuration
@Profile("test")
public class TestConfig {
	
	@Autowired
	private DBService dBService;
	
	@Bean		
	public void instanciaBaseDaDados() {
		this.dBService.instanciaBaseDeDados();
	}

}
