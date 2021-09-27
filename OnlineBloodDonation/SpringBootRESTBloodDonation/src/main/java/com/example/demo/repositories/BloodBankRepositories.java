package com.example.demo.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.BloodBank;
import com.example.demo.entities.User;
@Repository
@Transactional
public interface BloodBankRepositories extends JpaRepository<BloodBank, Integer> {
	
	@Query("select b from BloodBank b where uid = :u")
	public BloodBank getBloodBank(User u);

}
