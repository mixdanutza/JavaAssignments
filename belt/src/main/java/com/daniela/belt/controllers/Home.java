package com.daniela.belt.controllers;



import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.daniela.belt.models.Ring;
import com.daniela.belt.models.Role;
import com.daniela.belt.models.User;
import com.daniela.belt.services.RingService;
import com.daniela.belt.services.UserService;
import com.daniela.belt.validator.UserValidator;

@Controller
public class Home {
	private UserService userService;
	private UserValidator userValidator;
	private RingService ringService;
	public Home(UserService userService, UserValidator userValidator, RingService ringService) {
		this.userService=userService;
		this.userValidator=userValidator;
		this.ringService=ringService;
	}
	
    @RequestMapping("/")
    public String home(Principal principal, Model model) {
    	String username=principal.getName();    	
    	User currentUser=userService.findByUsername(username);
    	
    	if(currentUser!=null) {
    		model.addAttribute("currentUser", currentUser);
    		List<Role> currentUserRoles=currentUser.getRoles();
    		boolean checkAdmin=false;
    		for(Role role: currentUserRoles) {
    			System.out.println("USERS ROLES "+role.getName());
    			if(role.getName().equals("ROLE_ADMIN")) {
    				checkAdmin=true;
    			}
    		}    		
    		model.addAttribute("checkAdmin", checkAdmin);
    		
    		//Get all rings
    		List<Ring> allRings=ringService.findAll();
    		model.addAttribute("allRings", allRings);
    		
    		//Get one users rings
    		List<Ring> myRings=currentUser.getRings();
    		System.out.println("My Rings "+myRings);
    		model.addAttribute("myRings", myRings);
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
	
	//Add ring to the user
	@PostMapping("/addRing")
	private String addRing(RedirectAttributes redirectAttributes, @ModelAttribute("ringId") Long ringId, Model model, Principal principal) {
		String username=principal.getName();    	
    	User currentUser=userService.findByUsername(username);
    	System.out.println("User id: "+currentUser.getId() +" RingId: "+ringId);
    	if(currentUser!=null) {
    		userService.addRingToUser(currentUser.getId(), ringId);
    		System.out.println("Successfully adeed Ring!");
    		redirectAttributes.addFlashAttribute("success", "You  successfully added a Ring!");
    		return "redirect:/";	
    	}else{
    		return "redirect:/login";
    	}
	}
	
	//delete ring
	@PostMapping("/deleteRing")
	public String deleteRing(@ModelAttribute("ringId") Long ringId, Model model, Principal principal) {
		
		String username=principal.getName();    	
    	User currentUser=userService.findByUsername(username);
    	
		ringService.deleteRing(ringId, currentUser.getId());
		return "redirect:/";
	}
	



}
