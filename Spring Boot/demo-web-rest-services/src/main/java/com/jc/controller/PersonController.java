package com.jc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jc.model.Person;
import com.jc.service.IPersonService;

@RestController
@RequestMapping("/people")
public class PersonController {

	/*
	 	Peticiones HTTP:
	 	
	 	GET		-> @GetMapping		Obtención de datos.
	 	POST	-> @PostMapping		Inserción de datos.
	 	PUT		-> @PutMapping		Actualización de datos.
	 	DELETE	-> @DeleteMapping	Eliminación de datos.
	 	
	 	@RequestBody:
	 	Con esta anotación automáticamente Spring toma ese JSON y lo convierte en un objeto Java.
	 */
	
	@Autowired
	private IPersonService personService;
	
	
	@GetMapping
	public List<Person> listPeople() {
		return personService.getAllPeople();
	}
	
	@PostMapping
	public Person createPerson(@RequestBody Person person) {
		return personService.createPerson(person);
	}
	
	@PutMapping("/{idPerson}")
	public Person updatePerson(@PathVariable(name = "idPerson") Integer idPerson, @RequestBody Person person) {
		person.setId(idPerson);
		return personService.updatePerson(person);
	}
	
	@DeleteMapping("/{idPerson}")
	public void deletePerson(@PathVariable(name = "idPerson") Integer idPerson) {
		personService.deletePerson(idPerson);
	}
}