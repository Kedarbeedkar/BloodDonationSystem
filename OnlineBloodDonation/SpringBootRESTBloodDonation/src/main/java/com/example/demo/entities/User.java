package com.example.demo.entities;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int uid;
	@Column
	int  rollid;
	
	@Column
	String emailid;
	
	@Column
	String password;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="SQUESTIONID")
	SecurityQuestion  squestionid;

	@Column
	String answer;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int rollid, String emailid, String password, SecurityQuestion squestionid, String answer) {
		super();
		this.rollid = rollid;
		this.emailid = emailid;
		this.password = password;
		this.squestionid = squestionid;
		this.answer = answer;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getRollid() {
		return rollid;
	}

	public void setRollid(int rollid) {
		this.rollid = rollid;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public SecurityQuestion getSquestionid() {
		return squestionid;
	}

	public void setSquestionid(SecurityQuestion squestionid) {
		this.squestionid = squestionid;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", rollid=" + rollid + ", emailid=" + emailid + ", password=" + password
				+ ", squestionid=" + squestionid + ", answer=" + answer + "]";
	}

	
	
}
