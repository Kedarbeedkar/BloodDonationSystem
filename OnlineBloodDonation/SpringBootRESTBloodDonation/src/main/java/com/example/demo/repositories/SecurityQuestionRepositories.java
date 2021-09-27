package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.SecurityQuestion;

public interface SecurityQuestionRepositories extends JpaRepository<SecurityQuestion, Integer> {

	@Query("select s from SecurityQuestion s where SecurityQuestionID = ?1")
	public List<SecurityQuestion> getById(SecurityQuestion squestionid);
}
