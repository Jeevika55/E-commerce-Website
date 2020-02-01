package com.niit.SpectaclesBackend.Dao;

import java.util.List;

import com.niit.SpectaclesBackend.Model.Users;

public interface UsersDao {
	
	public boolean saveorupdate(Users users);
	public boolean delete(Users users);
	public Users getUsers(String usersId);
	public List<Users> userslist();
	public Users isValidate(String emailid,String password);
	public Users getUsersByEmail(String currentUserName);

}
