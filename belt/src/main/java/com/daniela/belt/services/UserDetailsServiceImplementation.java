package com.daniela.belt.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;

import com.daniela.belt.models.Role;
import com.daniela.belt.models.User;
import com.daniela.belt.repositories.UserRepository;

@Service
public class UserDetailsServiceImplementation implements UserDetailsService {
	private UserRepository userRepository;
	public UserDetailsServiceImplementation(UserRepository userRepository) {
		this.userRepository=userRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		User user=userRepository.findByUsername(username);
		if(user==null) {
			User userByEmail =userRepository.findByEmail(username);
			if(userByEmail==null) {	
				throw new UsernameNotFoundException("User not found");
			}else {
				return new org.springframework.security.core.userdetails.User(userByEmail.getUsername(), userByEmail.getPassword(), getAuthorities(userByEmail));
			}
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthorities(user));
	}
	
    private List<GrantedAuthority> getAuthorities(User user){
        List<GrantedAuthority> authorities = new ArrayList<>();
        for(Role role: user.getRoles()){
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getName());
            authorities.add(grantedAuthority);
        }
        return authorities;
    }
	
}
