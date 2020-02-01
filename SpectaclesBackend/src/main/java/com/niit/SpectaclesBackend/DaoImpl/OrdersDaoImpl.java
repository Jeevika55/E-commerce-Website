package com.niit.SpectaclesBackend.DaoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.SpectaclesBackend.Dao.OrdersDao;
import com.niit.SpectaclesBackend.Model.Category;
import com.niit.SpectaclesBackend.Model.Orders;

@Repository("ordersDao")
@Transactional
public class OrdersDaoImpl implements OrdersDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public OrdersDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}

	@Override
	public boolean saveorupdate(Orders orders) {
		sessionFactory.getCurrentSession().saveOrUpdate(orders);
		return true;
	}

	@Override
	public boolean delete(Orders orders) {
		sessionFactory.getCurrentSession().delete(orders);
		return true;
	}

	@Override
	public Orders getOrders(String orderId) {
		String q1 = "from Orders where OrderId='"+orderId+"'";
		Query w=sessionFactory.getCurrentSession().createQuery(q1);
		List<Orders> list= (List<Orders>)w.list();
		if(list==null || list.isEmpty())
		{
			return null;
		}
		
		return list.get(0);
	}

	@Override
	public List<Orders> orderslist() {
		List<Orders> orderss = (List<Orders>) sessionFactory.getCurrentSession().createCriteria(Orders.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return orderss;
	}

}
