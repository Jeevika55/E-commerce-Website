package com.niit.SpectaclesBackend.Model;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component

public class Users {

	@Id
    private String usersId;
	private String usersName;
	private String usersAddress;
	private String usersPhoneNo;
	private String usersEmailId;
	private String usersPassword;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="authId")
	Authentication authentication;
	
	public Users()
	{
		this.usersId="USER"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="billId")
	private Billing billing;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cartId")
	private Cart cart;
	
	
	@OneToMany(mappedBy="users")
	private List<Shipping> shipping;
	
	
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public List<Shipping> getShipping() {
		return shipping;
	}
	public void setShipping(List<Shipping> shipping) {
		this.shipping = shipping;
	}
	public Billing getBilling() {
		return billing;
	}
	public void setBilling(Billing billing) {
		this.billing = billing;
	}
	
	
	public String getUsersId() {
		return usersId;
	}
	public void setUsersId(String usersId) {
		this.usersId = usersId;
	}
	public String getUsersName() {
		return usersName;
	}
	public void setUsersName(String usersName) {
		this.usersName = usersName;
	}
	public String getUsersAddress() {
		return usersAddress;
	}
	public void setUsersAddress(String usersAddress) {
		this.usersAddress = usersAddress;
	}
	public String getUsersPhoneNo() {
		return usersPhoneNo;
	}
	public void setUsersPhoneNo(String usersPhoneNo) {
		this.usersPhoneNo = usersPhoneNo;
	}
	public String getUsersEmailId() {
		return usersEmailId;
	}
	public void setUsersEmailId(String usersEmailId) {
		this.usersEmailId = usersEmailId;
	}
	public String getUsersPassword() {
		return usersPassword;
	}
	public void setUsersPassword(String usersPassword) {
		this.usersPassword = usersPassword;
	}
	public Authentication getAuthentication() {
		return authentication;
	}
	public void setAuthentication(Authentication authentication) {
		this.authentication = authentication;
	}
	
	
	
}
