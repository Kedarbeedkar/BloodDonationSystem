package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.BloodStock;
import com.example.demo.repositories.BloodStockRepositories;



@Service
public class BloodStockService {

	@Autowired
	BloodStockRepositories bsrepo;
	
	public List<BloodStock> getAll()
	{
		return bsrepo.findAll();
	}
	
	public BloodStock save(BloodStock bst)
	{
		return bsrepo.save(bst);
	}
}
