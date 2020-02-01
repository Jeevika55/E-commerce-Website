package com.niit.SpectaclesBackend.DaoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.SpectaclesBackend.Dao.CartItemsDao;
import com.niit.SpectaclesBackend.Model.CartItems;
import com.niit.SpectaclesBackend.Model.Category;

@Repository("cartitemsDao")
@Transactional
public class CartItemsDaoImpl implements CartItemsDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public CartItemsDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}

	@Override
	public boolean saveorupdate(CartItems cartItems) {
		sessionFactory.getCurrentSession().saveOrUpdate(cartItems);
		return true;
	}

	@Override
	public boolean delete(CartItems cartItems) {
		sessionFactory.getCurrentSession().delete(cartItems);
		return true;
	}

	@Override
	public CartItems getCartItems(String cartItemsId) {
		String q1 = "from CartItems where CartItemsId='"+cartItemsId+"'";
		Query w=sessionFactory.getCurrentSession().createQuery(q1);
		List<CartItems> list= (List<CartItems>)w.list();
		if(list==null || list.isEmpty())
		{
			return null;
		}
		
		return list.get(0);
	}

	@Override
	public List<CartItems> cartitemslist(String cartId) {
		String q1 = "from CartItems where cartId='"+cartId+"'";
		Query w=sessionFactory.getCurrentSession().createQuery(q1);
		List<CartItems> list= (List<CartItems>)w.list();
		if(list==null || list.isEmpty())
		{
			return null;
		}
		
		return list;
	}
	
	@Override
	public List<CartItems> getCartItemsByProductId(String productsId)
	{
		String q="from CartItems where productsId='"+productsId+"'";
		Query w=sessionFactory.getCurrentSession().createQuery(q);
		List<CartItems> list= (List<CartItems>)w.list();
		if(list==null || list.isEmpty())
		{
			return null;
		}
		
		return list;
	}

}
