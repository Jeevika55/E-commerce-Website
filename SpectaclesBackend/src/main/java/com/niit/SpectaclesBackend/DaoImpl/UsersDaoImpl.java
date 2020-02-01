package com.niit.SpectaclesBackend.DaoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.SpectaclesBackend.Dao.UsersDao;
import com.niit.SpectaclesBackend.Model.Authentication;
import com.niit.SpectaclesBackend.Model.Billing;
import com.niit.SpectaclesBackend.Model.Products;
import com.niit.SpectaclesBackend.Model.Users;

@Repository("usersDao")
@Transactional
public class UsersDaoImpl implements UsersDao{
	
	@Autowired
	SessionFactory sessionFactory;
	
	public UsersDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}

	
	@Override
	public boolean saveorupdate(Users users) {
		sessionFactory.getCurrentSession().saveOrUpdate(users);
		return true;
	}
	

	@Override
	public boolean delete(Users users) {
		sessionFactory.getCurrentSession().delete(users);
		return true;
	}

	
	@Override
	public Users getUsers(String usersId) {
		String q1 = "from Users where UsersId='"+usersId+"'";
		Query w=sessionFactory.getCurrentSession().createQuery(q1);
		List<Users> list= (List<Users>)w.list();
		if(list==null || list.isEmpty())
		{
			return null;
		}
		
		return list.get(0);
	}

	@Override
	public List<Users> userslist() {
		List<Users> users = (List<Users>) sessionFactory.getCurrentSession().createCriteria(Users.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return users;
	}
	
	@Override
	public Users isValidate(String emailid,String password) 
	{
		String v1= "from Users where UsersEmailId='"+emailid+"'and UsersPassword='"+password+"'";
	    Query w=sessionFactory.getCurrentSession().createQuery(v1);
	    List<Users> list= (List<Users>)w.list();
		if(list==null || list.isEmpty())
		{
			return null;
		}
		
		return list.get(0);
	}
	
	@Override
	public Users getUsersByEmail(String currentUserName) {
		String q1 = "from Users where UsersEmailId='"+currentUserName+"'";
		Query w=sessionFactory.getCurrentSession().createQuery(q1);
		List<Users> list= (List<Users>)w.list();
		if(list==null || list.isEmpty())
		{
			return null;
		}
		
		return list.get(0);
	}
	
}
