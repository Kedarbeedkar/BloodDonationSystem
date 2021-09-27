package com.example.demo.entities;



public class HospitalRegistartion {

	int  rollid;
	String emailid;
	String password;
	int  squestionid;
	String answer;
	
	User uid;
	String name;
	String address;
    String city;
	String contactno;
    
	public HospitalRegistartion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HospitalRegistartion(int rollid, String emailid, String password, int squestionid, String answer, User uid,
			String name, String address, String city, String contactno) {
		super();
		this.rollid = rollid;
		this.emailid = emailid;
		this.password = password;
		this.squestionid = squestionid;
		this.answer = answer;
		this.uid = uid;
		this.name = name;
		this.address = address;
		this.city = city;
		this.contactno = contactno;
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
		return "HospitalRegistartion [rollid=" + rollid + ", emailid=" + emailid + ", password=" + password
				+ ", squestionid=" + squestionid + ", answer=" + answer + ", uid=" + uid + ", name=" + name
				+ ", address=" + address + ", city=" + city + ", contactno=" + contactno + "]";
	}

	
    
    
}
