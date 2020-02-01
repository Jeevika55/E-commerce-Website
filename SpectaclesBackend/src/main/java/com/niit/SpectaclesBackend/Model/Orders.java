package com.niit.SpectaclesBackend.Model;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Orders {

	@Id
	private String orderId;
	private Double grandTotal;
	
	public Orders()
	{
		this.orderId="ORDERS"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	
	@OneToOne
	@JoinColumn(name="billId")
	private Billing billing;
	
	@OneToOne
	@JoinColumn(name="shipId")
	private Shipping shipping;
	
	@OneToOne
	@JoinColumn(name="usersId")
	private Users users;
	
	@OneToOne
	@JoinColumn(name="payId")
	private Pay pay;
	
	@OneToMany(mappedBy="orders")
	private List<OrderItems> orderItems;
	
	
	
	public Billing getBilling() {
		return billing;
	}
	public void setBilling(Billing billing) {
		this.billing = billing;
	}
	public Shipping getShipping() {
		return shipping;
	}
	public void setShipping(Shipping shipping) {
		this.shipping = shipping;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public Pay getPay() {
		return pay;
	}
	public void setPay(Pay pay) {
		this.pay = pay;
	}

	public List<OrderItems> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItems> orderItems) {
		this.orderItems = orderItems;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public Double getGrandTotal() {
		return grandTotal;
	}
	public void setGrandTotal(Double grandTotal) {
		this.grandTotal = grandTotal;
	}
	
	
	
	
}
