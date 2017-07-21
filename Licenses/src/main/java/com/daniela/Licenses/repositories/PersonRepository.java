package com.daniela.Licenses.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.daniela.Licenses.models.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {
	Person getPersonById(Long search);
	List<Person> findAllByLicenseNull();
}
