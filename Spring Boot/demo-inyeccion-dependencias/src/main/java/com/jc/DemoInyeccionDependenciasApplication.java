package com.jc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jc.service.IPersonService;

@SpringBootApplication
public class DemoInyeccionDependenciasApplication implements CommandLineRunner {
	
	//Arquitecture APP -> Service ->Repository
	//En Spring las instancias son manejadas con ámbito Singleton.
	
	//Mediante esta anotación puedo acceder a la instancia que está definida en el contenedor de Spring por un estereotipo o definición de bean.
	@Autowired
	private IPersonService personService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(DemoInyeccionDependenciasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		personService.createPerson("Juan Carlos");
	}
}