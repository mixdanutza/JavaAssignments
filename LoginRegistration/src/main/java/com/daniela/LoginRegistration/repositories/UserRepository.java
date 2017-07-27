package com.daniela.LoginRegistration.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.daniela.LoginRegistration.models.Role;
import com.daniela.LoginRegistration.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
	User findByFirstName(String firstName);
	List<User> findByRolesContains(Role role);
}
