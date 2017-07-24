package com.daniela.DojoOverflow.controllers;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.daniela.DojoOverflow.models.Answer;
import com.daniela.DojoOverflow.models.Question;
import com.daniela.DojoOverflow.services.AnswerService;
import com.daniela.DojoOverflow.services.QuestionService;

@Controller
@RequestMapping("/answers")
public class Answers {
	private AnswerService answerService;
	private QuestionService questionService;
	public Answers(AnswerService answerService, QuestionService questionService) {
		this.answerService=answerService;
		this.questionService=questionService;
	}
	@GetMapping("/{id}")
	public String infoPage(@PathVariable("id") Long questionId, Model model, @ModelAttribute("answerObject") Answer answerObject) {
		Question oneQuestion=questionService.findOne(questionId);
		model.addAttribute("oneQuestion", oneQuestion);
		return "oneQuestion.jsp";
	}
	@PostMapping("/new")
	public String createAnswer(@Valid @ModelAttribute("answerObject") Answer answerObject, BindingResult result) {
		//Check for validation errors
		if(result.hasErrors()) {
			System.out.println("ERRORS");
			return "redirect:/answers/"+answerObject.getQuestion().getId();
		}
		answerService.addAnswer(answerObject);
		return "redirect:/answers/"+answerObject.getQuestion().getId();
	}

}
