package com.niit.SpectaclesFrontend.Utility;

import java.util.List;

import javax.jws.WebMethod;

import org.springframework.beans.factory.annotation.Autowired;

import com.niit.SpectaclesBackend.Dao.CartDao;
import com.niit.SpectaclesBackend.Dao.CartItemsDao;
import com.niit.SpectaclesBackend.Dao.OrderItemsDao;
import com.niit.SpectaclesBackend.Dao.OrdersDao;
import com.niit.SpectaclesBackend.Dao.ProductsDao;
import com.niit.SpectaclesBackend.Model.Cart;
import com.niit.SpectaclesBackend.Model.CartItems;
import com.niit.SpectaclesBackend.Model.OrderItems;
import com.niit.SpectaclesBackend.Model.Orders;
import com.niit.SpectaclesBackend.Model.Products;

public class Delete {

	@Autowired
	Products products;
	@Autowired
	ProductsDao productsDao;
	@Autowired
	CartItems cartItems;
	@Autowired
	CartItemsDao cartItemsDao;
	@Autowired
	OrderItems orderItems;
	@Autowired
	OrderItemsDao orderItemsDao;
	@Autowired
	Cart cart;
	@Autowired
	CartDao cartDao;
	@Autowired
	Orders orders;
	@Autowired
	OrdersDao ordersDao;

	public boolean DeleteProduct(String catId)
	{
		System.out.println(111111);
		List<Products> p=productsDao.getProductsById(catId);
		System.out.println(111111);
		for(Products p1:p)
		{
			List<CartItems> c=cartItemsDao.getCartItemsByProductId(p1.getProductsId());
			if(c==null || c.isEmpty())
			{
				System.out.println(123);
				productsDao.delete(p1);
				return true;
			}
			else
			{
				for(CartItems c1:c)
				{
					System.out.println(12);
					Cart ca=cartDao.getCart(c1.getCart().getCartId());
					ca.setTotalItems(ca.getTotalItems()-1);
					ca.setGrandTotal(ca.getGrandTotal()-c1.getPrice());
					cartDao.saveorupdate(ca);
					cartItemsDao.delete(c1);
				}
				productsDao.delete(p1);
				return true;
			}
//			List<OrderItems> o=orderItemsDao.getOrderItemsByProductId(p1.getProductsId());
		}
		
		return false;
	}
	
}
