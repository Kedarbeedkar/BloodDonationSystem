package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Donor;
import com.example.demo.repositories.DonorRepositories;



@Service
public class DonorService {

	@Autowired
	DonorRepositories drepo;
	
	public List<Donor> getAll()
	{
		return drepo.findAll();
	}
	
	public Donor add(Donor dt)
	{
		return drepo.save(dt);
	}
	
}
