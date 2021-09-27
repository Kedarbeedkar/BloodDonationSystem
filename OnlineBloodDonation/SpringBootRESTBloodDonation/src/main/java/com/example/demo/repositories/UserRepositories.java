package com.example.demo.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.example.demo.entities.User;

@Repository
@Transactional
public interface UserRepositories extends JpaRepository<User, Integer> {

	@Query("select ut.rollid,ut.uid from User ut where emailid =?1 and password =?2")
	//@Query(value="select rollid,emailid from blooddonationdb.user where emailid = ?1 and password = ?2",nativeQuery = true)
	public List<Object[]> checkLogin(String emailid,String password);
	
	@Modifying
	@Query(value="update user set password = :pwd where emailid = :emailid and  answer = :answer",nativeQuery = true)
	public int getByEmailID(String emailid,String answer,String pwd);
}
