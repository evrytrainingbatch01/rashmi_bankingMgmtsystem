package com.evryindia.user.service;

import java.io.Serializable;
import java.util.List;

import com.evryindia.foundation.domain.UserType;
import com.evryindia.foundation.domain.User;

public interface UserService extends Serializable 
{
	public User validateUser(String email, String password);
	public User getUserByAuthToken(String authToken);

	public List<User> getUsers();
	public List<UserType> getUserTypes();	
	public void saveUser(User user);
	public User getUser(int UserId);
	public void deleteUser(int userId);	
	
	public boolean invalidateUserSession(String authToken);

}

