package com.daniela.DojosAndNinjas.repositories;

import org.springframework.data.repository.CrudRepository;

import com.daniela.DojosAndNinjas.models.Dojo;

public interface DojoReository extends CrudRepository<Dojo, Long> {
	

}
