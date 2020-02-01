package com.niit.SpectaclesBackend.Dao;

import java.util.List;

import com.niit.SpectaclesBackend.Model.Supplier;



public interface SupplierDao {
	
	public boolean saveorupdate(Supplier supplier);
	public boolean delete(Supplier supplier);
	public Supplier getSupplier(String supplierId);
	public List<Supplier> supplierlist();

}
