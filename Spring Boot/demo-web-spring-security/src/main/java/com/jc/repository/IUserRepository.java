package com.jc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jc.model.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
	
	User findByName(String name);
}