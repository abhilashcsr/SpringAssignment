package com.cg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Person_Table")


public class Person {
	
	@Column(name = "Person_ID",nullable = false)
	private long Id;
	
	@Column(name = "First_Name",nullable = false)
	private String FirstName;
	
	@Column(name = "Sur_Name", nullable = false)
	private String SurName;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return Id;
	}
	
	public Person() {
		
	}
	
	public Person(long id, String FirstName, String SurName) {
		this.Id = Id;
		this.FirstName = FirstName;
		this.SurName = SurName;
	}
	
	

}
