package com.niit.SpectaclesBackend.Model;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component

public class CartItems {
	
	@Id
	private String cartItemsId;
	private float price;
	
	public CartItems()
	{
		this.cartItemsId="CARTITEMS"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	
	@ManyToOne
	@JoinColumn(name="cartId")
	private Cart cart;
	
	@OneToOne
	@JoinColumn(name="productsId")
	private Products products;
	
	
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public Products getProducts() {
		return products;
	}
	public void setProducts(Products products) {
		this.products = products;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getCartItemsId() {
		return cartItemsId;
	}
	public void setCartItemsId(String cartItemsId) {
		this.cartItemsId = cartItemsId;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
}
