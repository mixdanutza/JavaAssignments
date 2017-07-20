package com.daniela.Lookify.controllers;


import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.daniela.Lookify.models.Song;
import com.daniela.Lookify.services.SongService;

@Controller
public class Home {
	private final SongService songService;
	public Home(SongService songService) {
		this.songService=songService;
	}
	
	@GetMapping("/")
	public String home() {
		return "welcome.jsp";
	}
	
	@GetMapping("/dashboard")
	public String dash(Model model) {
		List<Song> songs= songService.allSongs();
		model.addAttribute("songs", songs);
		return "dashboard.jsp";
	}
	
	@GetMapping("/addNew")
	public String add(@ModelAttribute("song") Song song) {
		
		return "addsong.jsp";		
	}
	
	
	@PostMapping("/addSong")
	public String addNew(@Valid @ModelAttribute("song") Song song, BindingResult result) {
		
		System.out.println("*****ADDING");
		System.out.println(song.getRating());
		songService.addSong(song);
		return "redirect:/dashboard";
	}
}
