package com.daniela.DojoOverflow.services;

import org.springframework.stereotype.Service;

import com.daniela.DojoOverflow.models.Answer;
import com.daniela.DojoOverflow.repositories.AnswerRepository;

@Service
public class AnswerService {
	private AnswerRepository answerRepository;
	public AnswerService(AnswerRepository answerRepository) {
		this.answerRepository=answerRepository;
	}
	public void addAnswer(Answer answer) {
		answerRepository.save(answer);		
	}
}
