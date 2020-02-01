package com.niit.SpectaclesBackend;

import java.util.List;

import javax.persistence.OneToMany;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.SpectaclesBackend.Dao.OrderItemsDao;
import com.niit.SpectaclesBackend.Dao.OrdersDao;
import com.niit.SpectaclesBackend.Model.OrderItems;
import com.niit.SpectaclesBackend.Model.Orders;
import com.niit.SpectaclesBackend.Model.Products;

public class OrderItemsTest {
	
	public static void main(String args[])
	{
		AnnotationConfigApplicationContext ctx= new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		
		OrderItems c=(OrderItems)ctx.getBean("orderItems");
		OrderItemsDao cDao=(OrderItemsDao)ctx.getBean("orderitemsDao");
		
		Orders o=(Orders)ctx.getBean("orders");
		OrdersDao oDao=(OrdersDao)ctx.getBean("ordersDao");
		o=oDao.getOrders("O101");
		
		c.setOrderItemsId("O101");
		c.setProductId("P101");
		c.setOrders(o);
		
		System.out.println("OrderItemsId: "+c.getOrderItemsId());
		System.out.println("ProductId: "+c.getProductId());
		
		if(cDao.saveorupdate(c)==true)
		{
			System.out.println("Order Items saved");
		}
		else
		{
			System.out.println("Order Items not saved");
		}
		
		c=cDao.getOrderItems("O101");
		if(c==null)
		{
			System.out.println("Order Items not found");
		}
		else
		{
			System.out.println("OrderItemsId: "+c.getOrderItemsId());
			System.out.println("ProductId: "+c.getProductId());
		}
		
		c=cDao.getOrderItems("O102");
		if(c==null)
		{
			System.out.println("Order Items not found");
		}
		else if(cDao.delete(c)==true)
		{
			System.out.println("Order Items deleted");
		}
		else
		{
			System.out.println("Not deleted");
		}
		List<OrderItems> orderitemslist = cDao.orderitemslist();
		for(OrderItems c1: orderitemslist)
		{
			System.out.println("OrderItemsId: "+c1.getOrderItemsId());
			System.out.println("ProductId: "+c1.getProductId());
			
		}
	}


}
