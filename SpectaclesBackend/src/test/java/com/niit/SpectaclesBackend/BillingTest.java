package com.niit.SpectaclesBackend;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.SpectaclesBackend.Dao.BillingDao;
import com.niit.SpectaclesBackend.Model.Billing;

public class BillingTest {
	public static void main(String args[]) { 
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		
		//Category c= new Category();
		Billing c=(Billing)ctx.getBean("billing");
		BillingDao cDao=(BillingDao)ctx.getBean("billingDao");
		
		c.setBillId("C101");
		c.setBillAddress("Landmarks");
		c.setBillCity("Bangalore");
		c.setBillPhoneNo("9876543212");
		c.setBillState("Karnataka");
		System.out.println("billid"+c.getBillId());
		System.out.println("billname"+c.getBillAddress());
		System.out.println("billcity:"+c.getBillCity());
		System.out.println("billphoneno:"+c.getBillPhoneNo());
		System.out.println("billstate: "+c.getBillState());
		if(cDao.saveorupdate(c)==true)
		{
			System.out.println("Billing saved");
			
		}
		else
		{
			System.out.println("Billing  not saved");
			
		}
		c=cDao.getBilling("C101");
		if(c==null)
		{
			System.out.println("Billing not found");
		}
		else
		{
			System.out.println("BillingId : "+c.getBillId());
			System.out.println("BillingName: "+c.getBillAddress());
			System.out.println("billcity:"+c.getBillCity());
			System.out.println("billphoneno:"+c.getBillPhoneNo());
			System.out.println("billstate: "+c.getBillState());
		}
		
		
		c=cDao.getBilling("C102");
		if(c==null)
		{
			System.out.println("Billing not found");
		}
		else if(cDao.delete(c)==true)
		{
			System.out.println("Billing deleted");
		}
		else
		{
			System.out.println("Not deleted");
		}
		List<Billing> billinglist = cDao.billinglist();
		for(Billing c1: billinglist)
		{
			System.out.println("BillingId : "+c1.getBillId());
			System.out.println("BillingName: "+c1.getBillAddress());
			System.out.println("billcity:"+c1.getBillCity());
			System.out.println("billphoneno:"+c1.getBillPhoneNo());
			System.out.println("billstate: "+c1.getBillState());
			
		}
		
	}

}
