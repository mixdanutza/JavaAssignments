package com.daniela.belt.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.daniela.belt.models.Team;

@Repository
public interface TeamRepository extends CrudRepository<Team, Long> {

}
