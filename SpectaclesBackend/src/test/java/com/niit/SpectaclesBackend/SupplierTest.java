package com.niit.SpectaclesBackend;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.SpectaclesBackend.Dao.SupplierDao;
import com.niit.SpectaclesBackend.Model.Supplier;

public class SupplierTest {
	
	public static void main(String args[])
	{
		AnnotationConfigApplicationContext ctx= new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		
		Supplier c=(Supplier)ctx.getBean("supplier");
	    SupplierDao cDao=(SupplierDao)ctx.getBean("supplierDao");
		c.setSupplierId("S101");
		c.setSupplierName("Krishna");
		c.setSupplierEmailId("krishna@gmail.com");
		c.setSupplierAddress("Rajajinagar");
		System.out.println("SupplierId: "+c.getSupplierId());
		System.out.println("SupplierName: "+c.getSupplierName());
		System.out.println("SupplierEmailid: "+c.getSupplierEmailId());
		System.out.println("SupplierAddress: "+c.getSupplierAddress());
		
		if(cDao.saveorupdate(c)==true)
		{
			System.out.println("Supplier saved");
		}
		else
		{
			System.out.println("Supplier not saved");
		}
		
		c=cDao.getSupplier("S101");
		if(c==null)
		{
			System.out.println("Supplier not found");
		}
		else
		{
			System.out.println("SupplierId: "+c.getSupplierId());
			System.out.println("SupplierName: "+c.getSupplierName());
			System.out.println("SupplierEmailid: "+c.getSupplierEmailId());
			System.out.println("SupplierAddress: "+c.getSupplierAddress());
		}
		
		c=cDao.getSupplier("S102");
		if(c==null)
		{
			System.out.println("Supplier not found");
		}
		else if(cDao.delete(c)==true)
		{
			System.out.println("Supplier deleted");
		}
		else
		{
			System.out.println("Not deleted");
		}
		List<Supplier> supplierlist = cDao.supplierlist();
		for(Supplier c1: supplierlist)
		{
			System.out.println("SupplierId: "+c1.getSupplierId());
			System.out.println("SupplierName: "+c1.getSupplierName());
			System.out.println("SupplierEmailid: "+c.getSupplierEmailId());
			System.out.println("SupplierAddress: "+c.getSupplierAddress());
		}
	}


}
