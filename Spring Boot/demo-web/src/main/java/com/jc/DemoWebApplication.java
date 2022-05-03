package com.jc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoWebApplication {

	/*
		@SpringBootApplication:
		@ComponentScan(excludeFilters={@Filter(type=CUSTOM, classes={TypeExcludeFilter.class}), @Filter(type=CUSTOM, classes={AutoConfigurationExcludeFilter.class})})
		Escanea una ruta de paquetes, para posteriormente realizar la inyección de dependencias.
	*/
	
	public static void main(String[] args) {
		SpringApplication.run(DemoWebApplication.class, args);
	}
}