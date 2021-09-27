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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="blood_stock")
public class BloodStock {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int stockid;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="BLOODGROUPID")
	BloodGroup bloodgroupid;
	
	@Column
	double quantity;
	
	@JsonFormat(pattern = "yyyy-mm-dd")
	@Column
	Date donation_date;

	public BloodStock() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BloodStock(BloodGroup bloodgroupid, double quantity, Date donation_date) {
		super();
		this.bloodgroupid = bloodgroupid;
		this.quantity = quantity;
		this.donation_date = donation_date;
	}

	public int getStockid() {
		return stockid;
	}

	public void setStockid(int stockid) {
		this.stockid = stockid;
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

	public Date getDonation_date() {
		return donation_date;
	}

	public void setDonation_date(Date donation_date) {
		this.donation_date = donation_date;
	}

	@Override
	public String toString() {
		return "BloodStock [stockid=" + stockid + ", bloodgroupid=" + bloodgroupid + ", quantity=" + quantity
				+ ", donation_date=" + donation_date + "]";
	}

	
	
}
