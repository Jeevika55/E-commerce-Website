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
import com.niit.SpectaclesBackend.Dao.ProductsDao;
import com.niit.SpectaclesBackend.Dao.SupplierDao;
import com.niit.SpectaclesBackend.Model.Cart;
import com.niit.SpectaclesBackend.Model.CartItems;
import com.niit.SpectaclesBackend.Model.Category;
import com.niit.SpectaclesBackend.Model.Products;
import com.niit.SpectaclesBackend.Model.Supplier;

@Controller
public class SupplierController {
	
	@Autowired
	Supplier supplier;
	@Autowired
	SupplierDao supplierDao;
	@Autowired
	Products products;
	@Autowired
	ProductsDao productsDao;
	@Autowired
	CartItems cartItems;
	@Autowired
	CartItemsDao cartItemsDao;
	@Autowired
	Cart cart;
	@Autowired
	CartDao cartDao;
	
	@RequestMapping("/admin/supplier")
	public String supplier(Model model)
	{
		Supplier s=new Supplier();
		model.addAttribute("supplier",s);
		return "supplierform";
	}
	
	@RequestMapping(value="/admin/addSupplier",method=RequestMethod.POST)
	public String addSupplier(@ModelAttribute("supplier") Supplier supplier,Model model)
	{
		if(supplierDao.saveorupdate(supplier)==true)
		{
			Supplier s=new Supplier();
			model.addAttribute("supplier",s);
			List<Supplier> suppliers=supplierDao.supplierlist();
		    model.addAttribute("suppliers",suppliers);
			model.addAttribute("mess","Saved Successfully");
			return "redirect:/admin/viewsupplier";
		}
		else
		{
			model.addAttribute("mess","Sorry");
			Supplier s=new Supplier();
			model.addAttribute("supplier",s);
			return "supplierform";
		}
	}
	
	@RequestMapping(value="/admin/suppliers",method=RequestMethod.GET)
	public String viewListSupplier(@ModelAttribute("supplier") Supplier supplier,Model model)
	{
			List<Supplier> suppliers=supplierDao.supplierlist();
		    model.addAttribute("suppliers",suppliers);
		    return "redirect:/admin/viewsupplier";
		
	}
	
	@RequestMapping(value="/admin/viewsupplier")
	public String viewsupplier(Model model)
	{
		List<Supplier> suppliers=supplierDao.supplierlist();
		model.addAttribute("suppliers",suppliers);
		return "viewsupplier";
		
	}
	
	@RequestMapping(value="/admin/deletesupplier/{id}")
	public String deleteSupplier(@PathVariable("id")String id,Model model)
	{
		try {
			List<Products> p=productsDao.getProductsBySupplierId(id);
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
			   
		
		
		Supplier s=supplierDao.getSupplier(id);
		if(supplierDao.delete(s)==true)
		{
			model.addAttribute("mess","Supplier deleted successfully");
			return "redirect:/admin/viewsupplier";
		}
		else
		{
			return "redirect:/admin/viewsupplier";
		}
		} catch (Exception e) {
			Supplier c=supplierDao.getSupplier(id);
			supplierDao.delete(c);
			System.out.println(e);
			return "redirect:/admin/viewsupplier";
		}
	}
	
	@RequestMapping(value="/admin/editsupplier/{id}")
	public String editSupplier(@PathVariable("id")String id,Model model)
	{
		Supplier s=supplierDao.getSupplier(id);
		model.addAttribute("supplier", s);
		return "supplierform";
	}

}
