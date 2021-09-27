package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.SecurityQuestion;
import com.example.demo.entities.User;
import com.example.demo.services.SecurityQuestionService;
import com.example.demo.services.UserService;



@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {

	@Autowired
	UserService uservice;
	
	@Autowired
	SecurityQuestionService sqservice;
	
	@GetMapping("/all")
	public List<User> getAll()
	{
		return uservice.getAll();
	}
	@PostMapping("/save")
	public User add(@RequestBody User ut)
	{
		return uservice.add(ut);
		
	}
	
	@PostMapping("/checklogin")
	public Object checkLogin(@RequestBody User ut)
	{
		System.out.println(ut.getEmailid()+": "+ut.getPassword());
		return uservice.checkLogin(ut.getEmailid(),ut.getPassword());
	}
	
	@PostMapping("/changepassword")
	public boolean changepassword(@RequestBody User cp)
	{
		
		System.out.println(cp.getEmailid()+":"+cp.getAnswer());
		return uservice.changepassword(cp.getEmailid(),cp.getAnswer(), cp.getPassword());
	}
}
