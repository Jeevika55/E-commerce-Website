package com.niit.SpectaclesBackend.Dao;

import java.util.List;

import com.niit.SpectaclesBackend.Model.Products;

public interface ProductsDao {
	
	public boolean saveorupdate(Products products);
	public boolean delete(Products products);
	public Products getProduct(String productsId);
	public List<Products> productslist();
	public List<Products> getProductsById(String catId);
	public List<Products> getProductsBySupplierId(String supplierId);

}
