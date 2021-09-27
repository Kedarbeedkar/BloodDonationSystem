package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bloodgroups")
public class BloodGroup {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int bloodgroupid;
	@Column
	String  bloodgroup;
	public BloodGroup() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BloodGroup(int bloodgroupid, String bloodgroup) {
		super();
		this.bloodgroupid = bloodgroupid;
		this.bloodgroup = bloodgroup;
	}
	public int getBloodgroupid() {
		return bloodgroupid;
	}
	public void setBloodgroupid(int bloodgroupid) {
		this.bloodgroupid = bloodgroupid;
	}
	public String getBloodgroup() {
		return bloodgroup;
	}
	public void setBloodgroup(String bloodgroup) {
		this.bloodgroup = bloodgroup;
	}
	@Override
	public String toString() {
		return "BloodGroup [bloodgroupid=" + bloodgroupid + ", bloodgroup=" + bloodgroup + "]";
	}
	
    
	
}
