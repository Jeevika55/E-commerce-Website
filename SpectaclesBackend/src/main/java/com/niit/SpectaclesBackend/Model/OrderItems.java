package com.niit.SpectaclesBackend.Model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class OrderItems {
	@Id
	private String orderItemsId;
	private String productId;
	
	@ManyToOne
	@JoinColumn(name="orderId")
	private Orders orders;
	
public OrderItems()
{
	this.orderItemsId="ORDERITEMS"+UUID.randomUUID().toString().substring(30).toUpperCase();
}
	public Orders getOrders() {
		return orders;
	}
	public void setOrders(Orders orders) {
		this.orders = orders;
	}
	public String getOrderItemsId() {
		return orderItemsId;
	}
	public void setOrderItemsId(String orderItemsId) {
		this.orderItemsId = orderItemsId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	
	

}
