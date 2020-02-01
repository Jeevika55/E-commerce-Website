package com.niit.SpectaclesFrontend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.SpectaclesBackend.Dao.CartItemsDao;
import com.niit.SpectaclesBackend.Dao.CategoryDao;
import com.niit.SpectaclesBackend.Dao.UsersDao;
import com.niit.SpectaclesBackend.Model.CartItems;
import com.niit.SpectaclesBackend.Model.Category;
import com.niit.SpectaclesBackend.Model.Users;

@Controller
public class HomeController {
	
	@Autowired
	Category category;
	@Autowired
	CategoryDao categoryDao;
	@Autowired
	CartItems cartItems;
	@Autowired
	CartItemsDao cartItemsDao;
	@Autowired
	Users users;
	@Autowired
	UsersDao usersDao;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String index(Model model)
	{
		List<Category> categories=categoryDao.categorylist();
		model.addAttribute("categories",categories);
		return "index2";
	}


	@RequestMapping("/myaccount")
	public String myaccount()
	{
		return "myaccount";
	}
	@RequestMapping("/nav")
	public String nav(Model model)
	{
		List<CartItems> ci =cartItemsDao.cartitemslist(users.getCart().getCartId());
		if(ci==null || ci.isEmpty())
		{
			model.addAttribute("mess","No items added to cart");
			return "nav";
		}
		model.addAttribute("CartItems", ci);	
		model.addAttribute("cart",users.getCart());
		return "nav";
	}
	@RequestMapping("/footer")
	public String footer()
	{
		return "footer";
	}
	@RequestMapping("/wishlist")
	public String wishlist()
	{
		return "wishlist";
	}
	
    @RequestMapping("/product")
    public String product()
    {
    	return "product";
    }

}
