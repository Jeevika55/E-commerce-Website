package com.niit.SpectaclesBackend.DaoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.SpectaclesBackend.Dao.OrderItemsDao;
import com.niit.SpectaclesBackend.Model.Category;
import com.niit.SpectaclesBackend.Model.OrderItems;

@Repository("orderitemsDao")
@Transactional
public class OrderItemsDaoImpl implements OrderItemsDao{
	
	@Autowired
	SessionFactory sessionFactory;
	
	public OrderItemsDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}

	@Override
	public boolean saveorupdate(OrderItems orderItems) {
		sessionFactory.getCurrentSession().saveOrUpdate(orderItems);
		return true;
	}

	@Override
	public boolean delete(OrderItems orderItems) {
		sessionFactory.getCurrentSession().delete(orderItems);
		return true;
	}

	@Override
	public OrderItems getOrderItems(String orderItemsId) {
		String q1 = "from OrderItems where OrderItemsId='"+orderItemsId+"'";
		Query w=sessionFactory.getCurrentSession().createQuery(q1);
		List<OrderItems> list= (List<OrderItems>)w.list();
		if(list==null || list.isEmpty())
		{
			return null;
		}
		
		return list.get(0);
	}

	@Override
	public List<OrderItems> orderitemslist() {
		List<OrderItems> orderitemss = (List<OrderItems>) sessionFactory.getCurrentSession().createCriteria(OrderItems.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return orderitemss;
	}
	
	@Override
	public List<OrderItems> getOrderItemsByProductId(String productsId)
	{
		String q= "from OrderItems where productsId='"+productsId+"'";
		Query w=sessionFactory.getCurrentSession().createQuery(q);
		List<OrderItems> list= (List<OrderItems>)w.list();
		if(list==null || list.isEmpty())
		{
			return null;
		}
		
		return list;
	}

}
