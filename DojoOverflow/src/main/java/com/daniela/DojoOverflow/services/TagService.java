package com.daniela.DojoOverflow.services;

import org.springframework.stereotype.Service;

import com.daniela.DojoOverflow.models.Tag;
import com.daniela.DojoOverflow.repositories.TagRepository;

@Service
public class TagService {
	private TagRepository tagRepository;
	public TagService(TagRepository tagRepository) {
		this.tagRepository=tagRepository;
	}
	public Tag addAndReturn(Tag newTag) {
		tagRepository.save(newTag);
		Long count=tagRepository.count();
		Tag lastTag=tagRepository.findOne(count);
		return lastTag;
	}
	public Tag findBySubject(String t) {
		Tag tag=tagRepository.findBySubject(t);
		return tag;
	}
	public void saveTag(Tag newTag) {
		tagRepository.save(newTag);	
	}
	public Tag findOne(Long id) {
		Tag t=tagRepository.findOne(id);
		return t;
	}


}
