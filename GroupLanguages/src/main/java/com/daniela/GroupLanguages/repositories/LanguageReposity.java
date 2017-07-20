package com.daniela.GroupLanguages.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.daniela.GroupLanguages.models.Language;

@Repository
public interface LanguageReposity extends CrudRepository<Language, Long> {

}
