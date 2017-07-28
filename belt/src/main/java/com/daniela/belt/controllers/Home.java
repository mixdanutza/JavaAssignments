package com.daniela.belt.controllers;



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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.daniela.belt.models.User;
import com.daniela.belt.services.UserService;
import com.daniela.belt.validator.UserValidator;

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
	public String login( @ModelAttribute("success") String success,@Valid @ModelAttribute("user") User user, @RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout, BindingResult result, HttpSession session, Model model) {
		System.out.println("LOGIN");
		if(error !=null) {
			model.addAttribute("errorMessage", "Invalid credeantials!");
			return "loginReg.jsp";
		}
		if(logout != null) {
			model.addAttribute("logoutMessage", "Successful logout!");
			return "loginReg.jsp";
		}
		return "loginReg.jsp";
	}
	
	@PostMapping("/registration")
	public String registerForm(RedirectAttributes redirectAttributes, @Valid @ModelAttribute("user") User user, BindingResult result, Model model, HttpSession session) {
        userValidator.validate(user, result);
        if(result.hasErrors()){
            return "loginReg.jsp";
        }
        //check if admin exists
        if(userService.isAdmin()==true) {
        	userService.saveWithUserRole(user);     	
        }else {
        	userService.saveUserWithAdminRole(user);
        }
        redirectAttributes.addFlashAttribute("success", "You are successfully registered, please login!");
        return "redirect:/login";
		
	}
	



}
