package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.BloodGroup;
import com.example.demo.services.BloodGroupService;



@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class BloodGroupController {

	@Autowired
	BloodGroupService bgservice;
	
	/*@GetMapping("/getid")
	public List<BloodGroup> getById(@RequestBody BloodGroup bloodgroupid)
	{
		return bgservice.getById(bloodgroupid)
	}*/
}
