package com.niit.SpectaclesBackend.DaoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.SpectaclesBackend.Dao.PayDao;
import com.niit.SpectaclesBackend.Model.Category;
import com.niit.SpectaclesBackend.Model.Pay;

@Repository("payDao")
@Transactional
public class PayDaoImpl implements PayDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public PayDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}

	@Override
	public boolean saveorupdate(Pay pay) {
		sessionFactory.getCurrentSession().saveOrUpdate(pay);
		return true;
	}

	@Override
	public boolean delete(Pay pay) {
		sessionFactory.getCurrentSession().delete(pay);
		return true;
	}

	@Override
	public Pay getPay(String payId) {
		String q1 = "from Pay where PayId='"+payId+"'";
		Query w=sessionFactory.getCurrentSession().createQuery(q1);
		List<Pay> list= (List<Pay>)w.list();
		if(list==null || list.isEmpty())
		{
			return null;
		}
		
		return list.get(0);
	}

	@Override
	public List<Pay> paylist() {
		List<Pay> pays = (List<Pay>) sessionFactory.getCurrentSession().createCriteria(Pay.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return pays;
	}

}
