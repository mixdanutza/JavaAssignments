package com.daniela.belt.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.daniela.belt.models.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

	List<Role> findByName(String string);

}
