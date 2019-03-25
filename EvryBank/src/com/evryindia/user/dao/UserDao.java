package com.evryindia.user.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.evryindia.foundation.domain.UserType;
import com.evryindia.foundation.domain.User;

public interface UserDao extends Serializable
{
	public User validateUser(Map<String, Object> parameters); 
	public void updateUserAuthToken(User user);
	public User getUserByAuthToken(String authToken);
	
	public List<User> getUsers();
	public List<UserType> getUserTypes();	
	public int insertUser(User user);
	public User getUser(int UserId);
	public int updateUser(User user);
	public int deleteUser(int userId);
	
	public void invalidateUserSession(User user);

}