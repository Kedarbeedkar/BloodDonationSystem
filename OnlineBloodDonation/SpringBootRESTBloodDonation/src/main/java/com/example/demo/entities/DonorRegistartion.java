package com.example.demo.entities;

import java.sql.Date;



public class DonorRegistartion {

	int  rollid;
	String emailid;
	String password;
	int  squestionid;
	String answer;
	
	User uid;
	String name;
	char gender;
	Date dob;
    int bloodgroupid;
	String contactno;
    String address;
    String city;
	public DonorRegistartion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DonorRegistartion(int rollid, String loginid, String password, int squestionid, String answer,
			User uid, String name, char gender, Date dob, int bloodgroupid, String contactno, String emailid,
			String address, String city) {
		super();
		this.rollid = rollid;
		this.emailid = emailid;
		this.password = password;
		this.squestionid = squestionid;
		this.answer = answer;
		this.uid = uid;
		this.name = name;
		this.gender = gender;
		this.dob = dob;
		this.bloodgroupid = bloodgroupid;
		this.contactno = contactno;
		this.address = address;
		this.city = city;
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
	public int getSquestionid() {
		return squestionid;
	}
	public void setSquestionid(int squestionid) {
		this.squestionid = squestionid;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public User getUid() {
		return uid;
	}
	public void setUid(User uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public int getBloodgroupid() {
		return bloodgroupid;
	}
	public void setBloodgroupid(int bloodgroupid) {
		this.bloodgroupid = bloodgroupid;
	}
	public String getContactno() {
		return contactno;
	}
	public void setContactno(String contactno) {
		this.contactno = contactno;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
     
}
