package com.niit.SpectaclesBackend;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.SpectaclesBackend.Dao.CartDao;
import com.niit.SpectaclesBackend.Dao.CartItemsDao;
import com.niit.SpectaclesBackend.Dao.CategoryDao;
import com.niit.SpectaclesBackend.Model.Cart;
import com.niit.SpectaclesBackend.Model.CartItems;
import com.niit.SpectaclesBackend.Model.Category;

public class CartItemsTest {
	public static void main(String args[])
	{
		AnnotationConfigApplicationContext ctx= new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		
		CartItems c=(CartItems)ctx.getBean("cartItems");
		CartItemsDao cDao=(CartItemsDao)ctx.getBean("cartitemsDao");
		
		 Cart cat=(Cart)ctx.getBean("cart");
		    CartDao catDao=(CartDao)ctx.getBean("cartDao");
		    cat=catDao.getCart("C101");
		    
		    
		c.setCartItemsId("C101");
		c.setPrice((float) 10.0);
		c.setCart(cat);
		
		System.out.println("CartItemsId: "+c.getCartItemsId());
		System.out.println("Price: "+c.getPrice());
		
		if(cDao.saveorupdate(c)==true)
		{
			System.out.println("Cart Items saved");
		}
		else
		{
			System.out.println("Cart Items not saved");
		}
		
		c=cDao.getCartItems("C101");
		if(c==null)
		{
			System.out.println("Cart Items not found");
		}
		else
		{
			System.out.println("CartItemsId : "+c.getCartItemsId());
			System.out.println("Price: "+c.getPrice());
		}
		
		c=cDao.getCartItems("C102");
		if(c==null)
		{
			System.out.println("Cart Items not found");
		}
		else if(cDao.delete(c)==true)
		{
			System.out.println("Cart Items deleted");
		}
		else
		{
			System.out.println("Not deleted");
		}
//		List<CartItems> cartitemslist = cDao.cartitemslist();
//		for(CartItems c1: cartitemslist)
//		{
//			System.out.println("CartItemsId : "+c1.getCartItemsId());
//			System.out.println("Price: "+c1.getPrice());
//			
//		}
	}

}
