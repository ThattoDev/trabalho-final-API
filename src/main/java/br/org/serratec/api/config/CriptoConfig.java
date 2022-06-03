package br.org.serratec.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class CriptoConfig {

	@Bean
	public BCryptPasswordEncoder criptografia() {
		return new BCryptPasswordEncoder();
	}
}
