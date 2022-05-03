package com.jc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*
 	Peticiones HTTP:
 	
 	POST	->	@PostMapping
 	GET		->	@GetMapping
 	PUT		->	@PutMapping
 	DELETE	->	@DeleteMapping
 	
 	@RequestParam:
 	Mediate esta anotación nos indica que recibiremos un nombre.
 */

@Controller
public class DemoController {

	//Esta anotación nos indica que se podrá acceder a la función solamente a través de la petición de tipo GET.
	// /greeting?name=Juan
	@GetMapping("/greeting")
	public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}
}