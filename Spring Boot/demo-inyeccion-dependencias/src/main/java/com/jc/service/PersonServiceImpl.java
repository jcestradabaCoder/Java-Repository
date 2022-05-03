package com.jc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.jc.repository.IPersonRepository;

/*
 	A la clase que quieras que sea manejada por Spring para que pueda tener una instancia en su memoria,
 	se le tendrá que anotar con un estereotipo.
 	
 	Los estereotipos indican que se va a crear un Bean en el contenedor de Spring.
 	Sirven también para estereotipar y contextualizar un uso particular de una clase.
 	
 	@Controller: Indica que la clase anotada es un controlador (HTTP -> Request/Response).
 	@RestController: Indicada para API REST (simplifica la creación de servicios web RESTful).
 	@Repository: Indicada para clases que tienen acceso a datos o a una fuente de información.
 	@Service: Indicada para clases que implementan una lógica o regla de negocio.
 	@Component: Se utiliza para clases utilitarias, una clase que no cumple con las anteriores.
 	
 	
 	Derivaciones de @Component:
 	@Controller
 	@Service
 	@Repository
 	
 	Derivaciones de @Controller:
 	@RestController
 */

@Service
public class PersonServiceImpl implements IPersonService {

	@Autowired
	//Indicamos la referencia a la clase de implementación PersonRepositoryImpl1.
	@Qualifier("personRepositoryImpl1")
	private IPersonRepository personaRepository;
	
	
	@Override
	public void createPerson(String name) {
		personaRepository.save(name);
	}
}