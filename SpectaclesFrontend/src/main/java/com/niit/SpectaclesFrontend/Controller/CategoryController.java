package com.niit.SpectaclesFrontend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.SessionStatus;

import com.google.gson.Gson;
import com.niit.SpectaclesBackend.Dao.CartDao;
import com.niit.SpectaclesBackend.Dao.CartItemsDao;
import com.niit.SpectaclesBackend.Dao.CategoryDao;
import com.niit.SpectaclesBackend.Dao.OrderItemsDao;
import com.niit.SpectaclesBackend.Dao.OrdersDao;
import com.niit.SpectaclesBackend.Dao.ProductsDao;
import com.niit.SpectaclesBackend.DaoImpl.CategoryDaoImpl;
import com.niit.SpectaclesBackend.Model.Cart;
import com.niit.SpectaclesBackend.Model.CartItems;
import com.niit.SpectaclesBackend.Model.Category;
import com.niit.SpectaclesBackend.Model.OrderItems;
import com.niit.SpectaclesBackend.Model.Orders;
import com.niit.SpectaclesBackend.Model.Products;
import com.niit.SpectaclesFrontend.Utility.Delete;

@Controller
public class CategoryController {
	
	@Autowired
	Category category;
	@Autowired
	CategoryDao categoryDao; 
	@Autowired
	Products products;
	@Autowired
	ProductsDao productsDao;
	@Autowired
	CartItems cartItems;
	@Autowired
	CartItemsDao cartItemsDao;
	@Autowired
	OrderItems orderItems;
	@Autowired
	OrderItemsDao orderItemsDao;
	@Autowired
	Cart cart;
	@Autowired
	CartDao cartDao;
	@Autowired
	Orders orders;
	@Autowired
	OrdersDao ordersDao;
	
	@RequestMapping("/admin/category")
	public String category(Model model)
	{
		Category c=new Category();
		model.addAttribute("category",c);
		return "categoryform";
	}
	@RequestMapping(value="/admin/addCategory",method=RequestMethod.POST)
	public String addCategory(@ModelAttribute("category") Category category,Model model)
	{
		if(categoryDao.saveorupdate(category)==true)
		{
			Category c=new Category();
			model.addAttribute("category",c);
			List<Category> categories=categoryDao.categorylist();
		    model.addAttribute("categories",categories);
			model.addAttribute("mess", "saved successful");
		    return "redirect:/admin/viewcategory";
		}
		else
		{
			model.addAttribute("mess", "Sorry");	
			Category c=new Category();
			model.addAttribute("category",c);
			return "categoryform";
		}
		
	}
	@RequestMapping(value="/admin/categories",method=RequestMethod.GET)
	public String viewListCategory(@ModelAttribute("category") Category category,Model model)
	{
			List<Category> categories=categoryDao.categorylist();
		    model.addAttribute("categories",categories);
		    return "redirect:/admin/viewcategory";
		
	}
	
	@RequestMapping(value="/admin/viewcategory")
	public String viewcategory(Model model)
	{
		List<Category> categories=categoryDao.categorylist();
		model.addAttribute("categories",categories);
		return "viewcategory";
		
	}
	
//	@RequestMapping(value="/admin/getListCategory",method=RequestMethod.GET)
//	public String listCategory()
//	{
//		 Gson gson = new Gson();
//		List<Category> categories=categoryDao.categorylist();
//		 String json = gson.toJson(categories,Category.class);    
//		return json;
//		
//	}
	
	@RequestMapping(value="/admin/deletecategory/{id}")
	public String deleteCategory(@PathVariable("id")String id,Model model)
	{
		try {
			List<Products> p=productsDao.getProductsById(id);
			System.out.println(111111);
			for(Products p1:p)
			{
				System.out.println(p1.getDescription());
				List<CartItems> c=cartItemsDao.getCartItemsByProductId(p1.getProductsId());
				if(c==null || c.isEmpty())
				{
					System.out.println(123);
					productsDao.delete(p1);
				
				}
				else
				{
					for(CartItems c1:c)
					{
						System.out.println(12);
						Cart ca=cartDao.getCart(c1.getCart().getCartId());
						ca.setTotalItems(ca.getTotalItems()-1);
						ca.setGrandTotal(ca.getGrandTotal()-c1.getPrice());
						cartDao.saveorupdate(ca);
						cartItemsDao.delete(c1);
					}
					productsDao.delete(p1);
				}
			}
			   
				Category c=categoryDao.getCategory(id);
				if(categoryDao.delete(c)==true)
				{
					model.addAttribute("mess","Category has been successfully deleted");
					return "redirect:/admin/viewcategory";
				}
				return "redirect:/admin/viewcategory";
			
		} catch (Exception e) {
			Category c=categoryDao.getCategory(id);
			categoryDao.delete(c);
			System.out.println(e);
			return "redirect:/admin/viewcategory";
		}
		
		
	}
	
	@RequestMapping(value="/admin/editcategory/{id}")
	public String editCategory(@PathVariable("id")String id,Model model)
	{
		Category c=categoryDao.getCategory(id);
		model.addAttribute("category",c);
		return "categoryform";
	}
	
}
