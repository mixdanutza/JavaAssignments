package com.daniela.DojoOverflow.controllers;



import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.daniela.DojoOverflow.models.Question;
import com.daniela.DojoOverflow.models.Tag;
import com.daniela.DojoOverflow.services.QuestionService;
import com.daniela.DojoOverflow.services.TagService;

@Controller
public class Questions {
	private QuestionService questionService;
	private TagService tagService;
	public Questions(QuestionService questionService, TagService tagService) {
		this.questionService=questionService;
		this.tagService=tagService;
	}
	
	
	@GetMapping("/")
	public String homepage(Model model){
		//get all questions from DB
		List<Question> allQuestions=questionService.findAllQuestions();
		model.addAttribute("allQuestions", allQuestions);
		return "dashboard.jsp";
	}
	
	@GetMapping("/newQuestion")
	public String questionPage() {
		return "newQuestion.jsp";
	}
	
	@PostMapping("/addQuestion")
	public String addQuestion(@RequestParam("question") String question, @RequestParam("tag") String tag, Model model) {
		//Validate question string
		if(question.length()<3 || question.length()>50) {
			return "redirect:/newQuestion";
		}else {
			Question newQuestion=new Question(question);
			
			//Validate tag string
			if(tag.length()<3) {
				return "redirect:/newQuestion";
			}else {
				//Split the string to get each tag separated by comma
				String[] allTags=tag.split(",");
				//Check the list to have no more than 3 tags
				if(allTags.length>3) {
					return "redirect:/newQuestion";
				}else {
					//Create a new list to store all tags
					ArrayList<Tag> myTags=new ArrayList<>();
					//Look in the database if a tag already exists
					Tag checkTag;
					Tag addingTag;
					for(String t : allTags) {
						checkTag=tagService.findBySubject(t);
						//If this tag doesn't exist in the database create new instance of Tag Class
						if(checkTag==null) {
							Tag newTag=new Tag(t);
							tagService.saveTag(newTag);
							System.out.println("***ID**"+ newTag.getId());
							addingTag=tagService.findOne(newTag.getId());									
						}else {
							addingTag=checkTag;
						}
						
						myTags.add(addingTag);
					}
					
					newQuestion.setTags(myTags);	
				}
				questionService.addQuestion(newQuestion);			
			}
			return "redirect:/";	
		}
	}
	

}
