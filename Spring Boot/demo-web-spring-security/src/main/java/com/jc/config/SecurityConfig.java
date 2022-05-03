package com.jc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.jc.service.UserService;

/*
	@Configuration: Le indicamos a Spring maneje en su contenedor los Beans que se definan en ella.
	@Bean: Sirve para poder declarar y tener una instancia de ámbito singleton en el core container de Spring,
	para que más adelante otra pueda ser la capa que la llame y obtenga la instancia mediante la
	anotación @Autowired.
	
	@EnableWebSecurity: Habilitamos Spring Web Security.
*/

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserService userDetailsService;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}
	
	
	//Configuración de autenticación.
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bcrypt);
	}
	
	//Cualquier petición que entra tiene que estar autenticada.
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			//Si los usuarios no utilizarán su aplicación en un navegador web, entonces es seguro deshabilitar la protección CSRF.
			//De lo contrario, debe asegurarse de incluir el token CSRF en la solicitud.
			.csrf().disable()
			.authorizeRequests()
			.anyRequest()
			.authenticated()
			.and()
			.httpBasic();	
	}
}