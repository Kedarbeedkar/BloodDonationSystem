package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.SecurityQuestion;
import com.example.demo.services.SecurityQuestionService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class SecurityQuestionController {

	@Autowired
	SecurityQuestionService sqservice;
	
	/*@GetMapping("/getone")
	public List<SecurityQuestion> getById(@RequestBody SecurityQuestion Squestionid)
	{
		return sqservice.getById(Squestionid);
	}*/
}
