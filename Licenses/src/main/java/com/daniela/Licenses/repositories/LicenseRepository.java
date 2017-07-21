package com.daniela.Licenses.repositories;

import org.springframework.data.repository.CrudRepository;

import com.daniela.Licenses.models.License;

public interface LicenseRepository extends CrudRepository<License, Long> {

}
