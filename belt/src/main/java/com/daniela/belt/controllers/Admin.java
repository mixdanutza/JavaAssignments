package com.daniela.belt.controllers;

import java.security.Principal;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.daniela.belt.models.Ring;
import com.daniela.belt.models.Team;
import com.daniela.belt.models.User;
import com.daniela.belt.repositories.UserRepository;
import com.daniela.belt.services.RingService;
import com.daniela.belt.services.TeamService;
import com.daniela.belt.services.UserService;

@Controller
@RequestMapping("/admin")
public class Admin {
	private UserService userService;
	private RingService ringService;
	private TeamService teamService;
	public Admin(UserService userService, RingService ringService, TeamService teamService) {
		this.userService=userService;
		this.ringService=ringService;
		this.teamService=teamService;
	}
	
	
	//Display Ring Form Page
	@GetMapping("/ringCreator")
	public String ringPage(@ModelAttribute("ring") Ring ring, Model model, Principal principal, RedirectAttributes redirectAttributes) {
    	String username=principal.getName();
    	if(username==null) {
    		redirectAttributes.addFlashAttribute("error", "You dont have access to this page!");
			return "redirect:/dashboard";	
    	}
    	User admin=userService.findByUsername(username);	
    	model.addAttribute("admin",admin);
		return "ringPage.jsp";
	}
	
	//Create new Ring
	@PostMapping("/newRing")
	public String createRing(@Valid @ModelAttribute("ring") Ring ring, BindingResult result, Model model, RedirectAttributes redirectAttributes, @RequestParam(value="error", required=false) String error) {
		if(error !=null) {
			System.out.println("Error creating Ring");
			return "ringPage.jsp";
		}
		if(result.hasErrors()) {
			System.out.println("Error creating Ring");
			return "ringPage.jsp";
		}else {
			//save ring to DB
			ringService.addRing(ring);
			redirectAttributes.addFlashAttribute("success", "You successfully created a Ring!");
			return "redirect:/admin/ringCreator";		
		}
		
	}
	
	//Display foolPage
	@GetMapping("/foolCreator")
	public String foolPage(@ModelAttribute("team") Team team, Model model) {
		List<Object[]> all=userService.joinUsersAndTeams();
		model.addAttribute("all",all);
		
//		for(Object[] row : all) {
//	        User user = (User) row[0];
//	        Team tea = (Team) row[1];
//	        System.out.println(user.getUsername());
//	        System.out.println(tea.getName());
//		}
		
		List<User> allUsers= userService.findAllUsers();
		model.addAttribute("allUsers", allUsers);
		
		List<Team> allTeams=teamService.findAllteams();
		model.addAttribute("allTeams", allTeams);
		
		//Today's date
		model.addAttribute("today", new Date());
		return "foolPage.jsp";
	}
	
	
	//Create new Team
	@PostMapping("/newTeam")
	public String createTeam(@Valid @ModelAttribute("team") Team team, BindingResult result, Model model, RedirectAttributes redirectAttributes, @RequestParam(value="error", required=false) String error) {
		
		if(error !=null) {
			System.out.println("Error creating Team");
			return "ringPage.jsp";
		}
		if(result.hasErrors()) {
			System.out.println("Error creating Team");
			return "ringPage.jsp";
		}else {
			//save team to DB
			teamService.addTeam(team);
			redirectAttributes.addFlashAttribute("success", "You successfully created a Team!");
			return "redirect:/admin/foolCreator";		
		}
		
	}
	
	//Pair User with Team
	@PostMapping("/join")
	public String join(@ModelAttribute("userId") Long userId, @ModelAttribute("teamId") Long teamId, Model model, RedirectAttributes redirectAttributes) {
		Team team=teamService.findOne(teamId);
		List<User> users=team.getUsers();
		
		for(User u: users) {
			if(u.getId()==userId) {
				System.err.println("EXISTSSSSS");
				redirectAttributes.addFlashAttribute("error","You can't join the same team twice");
				return "redirect:/admin/foolCreator";
			}
		}

		teamService.joinTeam(userId, teamId);
		return "redirect:/admin/foolCreator";
	}
	
	//Display one Team Page
	@GetMapping("/showTeam/{id}")
	public String showTeamPage(@PathVariable("id") Long teamId, Model model) {
		Team team=teamService.findOne(teamId);
		//Today's date
		model.addAttribute("today", new Date());
		model.addAttribute("team", team);
		return "showTeamPage.jsp";
	}
	
	//Make user admin
	 @PostMapping("/makeAdmin/{id}")
	 public String makeUserAdmin(@PathVariable("id") Long userId, Model model) {	 
		 userService.makeUserAdmin(userId);	 
		 return "redirect:/admin/foolCreator";
	 }
	 
	 //Destroy join/ connection
	 @PostMapping("/deleteJoin")
	 public String destroyConnection(@ModelAttribute("userId") Long userId, @ModelAttribute("teamId") Long teamId, Model model) {
		 teamService.destroyConnection(userId, teamId);
		 return "redirect:/admin/foolCreator";
	 }
	 
	 //Display Update User Page
	 @GetMapping("/updateUser/{id}")
	 public String editUser(@PathVariable("id") Long userId, Model model) {
		 model.addAttribute("userId", userId);
		 return "updatePage.jsp";
	 }
	 
	 //Update User POST 
	 @PostMapping("/update/{id}")
	 public String updateUser(@PathVariable("id") Long userId, @ModelAttribute("username") String username) {
		 User user = userService.getUserById(userId);
		 user.setUsername(username);
		 userService.updateUser(user);
		 return "redirect:/admin/foolCreator";
	 }

}
