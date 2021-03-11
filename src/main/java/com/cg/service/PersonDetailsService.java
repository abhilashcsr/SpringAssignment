package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Person;
import com.cg.repository.PersonRepository;

@Service
public class PersonDetailsService {
	
	@Autowired
	private PersonRepository repository;
	
	public List<Person> getPersonById() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Person> getAllPerson(){
		List<Person> person = repository.findAll();
		return person;
	}
	
	public Optional<Person> getPersonById(long Id) {
		return repository.findById(Id);
	}

	public Object updatePerson(Person person) {
		// TODO Auto-generated method stub
		return null;
	}

}
