package com.niit.SpectaclesBackend.Config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.SpectaclesBackend.Dao.AuthenticationDao;
import com.niit.SpectaclesBackend.Dao.BillingDao;
import com.niit.SpectaclesBackend.Dao.CardDao;
import com.niit.SpectaclesBackend.Dao.CartDao;
import com.niit.SpectaclesBackend.Dao.CartItemsDao;
import com.niit.SpectaclesBackend.Dao.CategoryDao;
import com.niit.SpectaclesBackend.Dao.OrderItemsDao;
import com.niit.SpectaclesBackend.Dao.OrdersDao;
import com.niit.SpectaclesBackend.Dao.PayDao;
import com.niit.SpectaclesBackend.Dao.ProductsDao;
import com.niit.SpectaclesBackend.Dao.ShippingDao;
import com.niit.SpectaclesBackend.Dao.SupplierDao;
import com.niit.SpectaclesBackend.Dao.UsersDao;
import com.niit.SpectaclesBackend.DaoImpl.AuthenticationDaoImpl;
import com.niit.SpectaclesBackend.DaoImpl.BillingDaoImpl;
import com.niit.SpectaclesBackend.DaoImpl.CardDaoImpl;
import com.niit.SpectaclesBackend.DaoImpl.CartDaoImpl;
import com.niit.SpectaclesBackend.DaoImpl.CartItemsDaoImpl;
import com.niit.SpectaclesBackend.DaoImpl.CategoryDaoImpl;
import com.niit.SpectaclesBackend.DaoImpl.OrderItemsDaoImpl;
import com.niit.SpectaclesBackend.DaoImpl.OrdersDaoImpl;
import com.niit.SpectaclesBackend.DaoImpl.PayDaoImpl;
import com.niit.SpectaclesBackend.DaoImpl.ProductsDaoImpl;
import com.niit.SpectaclesBackend.DaoImpl.ShippingDaoImpl;
import com.niit.SpectaclesBackend.DaoImpl.SupplierDaoImpl;
import com.niit.SpectaclesBackend.DaoImpl.UsersDaoImpl;
import com.niit.SpectaclesBackend.Model.Authentication;
import com.niit.SpectaclesBackend.Model.Billing;
import com.niit.SpectaclesBackend.Model.Card;
import com.niit.SpectaclesBackend.Model.Cart;
import com.niit.SpectaclesBackend.Model.CartItems;
import com.niit.SpectaclesBackend.Model.Category;
import com.niit.SpectaclesBackend.Model.OrderItems;
import com.niit.SpectaclesBackend.Model.Orders;
import com.niit.SpectaclesBackend.Model.Pay;
import com.niit.SpectaclesBackend.Model.Products;
import com.niit.SpectaclesBackend.Model.Shipping;
import com.niit.SpectaclesBackend.Model.Supplier;
import com.niit.SpectaclesBackend.Model.Users;

@Configuration
@ComponentScan("com.niit.*")
@EnableTransactionManagement
public class ApplicationContext 
{

	@Bean("dataSource")
	public DataSource getDataSource() 
	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/test/project");
		dataSource.setUsername("sa");
		dataSource.setPassword("sa");

		// Properties connectionProperties=new Properties();
		// connectionProperties.setProperty("hibernate.show_sql", "true");
		// connectionProperties.setProperty("hibernate.dialect",
		// "org.hibernate.dialect");
		return dataSource;
	}

	private Properties getHibernateProperties()
	{
		Properties properties = new Properties();
		properties.put("hibernate.connection.pool_size", "10");
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		return properties;
	}

	@Autowired
	@Bean("sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) 
	{
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClass(Authentication.class);
		sessionBuilder.addAnnotatedClass(Billing.class);
		sessionBuilder.addAnnotatedClass(CartItems.class);
		sessionBuilder.addAnnotatedClass(Cart.class);
		sessionBuilder.addAnnotatedClass(OrderItems.class);
		sessionBuilder.addAnnotatedClass(Category.class);
		sessionBuilder.addAnnotatedClass(Shipping.class);
		sessionBuilder.addAnnotatedClass(Orders.class);
		sessionBuilder.addAnnotatedClass(Pay.class);
		sessionBuilder.addAnnotatedClass(Products.class);
		sessionBuilder.addAnnotatedClass(Users.class);
		sessionBuilder.addAnnotatedClass(Supplier.class);
		sessionBuilder.addAnnotatedClass(Card.class);
	
		return sessionBuilder.buildSessionFactory();
	}

	
	@Autowired
	@Bean(name="transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		System.out.println("printing session factory here : "+sessionFactory);
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		System.out.println("printing transactionManager factory here : "+transactionManager);
		return transactionManager;
	}



   	@Autowired
   	@Bean("categoryDao")
   	public CategoryDao getCategoryDao(SessionFactory sessionFactory) 
   	{
   		return new CategoryDaoImpl(sessionFactory);
   	}
   	
   	@Autowired
   	@Bean("authenticationDao")
	public AuthenticationDao getAuthenticationDao(SessionFactory sessionFactory) 
   	{
   		return new AuthenticationDaoImpl(sessionFactory);
   	}
   	
   	@Autowired
   	@Bean("billingDao")
	public BillingDao getBillingDao(SessionFactory sessionFactory) 
   	{
   		return new BillingDaoImpl(sessionFactory);
   	}
   	
   	@Autowired
   	@Bean("cartDao")
	public CartDao getCartDao(SessionFactory sessionFactory) 
   	{
   		return new CartDaoImpl(sessionFactory);
   	}
   	
   	@Autowired
   	@Bean("cartItemsDao")
	public CartItemsDao getCartItemsDao(SessionFactory sessionFactory) 
   	{
   		return new CartItemsDaoImpl(sessionFactory);
   	}
   	
   	@Autowired
   	@Bean("ordersDao")
	public OrdersDao getOrdersDao(SessionFactory sessionFactory) 
   	{
   		return new OrdersDaoImpl(sessionFactory);
   	}
   	
   	@Autowired
   	@Bean("orderItemsDao")
	public OrderItemsDao getOrderItemsDao(SessionFactory sessionFactory) 
   	{
   		return new OrderItemsDaoImpl(sessionFactory);
   	}
   	
   	@Autowired
   	@Bean("payDao")
	public PayDao getPayDao(SessionFactory sessionFactory) 
   	{
   		return new PayDaoImpl(sessionFactory);
   	}
   	
   	@Autowired
   	@Bean("productsDao")
	public ProductsDao getProductsDao(SessionFactory sessionFactory) 
   	{
   		return new ProductsDaoImpl(sessionFactory);
   	}
   	
   	@Autowired
   	@Bean("shippingDao")
	public ShippingDao getShippingDao(SessionFactory sessionFactory) 
   	{
   		return new ShippingDaoImpl(sessionFactory);
   	}
   	
   	@Autowired
   	@Bean("supplierDao")
	public SupplierDao getSupplierDao(SessionFactory sessionFactory) 
   	{
   		return new SupplierDaoImpl(sessionFactory);
   	}
   	
   	@Autowired
   	@Bean("usersDao")
	public UsersDao getUsersDao(SessionFactory sessionFactory) 
   	{
   		return new UsersDaoImpl(sessionFactory);
   	}
   	@Autowired
   	@Bean("cardDao")
	public CardDao getCardDao(SessionFactory sessionFactory) 
   	{
   		return new CardDaoImpl(sessionFactory);
   	}
}