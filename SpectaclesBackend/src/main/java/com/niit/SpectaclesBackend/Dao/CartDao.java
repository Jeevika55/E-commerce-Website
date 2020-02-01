package com.niit.SpectaclesBackend.Dao;

import java.util.List;

import com.niit.SpectaclesBackend.Model.Cart;

public interface CartDao {

	public boolean saveorupdate(Cart cart);
	public boolean delete(Cart cart);
	public Cart getCart(String cartId);
	public List<Cart> cartlist();
}
