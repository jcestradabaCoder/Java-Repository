package com.jc.service;

import java.util.List;

import com.jc.model.Person;

public interface IPersonService {
	
	Person createPerson(Person person);
	List<Person> getAllPeople();
}