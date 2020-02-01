package com.niit.SpectaclesBackend;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.SpectaclesBackend.Dao.AuthenticationDao;
import com.niit.SpectaclesBackend.Model.Authentication;
public class AuthenticationTest {
	
		public static void main(String args[])
		{
			AnnotationConfigApplicationContext ctx= new AnnotationConfigApplicationContext();
			ctx.scan("com.niit.*");
			ctx.refresh();
			
			Authentication c=(Authentication)ctx.getBean("authentication");
			AuthenticationDao cDao=(AuthenticationDao)ctx.getBean("authenticationDao");
			c.setRoleId("R101");
			c.setRoleName("Role1");
			c.setUsersName("Jeevika");
			System.out.println("RoleId: "+c.getRoleId());
			System.out.println("RoleName: "+c.getRoleName());
			System.out.println("UserName: "+c.getUsersName());
			
			if(cDao.saveorupdate(c)==true)
			{
				System.out.println("Role saved");
			}
			else
			{
				System.out.println("Role not saved");
			}
			
			c=cDao.getAuthentication("R101");
			if(c==null)
			{
				System.out.println("Role not found");
			}
			else
			{
				System.out.println("RoleId : "+c.getRoleId());
				System.out.println("RoleName: "+c.getRoleName());
				System.out.println("UserName: "+c.getUsersName());
			}
			
			c=cDao.getAuthentication("A102");
			if(c==null)
			{
				System.out.println("Authentication not found");
			}
			else if(cDao.delete(c)==true)
			{
				System.out.println("Authentication deleted");
			}
			else
			{
				System.out.println("Not deleted");
			}
			List<Authentication> authenticationlist = cDao.authenticationlist();
			for(Authentication c1: authenticationlist)
			{
				System.out.println("RoleId : "+c1.getRoleId());
				System.out.println("RoleName: "+c1.getRoleName());
				System.out.println("UserName: "+c1.getUsersName());
				
			}
		}

	}



