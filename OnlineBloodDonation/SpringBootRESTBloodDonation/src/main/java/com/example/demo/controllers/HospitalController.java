package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



import com.example.demo.entities.Hospital;
import com.example.demo.entities.HospitalRegistartion;
import com.example.demo.entities.SecurityQuestion;
import com.example.demo.entities.User;
import com.example.demo.services.HospitalService;
import com.example.demo.services.SecurityQuestionService;
import com.example.demo.services.UserService;



@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class HospitalController {

	@Autowired
	HospitalService hservice;
	
	@Autowired
	UserService uservice;
	
	@Autowired
	SecurityQuestionService sqservice;
	
	@GetMapping("/getallhospital")
	public List<Hospital> getAll()
	{
		return hservice.getAll();
	}
	
	
	@PostMapping("/hospitalregistartion")
	public Hospital registerHospital(@RequestBody HospitalRegistartion hr)
	{
		SecurityQuestion sq =  sqservice.getById(hr.getSquestionid());
		User u = new User(3,hr.getEmailid(),hr.getPassword(),sq,hr.getAnswer());
		User insertUser = uservice.add(u);
		Hospital h = new Hospital(insertUser,hr.getName(),hr.getAddress(),hr.getCity(),hr.getContactno());
		return hservice.add(h);
	}
}
