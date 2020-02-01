package com.niit.SpectaclesBackend.DaoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.SpectaclesBackend.Dao.ProductsDao;
import com.niit.SpectaclesBackend.Model.Authentication;
import com.niit.SpectaclesBackend.Model.Products;

@Repository("productsDao")
@Transactional


public class ProductsDaoImpl implements ProductsDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public ProductsDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}

	@Override
	public boolean saveorupdate(Products products) {
		sessionFactory.getCurrentSession().saveOrUpdate(products);
		return true;
	}

	@Override
	public boolean delete(Products products) {
		sessionFactory.getCurrentSession().delete(products);
		return true;
	}

	@Override
	public Products getProduct(String productsId) {
		String q1 = "from Products where ProductsId='"+productsId+"'";
		Query w=sessionFactory.getCurrentSession().createQuery(q1);
		List<Products> list= (List<Products>)w.list();
		if(list==null || list.isEmpty())
		{
			return null;
		}
		
		return list.get(0);
	}

	@Override
	public List<Products> productslist() {
		List<Products> products = (List<Products>) sessionFactory.getCurrentSession().createCriteria(Products.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return products;
	}
	
	@Override
	public List<Products> getProductsById(String catId) {
		String c1="from Products where catId='"+catId+"'";
		Query w=sessionFactory.getCurrentSession().createQuery(c1);
		List<Products> list= (List<Products>)w.list();
		if(list==null || list.isEmpty())
		{
			return null;
		}
		
		return list;
	}
	
	@Override
	public List<Products> getProductsBySupplierId(String supplierId)
	{
		String c="from Products where suppilerId='"+supplierId+"'";
		Query w=sessionFactory.getCurrentSession().createQuery(c);
		List<Products> list= (List<Products>)w.list();
		if(list==null || list.isEmpty())
		{
			return null;
		}
		
		return list;
	}
	

}
