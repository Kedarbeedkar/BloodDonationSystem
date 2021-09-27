package com.example.demo.repositories;



import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Donor;
import com.example.demo.entities.User;
@Repository
@Transactional
public interface DonorRepositories extends JpaRepository<Donor, Integer> {

	@Query ("select d from Donor d where uid= :ut")
	public Donor getDonor(User ut);
}
