package com.jc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jc.model.Person;
import com.jc.service.IPersonService;

@Controller
public class PersonController {

	@Autowired
	private IPersonService personService;

	
	//http://localhost:8000/people?name=Juan
	@PostMapping("/people")
	public String createPerson(@RequestParam(name = "name", required = true) String name, Model model) {
		Person person = new Person();
		person.setName(name);
		personService.createPerson(person);
		
		model.addAttribute("msg", person.getId() + " - " + person.getName() + " created!");
		
		return "message";
	}
	
	@GetMapping("/people")
	public String listPeopleS(Model model) {
		
		model.addAttribute("people", personService.getAllPeople());
		return "people";
	}
}