package com.niit.SpectaclesBackend.Dao;

import java.util.List;

import com.niit.SpectaclesBackend.Model.Pay;

public interface PayDao {
	public boolean saveorupdate(Pay pay);
	public boolean delete(Pay pay);
	public Pay getPay(String payId);
	public List<Pay> paylist();

}
