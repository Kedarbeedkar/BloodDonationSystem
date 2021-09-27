package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Hospital;
import com.example.demo.repositories.HospitalRepositories;



@Service
public class HospitalService {

	@Autowired
	HospitalRepositories hrepo;
	
	public List<Hospital> getAll()
	{
		return hrepo.findAll();
	}
	
	public Hospital add(Hospital ht)
	{
		return hrepo.save(ht);
	}
}
