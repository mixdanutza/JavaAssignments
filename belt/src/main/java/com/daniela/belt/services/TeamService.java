package com.daniela.belt.services;

import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;


import com.daniela.belt.models.Team;
import com.daniela.belt.models.User;
import com.daniela.belt.repositories.TeamRepository;
import com.daniela.belt.repositories.UserRepository;

@Service
public class TeamService {
	private TeamRepository teamRepository;
	private UserRepository userRepository;
	
	public TeamService(TeamRepository teamRepository, UserRepository userRepository) {
		this.teamRepository=teamRepository;
		this.userRepository=userRepository;
	}

	public void addTeam(Team team) {
		teamRepository.save(team);	
	}

	public List<Team> findAllteams() {
		return (List<Team>) teamRepository.findAll();
	}

	public void joinTeam(Long userId, Long teamId) {
		Team team= teamRepository.findOne(teamId);
		User user=userRepository.findOne(userId);
		List<User> users=team.getUsers();
		users.add(user);
		team.setUsers(users);
		teamRepository.save(team);	
	}

	public Team findOne(Long teamId) {
		return teamRepository.findOne(teamId);
	}

	public void destroyConnection(Long userId, Long teamId) {
		 Team team=teamRepository.findOne(teamId);
		 List<User> usersInTeam=team.getUsers();
		 for (Iterator<User> iterator = usersInTeam.iterator(); iterator.hasNext(); ) {
			    User value = iterator.next();
			    if (value.getId()==userId) {
			        iterator.remove();
			    }
			}
		 
		 team.setUsers(usersInTeam);
		 teamRepository.save(team);
	}

}
