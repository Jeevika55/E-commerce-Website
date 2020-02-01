package com.niit.SpectaclesFrontend.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.SpectaclesBackend.Dao.CategoryDao;
import com.niit.SpectaclesBackend.Dao.UsersDao;
import com.niit.SpectaclesBackend.Model.Category;
import com.niit.SpectaclesBackend.Model.Users;

@Controller
public class LoginController {
	
	@Autowired
	Users users;
	@Autowired
	UsersDao usersDao;
	
	@Autowired
	Category category;
	@Autowired
	CategoryDao categoryDao;
	
	
	@RequestMapping("/login")
	public String login(@RequestParam(value="error",required=false)String error,@RequestParam(value="logout",required=false)String logout,Model model)
	{
		if(error!=null)
			model.addAttribute("error","invalid username or password");
		if(logout!=null)
			model.addAttribute("logout","login successfully");
		List<Category> categories= categoryDao.categorylist();
		model.addAttribute("lcat", categories);
		return "login";
	}
	
	@RequestMapping(value="/j_spring_security_check")
	public String Login(@RequestParam("j_username")String umail,@RequestParam("j_password")String pwd,Model model,HttpSession session)
{
	Users u=usersDao.isValidate(umail,pwd);
	if(u==null)
	{
		model.addAttribute("msg","Invalid username pwd");
		return "redirect:/login";
	}
	else
	{
		session.setAttribute("user",u);
		session.setAttribute("name",u.getUsersName());
	    session.setAttribute("items",u.getCart().getTotalItems());
	    return "redirect:/";
	}
}
	
    @RequestMapping(value="/j_spring_security_logout")
    public String logout(HttpServletRequest request,HttpSession session,Model model)
    {
	   session.invalidate();
	   session=request.getSession(true);
	   model.addAttribute("logout","logout Successfully");
	   return "redirect:/";
    }
	
	
}