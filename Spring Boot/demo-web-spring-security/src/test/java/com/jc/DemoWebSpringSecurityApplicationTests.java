package com.jc;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.jc.model.User;
import com.jc.repository.IUserRepository;

@SpringBootTest
class DemoWebSpringSecurityApplicationTests {
	
	//Las pruebas deben pensarse en escenarios.
	
	@Autowired
	private IUserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void createUser() {		
		User user = new User();
		
		user.setId(1);
		user.setName("JC");
		user.setPassword(encoder.encode("pass000"));
		
		User registeredUser = userRepository.save(user);
		
		assertTrue(registeredUser.getName().equalsIgnoreCase(user.getName()));
	}
}