package com.daniela.belt.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.daniela.belt.models.Role;
import com.daniela.belt.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
	List<User> findByRolesContains(Role role);
	User findByEmail(String username);
}
