package com.niit.SpectaclesBackend.Dao;

import java.util.List;

import com.niit.SpectaclesBackend.Model.Orders;

public interface OrdersDao {
	public boolean saveorupdate(Orders orders);
	public boolean delete(Orders orders);
	public Orders getOrders(String orderId);
	public List<Orders> orderslist();

}
