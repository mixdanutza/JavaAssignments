package com.daniela.GroupLanguages.service;


import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.daniela.GroupLanguages.models.Language;

@Service
public class LanguageService {
	
	private List<Language> languages=new ArrayList<Language>(Arrays.asList(
			new Language("JAVA", "Daniela", "98.0.76"),
			new Language("C#", "Alex", "9a.0.76"),
			new Language("MEAN", "Dina", "98.0.76"),
			new Language("JAVA", "Valeria", "98.0.76")
			));

	public List<Language> getLanguages() {
		return languages;
	}
	
	
	public Language findByIndex(int index) {
		if(index<languages.size()) {
			return languages.get(index);
		}else {
			return null;
		}
	}
	
	public void addLanguage(Language language) {
		languages.add(language);
	}
	
	public void editLanguage(int id, Language language) {
		if(id<languages.size()) {
			languages.set(id,language);
		}
	}
	
	public void deleteLanguage(int id) {
		if(id<languages.size()) {
			languages.remove(id);
		}
	}


}
