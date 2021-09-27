package com.example.demo.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="hospital")
public class Hospital {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int hospitalid;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="UID")
	User uid;
	
	@Column
	String name;
	
	@Column
	String address;
	
	@Column
	String city;
	
	
	@Column
	String contactno;

	public Hospital() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Hospital(User uid, String name, String address, String city, String contactno) {
		super();
		this.uid = uid;
		this.name = name;
		this.address = address;
		this.city = city;
		this.contactno = contactno;
	}

	public int getHospitalid() {
		return hospitalid;
	}

	public void setHospitalid(int hospitalid) {
		this.hospitalid = hospitalid;
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


	public String getContactno() {
		return contactno;
	}

	public void setContactno(String contactno) {
		this.contactno = contactno;
	}

	@Override
	public String toString() {
		return "Hospital [uid=" + uid + ", name=" + name + ", address=" + address + ", city=" + city + ", contactno=" + contactno + "]";
	}

}
