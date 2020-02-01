package com.niit.SpectaclesBackend;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.SpectaclesBackend.Dao.CategoryDao;
import com.niit.SpectaclesBackend.Dao.ProductsDao;
import com.niit.SpectaclesBackend.Dao.SupplierDao;
import com.niit.SpectaclesBackend.Model.Category;
import com.niit.SpectaclesBackend.Model.Products;
import com.niit.SpectaclesBackend.Model.Supplier;

public class ProductsTest {
	
	public static void main(String args[])
	{
		AnnotationConfigApplicationContext ctx= new AnnotationConfigApplicationContext();
		ctx.scan("com.niit.*");
		ctx.refresh();
		
		Products c=(Products)ctx.getBean("products");
	    ProductsDao cDao=(ProductsDao)ctx.getBean("productsDao");
	    
	    Category cat=(Category)ctx.getBean("category");
	    CategoryDao catDao=(CategoryDao)ctx.getBean("categoryDao");
	    cat=catDao.getCategory("C101");
	    
	    Supplier sup=(Supplier)ctx.getBean("supplier");
	    SupplierDao supDao=(SupplierDao)ctx.getBean("supplierDao");
	    sup=supDao.getSupplier("S101");
	    
		c.setProductsId("P101");
		c.setProductsName("Spectacals");
		c.setPrice(100);
		c.setQuantity(5);
		c.setDescription("Rimless");
		c.setCategory(cat);
		c.setSupplier(sup);
		
		System.out.println("ProductsId: "+c.getProductsId());
		System.out.println("ProductsName: "+c.getProductsName());
		System.out.println("ProductsPrice: "+c.getPrice());
		System.out.println("ProductsQuantity: "+c.getQuantity());
		System.out.println("ProductDescription: "+c.getDescription());
		
		
		if(cDao.saveorupdate(c)==true)
		{
			System.out.println("Products saved");
		}
		else
		{
			System.out.println("Products not saved");
		}
		
		c=cDao.getProduct("P101");
		if(c==null)
		{
			System.out.println("Products not found");
		}
		else
		{
			System.out.println("ProductsId: "+c.getProductsId());
			System.out.println("ProductsName: "+c.getProductsName());
			System.out.println("ProductsPrice: "+c.getPrice());
			System.out.println("ProductsQuantity: "+c.getQuantity());
			System.out.println("ProductDescription: "+c.getDescription());
			
		}
		
		c=cDao.getProduct("P102");
		if(c==null)
		{
			System.out.println("Product not found");
		}
		else if(cDao.delete(c)==true)
		{
			System.out.println("Product deleted");
		}
		else
		{
			System.out.println("Not deleted");
		}
		List<Products> productslist = cDao.productslist();
		for(Products c1: productslist)
		{
			System.out.println("ProductsId: "+c1.getProductsId());
			System.out.println("ProductsName: "+c1.getProductsName());
			System.out.println("ProductsPrice: "+c1.getPrice());
			System.out.println("ProductsQuantity: "+c1.getQuantity());
			System.out.println("ProductDescription: "+c1.getDescription());
			
		}
	}

}
