package com.niit.SpectaclesBackend.Dao;

import java.util.List;

import com.niit.SpectaclesBackend.Model.CartItems;

public interface CartItemsDao {
	public boolean saveorupdate(CartItems cartItems);
	public boolean delete(CartItems cartItems);
	public CartItems getCartItems(String cartItemsId);
	public List<CartItems> cartitemslist(String cartId);
	public List<CartItems> getCartItemsByProductId(String productsId);
}
