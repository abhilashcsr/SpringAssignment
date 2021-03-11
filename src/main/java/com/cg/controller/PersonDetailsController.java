package com.cg.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.cg.service.PersonDetailsService;
import com.cg.exception.*;
import com.cg.entity.*;
import com.cg.repository.*;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping//("/persons")
public class PersonDetailsController {
	
	//@Autowired
	//RestTemplate restTemplate;
	
	@Autowired
	private PersonRepository personRepository;
	
	
	//To get All Persons Details
	@GetMapping("/persons/getAll")
	public List<Person> getAllPerson(){
	return personRepository.findAll();
	}
	
	//To get Person by ID
	@GetMapping("/persons/{id}")
	public ResponseEntity<Person> getPersonById(@PathVariable(value = "id") Long personId)
			throws ResourceNotFoundException {
		Person person = personRepository.findById(personId)
				.orElseThrow(()-> new ResourceNotFoundException(" Person ID Not Found:" + personId));
		return ResponseEntity.ok().body(person);
	}
	
	//Save Person Details
	@PostMapping("/persons")
	public Person CreatePerson(@Valid @RequestBody Person person) {
		return personRepository.save(person);
	}
	
	// Update Person by ID
	@PutMapping("/persons/{id}")
	public ResponseEntity<Person> updatePerson(@PathVariable(value = "id") Long personId,
			@Valid @RequestBody Person personDetails) throws ResourceNotFoundException {
		Person person = personRepository.findById(personId)
				.orElseThrow(()-> new ResourceNotFoundException("The following Person is not found for this id :: " + personId));
		person.setId(personDetails.getId());
		person.setSurName(personDetails.getSurName());
		person.setFirstName(personDetails.getFirstName());
		final Person updatedPerson = personRepository.save(person);
		return ResponseEntity.ok(updatedPerson);
	}
	
	
	// Delete Person by ID
	@DeleteMapping("/persons/{id}")
	public Map<String, Boolean> deletePerson(@PathVariable(value = "id") Long personId)
			throws ResourceNotFoundException {
		Person person = personRepository.findById(personId)
				.orElseThrow(() -> new ResourceNotFoundException("The following Person is not found for this id :: " + personId));
		personRepository.delete(person);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}		

}
