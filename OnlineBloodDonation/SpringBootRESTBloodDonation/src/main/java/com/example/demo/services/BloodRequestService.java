package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.BloodRequest;
import com.example.demo.entities.User;
import com.example.demo.repositories.BloodRequestRepositories;


@Service
public class BloodRequestService {

	@Autowired
	BloodRequestRepositories brrepo;
	
	public List<BloodRequest> getAll()
	{
		return brrepo.findAll();
	}
	
	public BloodRequest save(BloodRequest brt)
	{
		return brrepo.save(brt);
	}
	
	/*public boolean updaterequeststatus(int requestid ,String requeststatus)
	{
		System.out.println(requestid+": "+requeststatus);
		int n = brrepo.updaterequeststatus(requestid,requeststatus);
		if(n == 1)
			return true;
		else
			return false;
	}*/
	
	public void updaterequeststatus(int requestid ,String requeststatus )
	{
		brrepo.updaterequeststatus(requestid, requeststatus);
	}
}
