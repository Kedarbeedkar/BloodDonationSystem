package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="security_question")
public class SecurityQuestion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int squestionid;
	
	@Column
	String security_question;

	public SecurityQuestion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SecurityQuestion(int squestionid, String security_question) {
		super();
		this.squestionid = squestionid;
		this.security_question = security_question;
	}

	public int getSquestionid() {
		return squestionid;
	}

	public void setSquestionid(int squestionid) {
		this.squestionid = squestionid;
	}

	public String getSecurity_question() {
		return security_question;
	}

	public void setSecurity_question(String security_question) {
		this.security_question = security_question;
	}

	@Override
	public String toString() {
		return "SecurityQuestion [squestionid=" + squestionid + ", security_question=" + security_question + "]";
	}

	
	
}
