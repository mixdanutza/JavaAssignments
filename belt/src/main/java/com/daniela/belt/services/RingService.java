package com.daniela.belt.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.daniela.belt.models.Ring;
import com.daniela.belt.models.User;
import com.daniela.belt.repositories.RingRepository;
import com.daniela.belt.repositories.UserRepository;

@Service
public class RingService {
	private RingRepository ringRepository;
	private UserRepository userRepository;
	
	public RingService(RingRepository ringRepository, UserRepository userRepository) {
		this.ringRepository=ringRepository;
		this.userRepository=userRepository;
	}

	public void addRing(Ring ring) {
		ringRepository.save(ring);	
	}

	public List<Ring> findAll() {
		return (List<Ring>) ringRepository.findByUserIsNull();
	}

	public List<Ring> getMyRings(Long userId) {
		return null;
	}

	public void deleteRing(Long ringId, Long userId) {
		Ring ring=ringRepository.findOne(ringId);
		ring.setUser(null);
		ringRepository.save(ring);
			
	}

}
