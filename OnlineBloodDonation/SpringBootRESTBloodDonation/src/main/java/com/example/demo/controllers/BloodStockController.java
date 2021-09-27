package com.example.demo.controllers;



import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.BloodGroup;
import com.example.demo.entities.BloodStock;
import com.example.demo.entities.SecurityQuestion;
import com.example.demo.services.BloodGroupService;
import com.example.demo.services.BloodStockService;




@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class BloodStockController {

	@Autowired
	BloodStockService bsservice;
	
	@Autowired
	BloodGroupService bgservice;
	
	@GetMapping("/getallbloodstock")
	public List<BloodStock> getAll()
	{
		return bsservice.getAll();
	}
	
	@PostMapping("/savedonation")
	public BloodStock add(@RequestParam("bloodgroupid") int bloodgroupid, @RequestParam("quantity") double quantity)
	{
		BloodGroup bg =  bgservice.getById(bloodgroupid);
		java.util.Date date=new java.util.Date();
		java.sql.Date sqlDate=new java.sql.Date(date.getTime());
		BloodStock bst =  new BloodStock(bg,quantity,sqlDate);
		return bsservice.save(bst);
	}
}
