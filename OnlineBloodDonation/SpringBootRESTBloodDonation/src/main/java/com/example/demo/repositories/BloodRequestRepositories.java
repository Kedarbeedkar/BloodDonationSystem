package com.example.demo.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.BloodRequest;

@Repository
@Transactional
public interface BloodRequestRepositories extends JpaRepository<BloodRequest, Integer> {

	/*@Modifying
	@Query(value="update blood_request set requeststatus = : requeststatus where requestid = :requestid",nativeQuery = true)
	public int updaterequeststatus(int requestid ,String requeststatus);*/
	
	@Modifying 
	@Query(value="update blood_request set requeststatus = ?2 where requestid = ?1",nativeQuery = true)
	public void updaterequeststatus(int requestid ,String requeststatus);
}
