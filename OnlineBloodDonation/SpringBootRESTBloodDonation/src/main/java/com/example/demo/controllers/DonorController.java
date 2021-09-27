package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.DonorRegistartion;
import com.example.demo.entities.SecurityQuestion;
import com.example.demo.entities.User;
import com.example.demo.repositories.BloodGroupRepositories;
import com.example.demo.repositories.SecurityQuestionRepositories;
import com.example.demo.entities.BloodGroup;
import com.example.demo.entities.Donor;
import com.example.demo.services.BloodGroupService;
import com.example.demo.services.DonorService;
import com.example.demo.services.SecurityQuestionService;
import com.example.demo.services.UserService;




@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class DonorController {

	@Autowired
	DonorService dservice;
	
	@Autowired
	SecurityQuestionService sqservice;
	
	@Autowired
	BloodGroupService bgservice;
	
	@Autowired
	UserService uservice;
	
	@GetMapping("/getdonorall")
	public List<Donor> getAll()
	{
		return dservice.getAll();
	}
	
	@PostMapping("/donerregistartion")
	public Donor registerDoner(@RequestBody DonorRegistartion dr)
	{
		System.out.println(dr.getSquestionid());
		SecurityQuestion sq =  sqservice.getById(dr.getSquestionid());
		System.out.println(sq.getSquestionid()+": "+ sq.getSecurity_question());
		User u = new User(2,dr.getEmailid(),dr.getPassword(),sq,dr.getAnswer());
	    User insertUser = uservice.add(u);
		BloodGroup bg =  bgservice.getById(dr.getBloodgroupid());
		System.out.println(dr.getAddress());
		Donor d = new Donor(insertUser,dr.getName(),dr.getGender(),dr.getDob(),bg,dr.getContactno(),dr.getAddress(),dr.getCity());
		return dservice.add(d);
	}
	
}
