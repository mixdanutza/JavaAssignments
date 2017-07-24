package com.daniela.DojoOverflow.repositories;

import org.springframework.data.repository.CrudRepository;

import com.daniela.DojoOverflow.models.Tag;

public interface TagRepository extends CrudRepository<Tag, Long> {

	Tag findBySubject(String t);

}
