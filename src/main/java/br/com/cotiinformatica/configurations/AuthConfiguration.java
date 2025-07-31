package br.com.cotiinformatica.configurations;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.cotiinformatica.components.JwtComponent;
import br.com.cotiinformatica.filters.AuthenticationFilter;

@Configuration
public class AuthConfiguration {	

	@Bean
	FilterRegistrationBean<AuthenticationFilter> authenticationFilter(JwtComponent jwtComponent) {

		FilterRegistrationBean<AuthenticationFilter> registration = new FilterRegistrationBean<>();

		registration.setFilter(new AuthenticationFilter(jwtComponent));

		registration.addUrlPatterns("/api/*");

		return registration;
	}
}