package com.niit.SpectaclesBackend;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.SpectaclesBackend.Dao.CategoryDao;
import com.niit.SpectaclesBackend.Model.Category;

public class CategoryTest {
	public static void main(String args[])
	{
		AnnotationConfigApplicationContext ctx= new AnnotationConfigApplicationContext();//connnect to database
		ctx.scan("com.niit.*");
		ctx.refresh(); //create a object each and every time
		
		Category c=(Category)ctx.getBean("category");
		CategoryDao cDao=(CategoryDao)ctx.getBean("categoryDao");
		c.setCatId("C101");
		c.setCatName("Category1");
		System.out.println("CategoryId: "+c.getCatId());
		System.out.println("CategoryName: "+c.getCatName());
		
		if(cDao.saveorupdate(c)==true)
		{
			System.out.println("Category saved");
		}
		else
		{
			System.out.println("Category not saved");
		}
		
		c=cDao.getCategory("C101");
		if(c==null)
		{
			System.out.println("Category not found");
		}
		else
		{
			System.out.println("CategoryId : "+c.getCatId());
			System.out.println("CategoryName: "+c.getCatName());
		}
		
		c=cDao.getCategory("C102");
		if(c==null)
		{
			System.out.println("Category not found");
		}
		else if(cDao.delete(c)==true)
		{
			System.out.println("Category deleted");
		}
		else
		{
			System.out.println("Not deleted");
		}
		
		List<Category> categorylist = cDao.categorylist();
		for(Category c1: categorylist)
		{
			System.out.println("CategoryId : "+c1.getCatId());
			System.out.println("CategoryName: "+c1.getCatName());
			
		}
	}

}
