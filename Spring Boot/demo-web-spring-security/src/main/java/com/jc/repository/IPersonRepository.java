package com.jc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jc.model.Person;

@Repository
public interface IPersonRepository extends JpaRepository<Person, Integer> {

}