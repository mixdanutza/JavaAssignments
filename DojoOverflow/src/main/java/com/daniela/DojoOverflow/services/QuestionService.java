package com.daniela.DojoOverflow.services;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.daniela.DojoOverflow.models.Question;
import com.daniela.DojoOverflow.repositories.QuestionRepository;

@Service
public class QuestionService {
	private QuestionRepository questionRepository;
	public QuestionService(QuestionRepository questionRepository) {
		this.questionRepository=questionRepository;
	}
	public void addQuestion(Question newQuestion) {
		questionRepository.save(newQuestion);	
	}
	public List<Question> findAllQuestions() {
		List<Question> all=(List<Question>) questionRepository.findAll();
		return all;
	}
	public Question findOne(Long questionId) {
		Question q=questionRepository.findOne(questionId);
		return q;
	}


}
