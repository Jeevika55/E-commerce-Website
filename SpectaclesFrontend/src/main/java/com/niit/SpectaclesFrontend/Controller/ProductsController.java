package com.niit.SpectaclesFrontend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.SpectaclesBackend.Dao.CartDao;
import com.niit.SpectaclesBackend.Dao.CartItemsDao;
import com.niit.SpectaclesBackend.Dao.CategoryDao;
import com.niit.SpectaclesBackend.Dao.ProductsDao;
import com.niit.SpectaclesBackend.Dao.SupplierDao;
import com.niit.SpectaclesBackend.Model.Cart;
import com.niit.SpectaclesBackend.Model.CartItems;
import com.niit.SpectaclesBackend.Model.Category;
import com.niit.SpectaclesBackend.Model.Products;
import com.niit.SpectaclesBackend.Model.Supplier;
import com.niit.SpectaclesFrontend.FileInput.FileInput;

@Controller
public class ProductsController {
	
	@Autowired
	Products products;
	@Autowired
	ProductsDao productsDao; 
	@Autowired
	Category category;
	@Autowired
	CategoryDao categoryDao;
	@Autowired
	Supplier supplier;
	@Autowired
	SupplierDao supplierDao;
	@Autowired
	CartItems cartItems;
	@Autowired
	CartItemsDao cartItemsDao;
	@Autowired
	Cart cart;
	@Autowired
	CartDao cartDao;
	
	String path="F:\\SpectaclesFrontend\\src\\main\\webapp\\resources\\img\\product\\";
			
	@RequestMapping("/admin/products")
	public String products(Model model)
	{
		Products p=new Products();
		model.addAttribute("products",p);
		Category c=new Category();
		model.addAttribute("category",c);
		Supplier s=new Supplier();
		model.addAttribute("supplier",s);
		List<Category> categories=categoryDao.categorylist();
		model.addAttribute("categories",categories);
		List<Supplier> suppliers=supplierDao.supplierlist();
		model.addAttribute("suppliers",suppliers);
		return "productsform";
	}
	@RequestMapping(value="/admin/addProducts",method=RequestMethod.POST)
	public String addProducts(@ModelAttribute("products") Products products,Model model)
	{
		
		
		if(productsDao.saveorupdate(products)==true)
		{
			FileInput.upload(path, products.getPimg(), products.getProductsId()+".jpg");
			Products p=new Products();
			model.addAttribute("products",p);
			List<Products> productss=productsDao.productslist();
		    model.addAttribute("productss",productss);
			model.addAttribute("mess", "saved successful");
		    return "redirect:/admin/viewadminproduct";
		}
		else
		{
			model.addAttribute("mess", "Sorry");	
			Products p=new Products();
			model.addAttribute("products",p);
			return "productsform";
		}
		
	}
	@RequestMapping(value="/admin/productss",method=RequestMethod.GET)
	public String viewListProducts(@ModelAttribute("products") Products products,Model model)
	{
			List<Products> productss=productsDao.productslist();
		    model.addAttribute("productss",productss);
		    return "redirect:/admin/viewadminproduct";
		
	}
	
	@RequestMapping(value="/admin/viewadminproduct")
	public String viewadminproduct(Model model)
	{
		List<Products> productss=productsDao.productslist();
	    model.addAttribute("productss",productss);
	    return "viewadminproduct";
	}
	
	
	@RequestMapping(value="/admin/editproducts/{id}")
	public String editProducts(@PathVariable("id")String id,Model model)
	{
		List<Category> categories=categoryDao.categorylist();
		model.addAttribute("categories",categories);
		List<Supplier> suppliers=supplierDao.supplierlist();
		model.addAttribute("suppliers",suppliers);
		Products p=productsDao.getProduct(id);
		model.addAttribute("products",p);
		return "productsform";
	}
	
	@RequestMapping(value="/admin/deleteproducts/{id}")
	public String deleteProducts(@PathVariable("id")String id,Model model)
	{
		try {
			Products p=productsDao.getProduct(id);
			List<CartItems> c=cartItemsDao.getCartItemsByProductId(p.getProductsId());
			if(c==null || c.isEmpty())
			{
				System.out.println(123);
				productsDao.delete(p);
			
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
				productsDao.delete(p);
			}
			
			if(productsDao.delete(p)==true)
			{
				model.addAttribute("mess","Product deleted successfully");
				return "redirect:/admin/viewadminproduct";
			}
			else
			{
				return "redirect:/admin/viewadminproduct";
			}
		} catch (Exception e) {
			Products p=productsDao.getProduct(id);
			productsDao.delete(p);
			System.out.println(e);
			return "redirect:/admin/viewadminproduct";
		}
	}
	
	
	
	
	
	@RequestMapping(value="/viewproducts")
	public String viewproducts(Model model)
	{
		List<Category> categories=categoryDao.categorylist();
		model.addAttribute("categories",categories);
		List<Products> productss=productsDao.productslist();
		System.out.println(productss);
		model.addAttribute("productss",productss);
		return "viewproducts";
		
	}
	@RequestMapping(value="/viewproducts/{id}")
	public String getProductByCat(@PathVariable("id")String id,Model model)
	{
		List<Category> categories=categoryDao.categorylist();
		model.addAttribute("categories",categories);
		List<Products> productss=productsDao.getProductsById(id);
		model.addAttribute("productss",productss);
		System.out.println(productss);
		return "viewproducts";
		
	}
}
