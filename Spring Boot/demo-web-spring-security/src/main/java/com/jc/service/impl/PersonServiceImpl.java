package com.jc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jc.model.Person;
import com.jc.repository.IPersonRepository;
import com.jc.service.IPersonService;

@Service
public class PersonServiceImpl implements IPersonService {
	
	@Autowired
	IPersonRepository personRepository;
	

	@Override
	public Person createPerson(Person person) {
		return personRepository.save(person);
	}

	@Override
	public List<Person> getAllPeople() {
		return personRepository.findAll();
	}

	@Override
	public Person updatePerson(Person person) {
		return personRepository.save(person);
	}

	@Override
	public void deletePerson(Integer idPerson) {
		personRepository.deleteById(idPerson);
	}
}