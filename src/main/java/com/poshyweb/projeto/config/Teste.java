package com.poshyweb.projeto.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.poshyweb.projeto.serve.DBserver;

@Configuration   // configuraçaõ do perfil
@Profile("test") // perfil ativo
public class Teste {
	
	@Autowired
	private DBserver dBserver;
	
	@Bean
	public void istanciaBaseDeDados() {
		this.dBserver.istanciaBaseDeDados();
	}

}
