package com.daniela.belt.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.daniela.belt.models.Ring;

@Repository
public interface RingRepository extends CrudRepository<Ring, Long> {
	List<Ring> findByUserIsNull();
}
