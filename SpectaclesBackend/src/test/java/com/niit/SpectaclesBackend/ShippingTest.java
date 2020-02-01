package com.niit.SpectaclesBackend;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.SpectaclesBackend.Dao.ShippingDao;
import com.niit.SpectaclesBackend.Dao.UsersDao;
import com.niit.SpectaclesBackend.Model.Shipping;
import com.niit.SpectaclesBackend.Model.Users;

public class ShippingTest { 
	public static void main(String args[])
	{
		AnnotationConfigApplicationContext ctx= new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		
		Shipping c=(Shipping)ctx.getBean("shipping");
	    ShippingDao cDao=(ShippingDao)ctx.getBean("shippingDao");
	    
	    Users u=(Users)ctx.getBean("users");
	    UsersDao uDao=(UsersDao)ctx.getBean("usersDao");
	    u=uDao.getUsers("U101");
	    
		c.setShipId("S101");
		c.setShipName("Bangalore");
		c.setShipCity("Bangalore");
		c.setShipPhoneNo("9876543216");
		c.setShipState("Karnataka");
		c.setUsers(u);
		
		System.out.println("ShipId: "+c.getShipId());
		System.out.println("ShipName: "+c.getShipName());
		System.out.println("ShipCity: "+c.getShipCity());
		System.out.println("ShipPhoneNo: "+c.getShipPhoneNo());
		System.out.println("ShipState: "+c.getShipState());
		
		if(cDao.saveorupdate(c)==true)
		{
			System.out.println("Shipping saved");
		}
		else
		{
			System.out.println("Shipping not saved");
		}
		
		c=cDao.getShipping("S101");
		if(c==null)
		{
			System.out.println("Shipping not found");
		}
		else
		{
			System.out.println("ShipId: "+c.getShipId());
			System.out.println("ShipName: "+c.getShipName());
			System.out.println("ShipCity: "+c.getShipCity());
			System.out.println("ShipPhoneNo: "+c.getShipPhoneNo());
			System.out.println("ShipState: "+c.getShipState());
			
		}
		
		c=cDao.getShipping("S102");
		if(c==null)
		{
			System.out.println("Shipping not found");
		}
		else if(cDao.delete(c)==true)
		{
			System.out.println("Shipping deleted");
		}
		else
		{
			System.out.println("Not deleted");
		}
		List<Shipping> shippinglist = cDao.shippinglist();
		for(Shipping c1: shippinglist)
		{
			System.out.println("ShipId: "+c1.getShipId());
			System.out.println("ShipName: "+c1.getShipName());
			System.out.println("ShipCity: "+c1.getShipCity());
			System.out.println("ShipPhoneNo: "+c1.getShipPhoneNo());
			System.out.println("ShipState: "+c1.getShipState());
			
		}
	}

}
