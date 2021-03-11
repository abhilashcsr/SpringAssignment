package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
