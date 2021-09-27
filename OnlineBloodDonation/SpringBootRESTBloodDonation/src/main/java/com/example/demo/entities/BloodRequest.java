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
@Table(name="blood_request")
public class BloodRequest {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int requestid;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="UID")
	User uid;
	
	@Column
	String pname;
	
	@JsonFormat(pattern = "yyyy-mm-dd")
	@Column
	Date request_date;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="BLOODGROUPID")
	BloodGroup bloodgroupid;
	
	@Column
	double quantity;
	
	@Column
	String pcontactno;
	
	@Column
	String paddress;
	
	@Column
	String requeststatus;

	public BloodRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public BloodRequest(User uid, String pname, Date request_date, BloodGroup bloodgroupid, double quantity,
			String pcontactno, String paddress, String requeststatus) {
		super();
		this.uid = uid;
		this.pname = pname;
		this.request_date = request_date;
		this.bloodgroupid = bloodgroupid;
		this.quantity = quantity;
		this.pcontactno = pcontactno;
		this.paddress = paddress;
		this.requeststatus = requeststatus;
	}



	public int getRequestid() {
		return requestid;
	}

	public void setRequestid(int requestid) {
		this.requestid = requestid;
	}

	public User getUid() {
		return uid;
	}

	public void setUid(User uid) {
		this.uid = uid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Date getRequest_date() {
		return request_date;
	}

	public void setRequest_date(Date request_date) {
		this.request_date = request_date;
	}

	public BloodGroup getBloodgroupid() {
		return bloodgroupid;
	}

	public void setBloodgroupid(BloodGroup bloodgroupid) {
		this.bloodgroupid = bloodgroupid;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public String getPcontactno() {
		return pcontactno;
	}

	public void setPcontactno(String pcontactno) {
		this.pcontactno = pcontactno;
	}

	public String getPaddress() {
		return paddress;
	}

	public void setPaddress(String paddress) {
		this.paddress = paddress;
	}

	public String getRequeststatus() {
		return requeststatus;
	}

	public void setRequeststatus(String requeststatus) {
		this.requeststatus = requeststatus;
	}

	@Override
	public String toString() {
		return "BloodRequest [requestid=" + requestid + ", uid=" + uid + ", pname=" + pname + ", request_date="
				+ request_date + ", bloodgroupid=" + bloodgroupid + ", quantity=" + quantity + ", pcontactno="
				+ pcontactno + ", paddress=" + paddress + ", requeststatus=" + requeststatus + "]";
	}

	
	
	
	
}
