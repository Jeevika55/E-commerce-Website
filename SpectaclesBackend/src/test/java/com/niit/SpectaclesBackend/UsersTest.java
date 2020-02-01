package com.niit.SpectaclesBackend;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.SpectaclesBackend.Dao.BillingDao;
import com.niit.SpectaclesBackend.Dao.CartDao;
import com.niit.SpectaclesBackend.Dao.UsersDao;
import com.niit.SpectaclesBackend.Model.Billing;
import com.niit.SpectaclesBackend.Model.Cart;
import com.niit.SpectaclesBackend.Model.Users;

public class UsersTest {
	
	public static void main(String args[])
	{
		AnnotationConfigApplicationContext ctx= new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		
		Users c=(Users)ctx.getBean("users");
		UsersDao cDao=(UsersDao)ctx.getBean("usersDao");
		
		Billing b=(Billing)ctx.getBean("billing");
		BillingDao bDao=(BillingDao)ctx.getBean("billingDao");
		b=bDao.getBilling("B101");
		
		Cart cat=(Cart)ctx.getBean("cart");
		CartDao catDao=(CartDao)ctx.getBean("cartDao");
		cat=catDao.getCart("C101");
		
		c.setUsersId("U101");
		c.setUsersName("Jeevika");
		c.setUsersEmailId("jeevika@gmail.com");
		c.setUsersAddress("Sunkadakatte");
		c.setUsersPhoneNo("9867543214");
		c.setUsersPassword("jeevika");
		c.setBilling(b);
		c.setCart(cat);
		
		System.out.println("UsersId: "+c.getUsersId());
		System.out.println("UsersName: "+c.getUsersName());
		System.out.println("UsersEmailid: "+c.getUsersEmailId());
		System.out.println("UsersAddress: "+c.getUsersAddress());
		System.out.println("UsersPhoneNo: "+c.getUsersPhoneNo());
		System.out.println("UsersPassword: "+c.getUsersPassword());
		
		if(cDao.saveorupdate(c)==true)
		{
			System.out.println("Users saved");
		}
		else
		{
			System.out.println("Users not saved");
		}
		
		c=cDao.getUsers("U101");
		if(c==null)
		{
			System.out.println("Users not found");
		}
		else
		{
			System.out.println("UsersId: "+c.getUsersId());
			System.out.println("UsersName: "+c.getUsersName());
			System.out.println("UsersEmailid: "+c.getUsersEmailId());
			System.out.println("UsersAddress: "+c.getUsersAddress());
			System.out.println("UsersPhoneNo: "+c.getUsersPhoneNo());
			System.out.println("UsersPassword: "+c.getUsersPassword());
			
		}
		
		c=cDao.getUsers("U102");
		if(c==null)
		{
			System.out.println("Users not found");
		}
		else if(cDao.delete(c)==true)
		{
			System.out.println("Users deleted");
		}
		else
		{
			System.out.println("Not deleted");
		}
		List<Users> userslist = cDao.userslist();
		for(Users c1: userslist)
		{
			System.out.println("UsersId: "+c1.getUsersId());
			System.out.println("UsersName: "+c1.getUsersName());
			System.out.println("UsersEmailid: "+c1.getUsersEmailId());
			System.out.println("UsersAddress: "+c1.getUsersAddress());
			System.out.println("UsersPhoneNo: "+c1.getUsersPhoneNo());
			System.out.println("UsersPassword: "+c1.getUsersPassword());
			
			
		}
	}


}
