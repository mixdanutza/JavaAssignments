package com.daniela.DojosAndNinjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.daniela.DojosAndNinjas.models.Dojo;
import com.daniela.DojosAndNinjas.repositories.DojoReository;

@Service
public class DojoService {
	private DojoReository dojoReository;
	public DojoService(DojoReository dojoReository) {
		this.dojoReository=dojoReository;
	}
	
	public List<Dojo> findAll(){
		return (List<Dojo>) dojoReository.findAll();
	}
	
	public void addDojo(Dojo dojo) {
		dojoReository.save(dojo);
	}

	public Dojo findOneById(int i) {
		return  dojoReository.findOne((long) i);
	}

}
