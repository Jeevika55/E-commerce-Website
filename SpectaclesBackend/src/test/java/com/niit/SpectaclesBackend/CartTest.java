package com.niit.SpectaclesBackend;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.SpectaclesBackend.Dao.CartDao;
import com.niit.SpectaclesBackend.Model.Cart;

public class CartTest {
	
	public static void main(String args[])
	{
		AnnotationConfigApplicationContext ctx= new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		
		Cart c=(Cart)ctx.getBean("cart");
		CartDao cDao=(CartDao)ctx.getBean("cartDao");
		
		c.setCartId("C101");
		c.setGrandTotal(10.0);
		c.setTotalItems(5);
		
		System.out.println("CartId: "+c.getCartId());
		System.out.println("GrandTotal: "+c.getGrandTotal());
		System.out.println("TotalItems:"+c.getTotalItems());
		
		if(cDao.saveorupdate(c)==true)
		{
			System.out.println("Cart saved");
		}
		else
		{
			System.out.println("Cart not saved");
		}
		
		c=cDao.getCart("C101");
		if(c==null)
		{
			System.out.println("Cart not found");
		}
		else
		{
			System.out.println("CartId: "+c.getCartId());
			System.out.println("GrandTotal: "+c.getGrandTotal());
			System.out.println("TotalItems:"+c.getTotalItems());
		}
		
		c=cDao.getCart("C102");
		if(c==null)
		{
			System.out.println("Cart not found");
		}
		else if(cDao.delete(c)==true)
		{
			System.out.println("Cart deleted");
		}
		else
		{
			System.out.println("Not deleted");
		}
		List<Cart> cartlist = cDao.cartlist();
		for(Cart c1: cartlist)
		{
			System.out.println("CartId: "+c1.getCartId());
			System.out.println("GrandTotal: "+c1.getGrandTotal());
			System.out.println("TotalItems:"+c1.getTotalItems());
			
		}
	}



}
