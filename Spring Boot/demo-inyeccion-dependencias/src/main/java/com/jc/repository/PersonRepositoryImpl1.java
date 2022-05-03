package com.jc.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.jc.DemoInyeccionDependenciasApplication;

@Repository
//Se utiliza la anotación @Qualifier para poder identificar cual clase de implementación se utilizará.
@Qualifier("personRepositoryImpl1")
public class PersonRepositoryImpl1 implements IPersonRepository {
	
	private static Logger LOG = LoggerFactory.getLogger(DemoInyeccionDependenciasApplication.class);

	@Override
	public void save(String name) {
		LOG.info("Se registro a: " + name + "...");
	}
}