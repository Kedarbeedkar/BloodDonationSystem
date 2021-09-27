package com.example.demo.entities;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="donor")
public class Donor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int donorid;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="UID")
	User uid;
	
	@Column
	String name;
	
	@Column
	char gender;
	
	@JsonFormat(pattern = "yyyy-mm-dd")
	@Column
	Date dob;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="BLOODGROUPID")
	BloodGroup bloodgroupid;
	
	@Column
	String contactno;
	
	
	@Column
	String address;
	
	@Column
	String city;

	public Donor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Donor(User uid, String name, char gender, Date dob, BloodGroup bloodgroupid, String contactno,
			 String address, String city) {
		super();
		this.uid = uid;
		this.name = name;
		this.gender = gender;
		this.dob = dob;
		this.bloodgroupid = bloodgroupid;
		this.contactno = contactno;
		this.address = address;
		this.city = city;
	}

	
	public int getDonorid() {
		return donorid;
	}

	public void setDonorid(int donorid) {
		this.donorid = donorid;
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

	public BloodGroup getBloodgroupid() {
		return bloodgroupid;
	}

	public void setBloodgroupid(BloodGroup bloodgroupid) {
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

	@Override
	public String toString() {
		return "Doner [uid=" + uid + ", name=" + name + ", gender=" + gender + ", dob=" + dob + ", bloodgroupid="
				+ bloodgroupid + ", contactno=" + contactno + ", address=" + address
				+ ", city=" + city + "]";
	}

	
	
	
	
	
	

	
	
}
