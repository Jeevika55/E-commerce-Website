package com.niit.SpectaclesFrontend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.SpectaclesBackend.Dao.CartDao;
import com.niit.SpectaclesBackend.Dao.CartItemsDao;
import com.niit.SpectaclesBackend.Dao.ProductsDao;
import com.niit.SpectaclesBackend.Dao.UsersDao;
import com.niit.SpectaclesBackend.Model.Cart;
import com.niit.SpectaclesBackend.Model.CartItems;
import com.niit.SpectaclesBackend.Model.Category;
import com.niit.SpectaclesBackend.Model.Products;
import com.niit.SpectaclesBackend.Model.Users;

@Controller
public class CartController {

	@Autowired
	Users users;
	@Autowired
	UsersDao usersDao;
	@Autowired
	Products products;
	@Autowired
	ProductsDao productsDao;
	@Autowired
	Cart cart;
	@Autowired
	CartDao cartDao;
	@Autowired
	CartItems cartItems;
	@Autowired
	CartItemsDao cartItemsDao;
	
	@RequestMapping(value="/cart")
	public String getCartItems(Model model)
	{
		Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		if(!(authentication instanceof AnonymousAuthenticationToken))
		{
			String currentUserName=authentication.getName();
			users=usersDao.getUsersByEmail(currentUserName);
			if(users==null)
				return "redirect:/login";
			else
			{
				List<CartItems> ci =cartItemsDao.cartitemslist(users.getCart().getCartId());
				if(ci==null || ci.isEmpty())
				{
					model.addAttribute("mess","No items added to cart");
					return "cart";
				}
				model.addAttribute("CartItems", ci);	
				model.addAttribute("cart",users.getCart());
			}
		}
		
		
		return "cart";
	}
	
	@RequestMapping(value="/add/To/cart/{pid}")
	public String addToCart(@PathVariable("pid")String id,Model model)
	{
		System.out.println(123);
		Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		if(!(authentication instanceof AnonymousAuthenticationToken))
		{
			String currentUserName=authentication.getName();
			users=usersDao.getUsersByEmail(currentUserName);
			if(users==null)
				return "redirect:/login";
			else
			{
				cart=users.getCart();
				System.out.println(cart.getCartId());
				products=productsDao.getProduct(id);
				CartItems cartItems=new CartItems();
				cartItems.setProducts(products);
				cartItems.setCart(cart);
				cartItems.setPrice(products.getPrice());
				if(cartItemsDao.saveorupdate(cartItems))
				{
					int t=cart.getTotalItems()+1;
					Double p=cart.getGrandTotal()+products.getPrice();
					cart.setGrandTotal(p);
					cart.setTotalItems(t);
					cartDao.saveorupdate(cart);
				}
				
				return "redirect:/cart";
			}
		}
		return "redirect:/cart";
		
	}
	@RequestMapping(value="/remove/cartitems/{cartitemsid}")
	public String removeCartItems(@PathVariable("cartitemsid")String cartitemsid,Model model)
	{
		CartItems c=cartItemsDao.getCartItems(cartitemsid);
		Cart c1=c.getCart();
		c1.setGrandTotal(c1.getGrandTotal()-c.getPrice());
		c1.setTotalItems(c1.getTotalItems()-1);
		cartDao.saveorupdate(c1);
		cartItemsDao.delete(c);
		return "redirect:/cart";
		
	}
}
