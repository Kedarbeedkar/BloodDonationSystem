package com.example.demo.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.SecurityQuestion;
import com.example.demo.repositories.SecurityQuestionRepositories;

@Service
public class SecurityQuestionService {

	@Autowired
	SecurityQuestionRepositories sqrepo;
	
	public SecurityQuestion getById(int squestionid)
	{
		Optional<SecurityQuestion> os= sqrepo.findById(squestionid);
		SecurityQuestion sq = null;
		try
		{
			sq = os.get();
		}
		catch(NoSuchElementException e)
		{
			e.printStackTrace();
			sq = null;
		}
		return sq;
	}
}
