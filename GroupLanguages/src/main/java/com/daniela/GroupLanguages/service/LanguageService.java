package com.daniela.GroupLanguages.service;


import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.daniela.GroupLanguages.models.Language;
import com.daniela.GroupLanguages.repositories.LanguageReposity;

@Service
public class LanguageService {
	private LanguageReposity languageReposity;
	public LanguageService(LanguageReposity languageReposity) {
		this.languageReposity=languageReposity;	
		
	}
	
	private List<Language> languages=new ArrayList<Language>(Arrays.asList(
			new Language("JAVA", "Daniela", "98.0.76"),
			new Language("C#", "Alex", "9a.0.76"),
			new Language("MEAN", "Dina", "98.0.76"),
			new Language("JAVA", "Valeria", "98.0.76")
			));

	public List<Language> getLanguages() {
		return (List<Language>) languageReposity.findAll();
	}
	
	
	public Language findByIndex(long id) {
		return languageReposity.findOne(id);
	}
	
	public void addLanguage(Language language) {
		languageReposity.save(language);
	}
	
	public void editLanguage(long id, Language language) {
		languageReposity.save(language);
	}
	
	public void deleteLanguage(long id) {
		if(id<languageReposity.count()) {
			languageReposity.delete(id);
		}
	}


}
