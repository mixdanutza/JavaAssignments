package com.daniela.LoginRegistration.controllers;



import java.security.Principal;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.daniela.LoginRegistration.models.User;
import com.daniela.LoginRegistration.services.UserService;
import com.daniela.LoginRegistration.validator.UserValidator;

@Controller
public class Home {
	private UserService userService;
	private UserValidator userValidator;
	public Home(UserService userService, UserValidator userValidator) {
		this.userService=userService;
		this.userValidator=userValidator;
	}
	
    @RequestMapping("/")
    public String home(Principal principal, Model model) {
    	//1
    	String username=principal.getName();
    	User currentUser=userService.findByUsername(username);
    	if(currentUser!=null) {
    		model.addAttribute("currentUser", currentUser);
    		return "dashboard.jsp";	
    	}else {
    		return "redirect:/login";
    	}
    }
	
	@RequestMapping("/login")
	public String login(@Valid @ModelAttribute("user") User user, @RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout, BindingResult result, HttpSession session, Model model) {
		System.out.println("LOGIN");
		if(error !=null) {
			model.addAttribute("errorMessage", "Invalid credeantials!");
		}
		if(logout != null) {
			model.addAttribute("logoutMessage", "Successful logout!");
		}
		return "registrationPage.jsp";
	}
	
	@PostMapping("/registration")
	public String registerForm(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, HttpSession session) {
        userValidator.validate(user, result);
        if(result.hasErrors()){
        	System.out.println("ERRRRRRRRRRORRRRS");
            return "registrationPage.jsp";
        }
        //check if admin exists
        if(userService.isAdmin()==true) {
        	userService.saveWithUserRole(user);     	
        }else {
        	userService.saveUserWithAdminRole(user);
        }
        return "redirect:/login";
		
	}
	



}
