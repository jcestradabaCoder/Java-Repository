package com.jc.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.jc.DemoInyeccionDependenciasApplication;

@Repository
@Qualifier("personRepositoryImpl2")
public class PersonRepositoryImpl2 implements IPersonRepository {
	
	private static Logger LOG = LoggerFactory.getLogger(DemoInyeccionDependenciasApplication.class);

	@Override
	public void save(String name) {
		LOG.info("Se registro al usuario: " + name + "...");
	}
}