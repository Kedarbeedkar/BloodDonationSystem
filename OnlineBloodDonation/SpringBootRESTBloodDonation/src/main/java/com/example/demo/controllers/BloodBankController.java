package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.BloodBank;
import com.example.demo.services.BloodBankService;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class BloodBankController {

	@Autowired
	BloodBankService bservice;
	
	
	
	@GetMapping("/getallbloodbank")
	public List<BloodBank> getAll()
	{
		return bservice.getAll();
	}
}
