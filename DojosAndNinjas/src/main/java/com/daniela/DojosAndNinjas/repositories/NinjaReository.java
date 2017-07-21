package com.daniela.DojosAndNinjas.repositories;

import org.springframework.data.repository.CrudRepository;

import com.daniela.DojosAndNinjas.models.Ninja;

public interface NinjaReository extends CrudRepository<Ninja, Long> {

}
