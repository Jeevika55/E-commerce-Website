package com.niit.SpectaclesBackend.Model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Shipping {
	@Id
	private String shipId;
	private String shipName;
	private String shipCity;
	private String shipState;
	private String shipPhoneNo;
	private String shipAddress;
	private String shipZipCode;
	private String shipCountry;
	
	@ManyToOne
	@JoinColumn(name="usersId")
	private Users users;
	
	public Shipping()
	{
		this.shipId="SHIPPING"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public String getShipId() {
		return shipId;
	}
	public void setShipId(String shipId) {
		this.shipId = shipId;
	}
	public String getShipName() {
		return shipName;
	}
	public void setShipName(String shipName) {
		this.shipName = shipName;
	}
	public String getShipCity() {
		return shipCity;
	}
	public void setShipCity(String shipCity) {
		this.shipCity = shipCity;
	}
	public String getShipState() {
		return shipState;
	}
	public void setShipState(String shipState) {
		this.shipState = shipState;
	}
	public String getShipPhoneNo() {
		return shipPhoneNo;
	}
	public void setShipPhoneNo(String shipPhoneNo) {
		this.shipPhoneNo = shipPhoneNo;
	}
	public String getShipAddress() {
		return shipAddress;
	}
	public void setShipAddress(String shipAddress) {
		this.shipAddress = shipAddress;
	}
	public String getShipZipCode() {
		return shipZipCode;
	}
	public void setShipZipCode(String shipZipCode) {
		this.shipZipCode = shipZipCode;
	}
	public String getShipCountry() {
		return shipCountry;
	}
	public void setShipCountry(String shipCountry) {
		this.shipCountry = shipCountry;
	}
	
	

}
