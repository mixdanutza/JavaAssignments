package com.daniela.DojosAndNinjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.daniela.DojosAndNinjas.models.Ninja;
import com.daniela.DojosAndNinjas.repositories.NinjaReository;

@Service
public class NinjaService {
	
	private NinjaReository ninjaReository;
	public NinjaService(NinjaReository ninjaReository) {
		this.ninjaReository=ninjaReository;
	}
	
	public List<Ninja> allNinjas(){
		return (List<Ninja>) ninjaReository.findAll();
	}
	public void addNinja(Ninja ninja) {
		ninjaReository.save(ninja);
	}



}
