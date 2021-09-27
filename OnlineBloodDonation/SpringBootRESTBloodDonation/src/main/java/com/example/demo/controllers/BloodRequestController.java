package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.BloodGroup;
import com.example.demo.entities.BloodRequest;
import com.example.demo.entities.User;
import com.example.demo.services.BloodGroupService;
import com.example.demo.services.BloodRequestService;
import com.example.demo.services.UserService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class BloodRequestController {
	
	@Autowired
	BloodRequestService brservice;
	
	@Autowired
	BloodGroupService bgservice;
	
	@Autowired
	UserService uservice;
	
	@GetMapping("/getallbloodrequest")
	public List<BloodRequest> getAll()
	{
		return brservice.getAll();
	}
	
	@PostMapping("/savebloodrequest")
	public BloodRequest add(@RequestParam("uid") int uid, @RequestParam("pname") String pname,@RequestParam("bloodgroupid") int bloodgroupid,
			@RequestParam("quantity") double quantity,@RequestParam("pcontactno") String pcontactno,@RequestParam("paddress") String paddress)
	{
		BloodGroup bg =  bgservice.getById(bloodgroupid);
		User u = uservice.getById(uid);
		java.util.Date date=new java.util.Date();
		java.sql.Date sqlDate=new java.sql.Date(date.getTime());
		BloodRequest brt =  new BloodRequest(u,pname,sqlDate,bg,quantity,pcontactno,paddress,"pending");
		return brservice.save(brt);
	}
	
	
	
	@PostMapping("/updaterequeststatus")
	public void updaterequeststatus(@RequestParam("requestid")int requestid,@RequestParam("requeststatus") String requeststatus)
	{
		brservice.updaterequeststatus(requestid, requeststatus);
	}
}
