package com.niit.SpectaclesBackend.Model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component

public class Billing {
	
	@Id
	private String billId;
	private String billName;
	private String billCity;
	private String billState;
	private String billAddress;
	private String billPhoneNo;
	private String billZipCode;
	private String billCountry;
	
	
	@OneToOne
	@JoinColumn(name="usersId")
	private Users users;
	
	public Billing()
	{
		this.billId="Billing"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	
	public String getBillZipCode() {
		return billZipCode;
	}
	public void setBillZipCode(String billZipCode) {
		this.billZipCode = billZipCode;
	}
	public String getBillCountry() {
		return billCountry;
	}
	public void setBillCountry(String billCountry) {
		this.billCountry = billCountry;
	}
	public String getBillId() {
		return billId;
	}
	public void setBillId(String billId) {
		this.billId = billId;
	}
	public String getBillName() {
		return billName;
	}
	public void setBillName(String billName) {
		this.billName = billName;
	}
	public String getBillAddress() {
		return billAddress;
	}
	public void setBillAddress(String billAddress) {
		this.billAddress = billAddress;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public String getBillCity() {
		return billCity;
	}
	public void setBillCity(String billCity) {
		this.billCity = billCity;
	}
	public String getBillState() {
		return billState;
	}
	public void setBillState(String billState) {
		this.billState = billState;
	}
	public String getBillPhoneNo() {
		return billPhoneNo;
	}
	public void setBillPhoneNo(String billPhoneNo) {
		this.billPhoneNo = billPhoneNo;
	}

}
