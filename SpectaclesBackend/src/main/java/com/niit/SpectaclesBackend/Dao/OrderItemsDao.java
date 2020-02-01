package com.niit.SpectaclesBackend.Dao;

import java.util.List;

import com.niit.SpectaclesBackend.Model.OrderItems;

public interface OrderItemsDao {

	public boolean saveorupdate(OrderItems orderItems);
	public boolean delete(OrderItems orderItems);
	public OrderItems getOrderItems(String orderItemsId);
	public List<OrderItems> orderitemslist();
	public List<OrderItems> getOrderItemsByProductId(String productsId);
}
