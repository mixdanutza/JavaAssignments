package com.daniela.DojoOverflow.repositories;

import org.springframework.data.repository.CrudRepository;

import com.daniela.DojoOverflow.models.Question;

public interface QuestionRepository extends CrudRepository<Question, Long> {

	Question findOneById(Long id);


}
