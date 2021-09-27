package com.example.demo.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.BloodBank;
import com.example.demo.entities.BloodGroup;
import com.example.demo.entities.Donor;
import com.example.demo.entities.Hospital;
import com.example.demo.entities.User;
import com.example.demo.repositories.BloodBankRepositories;
import com.example.demo.repositories.DonorRepositories;
import com.example.demo.repositories.HospitalRepositories;
import com.example.demo.repositories.UserRepositories;

@Service
public class UserService {

	@Autowired
	UserRepositories urepo;
	
	@Autowired
	DonorRepositories drepo;
	
	@Autowired
	HospitalRepositories hrepo;
	
	@Autowired
	BloodBankRepositories brepo;
	
	public List<User> getAll()
	{
		return urepo.findAll();
	}
	
	public User add(User ut)
	{
		return urepo.save(ut);
	}
	
	public User getById(int uid)
	{
		Optional<User> ou =  urepo.findById(uid);
		User u = null;
		try
		{
			u = ou.get();
		}
		catch(NoSuchElementException e)
		{
			e.printStackTrace();
			u = null;
		}
		return u;
	}
	
	public Object checkLogin(String emailid,String password)
	{
		System.out.println(emailid+": "+password+": ");
		List<Object[]> ut= urepo.checkLogin(emailid, password);
		System.out.println(ut.size());
		if(ut.size() == 1) 
		{
			System.out.println(ut.get(0) [0]+":"+ut.get(0) [1]);
			BloodBank b = null;
			Donor d = null;
			Hospital h = null;
			if((int)ut.get(0)[0] == 1)  //admin
			{
				Optional<User> ou = urepo.findById((int)ut.get(0)[1]);
				User u = ou.get();
				
				try
				{
					b = brepo.getBloodBank(u);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				return b;
			}
			else if((int)ut.get(0)[0] == 2) //donor
			{
				Optional<User> od = urepo.findById((int)ut.get(0) [1]);
				User u = od.get();
				try
				{
					d = drepo.getDonor(u);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				return d;
			}
			else if((int)ut.get(0)[0] == 3)  //hospital
			{
				Optional<User> od = urepo.findById((int)ut.get(0) [1]);
				User u = od.get();
				try
				{
					h = hrepo.getHospital(u);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				return h;
			}
			
		}
		else if (ut.size() == 1)
		{
			return null;
		}
		return ut;
		
	}
	
	public boolean changepassword(String emailid, String answer, String pwd)
	{
		System.out.println(emailid+": "+answer+": ");
		int n = urepo.getByEmailID(emailid, answer,  pwd);
		if(n == 1)
			return true;
		else
			return false;
	}
}
