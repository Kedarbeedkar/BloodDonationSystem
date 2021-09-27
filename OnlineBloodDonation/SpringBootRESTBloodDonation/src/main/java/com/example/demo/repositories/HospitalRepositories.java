package com.example.demo.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Hospital;
import com.example.demo.entities.User;

@Repository
@Transactional
public interface HospitalRepositories extends JpaRepository<Hospital, Integer> {

	@Query("select h from Hospital h where uid = :u")
	public Hospital getHospital(User u);
}
