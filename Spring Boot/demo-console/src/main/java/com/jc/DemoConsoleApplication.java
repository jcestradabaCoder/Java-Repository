package com.jc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//La clase que tiene el método main tiene que implementar la interfaz CommandLineRunner.
public class DemoConsoleApplication implements CommandLineRunner {
	
	//Para trabajar impresiones en consola desde el log.
	private static Logger LOG = LoggerFactory.getLogger(DemoConsoleApplication.class);
	

	public static void main(String[] args) {
		SpringApplication.run(DemoConsoleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hola Juan Carlos!");
		
		//Escribir mensaje desde el log
		LOG.info("Mensaje desde Spring Boot en consola....");
		//Escribir mensaje de advertencia desde el log
		LOG.warn("Advertencia!");
	}
}