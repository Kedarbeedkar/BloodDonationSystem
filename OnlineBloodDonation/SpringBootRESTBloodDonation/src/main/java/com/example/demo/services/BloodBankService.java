package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.BloodBank;
import com.example.demo.repositories.BloodBankRepositories;



@Service
public class BloodBankService {

	@Autowired
	BloodBankRepositories brepo;
	
	public List<BloodBank> getAll()
	{
		return brepo.findAll();
	}
	
	public BloodBank add(BloodBank bt)
	{
		return brepo.save(bt);
	}
}
