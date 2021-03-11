package com.cg;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
//import org.junit.jupiter.api.Test;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import com.cg.controller.*;
import com.cg.entity.Person;
import com.cg.repository.PersonRepository;
import com.cg.service.PersonDetailsService;

@RunWith(SpringRunner.class)
@SpringBootTest

public class PersonTest {
	
	@Autowired
	private PersonDetailsService service;
	
	@MockBean
	private PersonRepository repository;
	
	@Test
	public void getPersonByIdTest(List<Person>list ) {
		when(repository.findAll()).thenReturn(Stream
				.of(new Person (1,"MS", "Dhoni"), new Person(2,"Yuvraj","Singh")).collect(Collectors.toList()));
		assertEquals(2, service.getPersonById().size());
		
		
		//when(repository.findAll()).thenReturn(1,"MS", "Dhoni").collect(Collectors.toList());

	//@Test
	//public void test() {
	//PersonDetailsController obj1 =new PersonDetailsController();
	
	
	public void updatePersonTest() {
		Person person = new Person(3,"Corey ","Anderson");
		when(repository.save(person)).thenReturn(person);
		assertEquals(person, service.updatePerson(person));
	}
	
	}

}
