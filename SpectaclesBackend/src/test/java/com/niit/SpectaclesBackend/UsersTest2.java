package com.niit.SpectaclesBackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.SpectaclesBackend.Dao.UsersDao;
import com.niit.SpectaclesBackend.Model.Users;

public class UsersTest2 {
	
	public static void main(String args[])
	{
	AnnotationConfigApplicationContext ctx= new AnnotationConfigApplicationContext();
	ctx.scan("com.niit.*");
	ctx.refresh();
	
	Users c=(Users)ctx.getBean("users");
	UsersDao cDao=(UsersDao)ctx.getBean("usersDao");
	
	c.setUsersEmailId("jeevika@gmail.com");
	c.setUsersPassword("jeevika");
	
	System.out.println("UsersEmailid: "+c.getUsersEmailId());
	System.out.println("UsersPassword: "+c.getUsersPassword());
	
	c=cDao.isValidate("jeevika@gmail.com","jeevika");
	if(c==null)
	{
		System.out.println("Users not found");
	}
	else
	{
		System.out.println("UsersEmailid: "+c.getUsersEmailId());
		System.out.println("UsersPassword: "+c.getUsersPassword());
	}
	
	
	c=cDao.isValidate("jeev@gmail.com","jeev");
	if(c==null)
	{
		System.out.println("Users not found");
	}
	else
	{
		System.out.println("UsersEmailid: "+c.getUsersEmailId());
		System.out.println("UsersPassword: "+c.getUsersPassword());
	}
	}

}
