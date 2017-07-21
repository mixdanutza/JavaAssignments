package com.daniela.Licenses.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.daniela.Licenses.models.License;
import com.daniela.Licenses.repositories.LicenseRepository;
@Service
public class LicenseService {
	
	private LicenseRepository licenseRepository;
	public LicenseService(LicenseRepository licenseRepository) {
		this.licenseRepository=licenseRepository;
	}
	
	public List<License> getLicenses(){
		return (List<License>) licenseRepository.findAll();
	}
	
	public void addLicense(License license) {
		licenseRepository.save(license);
		License lastlicense = licenseRepository.findOne(license.getId());
		lastlicense.setNumber(String.format("%06d", license.getId()));
		licenseRepository.save(lastlicense);
	}

}
