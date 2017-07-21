package com.daniela.Licenses.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.daniela.Licenses.models.License;
import com.daniela.Licenses.models.Person;
import com.daniela.Licenses.repositories.PersonRepository;

@Service
public class PersonService {
	private PersonRepository personRepository;
	public PersonService(PersonRepository personRepository){
		this.personRepository=personRepository;
	}
	
	public List<Person> allPersons(){
		return (List<Person>) personRepository.findAll();
	}
	
	public void addPerson(Person person) {
		personRepository.save(person);
	}
	

	public Person findOne(int i) {
		// TODO Auto-generated method stub
		return personRepository.findOne((long) i);
	}

	public Person getPersonById(Long id) {
		Person person=personRepository.getPersonById(id);
		return person;
	}

	public List<Person> getNullLicensePersons() {
		List<Person> persons=personRepository.findAllByLicenseNull();
		return persons;
	}

}
