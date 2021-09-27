package com.example.demo.services;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.BloodGroup;
import com.example.demo.repositories.BloodGroupRepositories;


@Service
public class BloodGroupService {

	@Autowired
	BloodGroupRepositories bgrepo;
	
	public BloodGroup getById(int bloodgroupid)
	{
		Optional<BloodGroup> ob =  bgrepo.findById(bloodgroupid);
		BloodGroup b = null;
		try
		{
			b = ob.get();
		}
		catch(NoSuchElementException e)
		{
			e.printStackTrace();
			b = null;
		}
		return b;
	}
}
