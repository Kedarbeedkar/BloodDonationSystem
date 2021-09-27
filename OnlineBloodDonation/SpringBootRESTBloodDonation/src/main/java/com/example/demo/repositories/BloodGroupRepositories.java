package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.BloodGroup;

@Repository
public interface BloodGroupRepositories extends JpaRepository<BloodGroup, Integer> {

	/*@Query("select b from BloodGroup b where BloodGroupID = ?1")
	public List<BloodGroup> getById(int bloodgroupid); */
}
