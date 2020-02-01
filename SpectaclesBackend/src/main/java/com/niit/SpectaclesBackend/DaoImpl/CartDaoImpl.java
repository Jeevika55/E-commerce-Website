package com.niit.SpectaclesBackend.DaoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.SpectaclesBackend.Dao.CartDao;
import com.niit.SpectaclesBackend.Model.Cart;
import com.niit.SpectaclesBackend.Model.Category;

@Repository("cartDao")
@Transactional
public class CartDaoImpl implements CartDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public CartDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}

	@Override
	public boolean saveorupdate(Cart cart) {
		sessionFactory.getCurrentSession().saveOrUpdate(cart);
		return true;
	}

	@Override
	public boolean delete(Cart cart) {
		sessionFactory.getCurrentSession().delete(cart);
		return true;
	}

	@Override
	public Cart getCart(String cartId) {
		String q1 = "from Cart where CartId='"+cartId+"'";
		Query w=sessionFactory.getCurrentSession().createQuery(q1);
		List<Cart> list= (List<Cart>)w.list();
		if(list==null || list.isEmpty())
		{
			return null;
		}
		
		return list.get(0);
	}

	@Override
	public List<Cart> cartlist() {
		List<Cart> carts = (List<Cart>) sessionFactory.getCurrentSession().createCriteria(Cart.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return carts;
	}

}
