package com.evryindia.user.service;

import java.io.Serializable;
import java.util.List;
import com.evryindia.foundation.domain.User;
import com.evryindia.foundation.domain.UserType;
import com.evryindia.user.service.UserService;

public class UserServiceImpl implements UserService, Serializable
{
	private static final long serialVersionUID = -7595700517731420680L;
	
	/*
	 * public SqlSession getDBSession() { return
	 * MybatisUtil.getSessionFactory().openSession(); }
	 */
	
//	public void closeDBSession(SqlSession session)
//	{
//		if (session != null) 
//		{
//			session.close();
//		}
//	}
//	
	public User validateUser(String email, String password)
	{
System.out.println("email and password is:" +email+password );
		User user = null;
//		email = StringUtil.checkNull(email);
//		password = StringUtil.checkNull(password);
//		
//		if(email.length() > 0 && password.length() > 0)
//		{
//			SqlSession dbSession = getDBSession();
//			if(dbSession != null)
//			{
//				Map<String, Object> parameterMap = new HashMap<String, Object>();
//				parameterMap.put("Email", email);
//				parameterMap.put("Password", CryptographyUtil.generateDigest(password));
//
//				UserDao userMapper = dbSession.getMapper(UserDao.class);
//				user = userMapper.validateUser(parameterMap);
//				if(user != null )
//				{
//					Date todayDate = DateUtil.getCurrentDate();
//					Date expiresDate = user.getTokenExpiresOn();
//					todayDate = new Date(todayDate.getTime() + (1000 * 60 * 60 * 24 * 5));
//					
//					if(expiresDate != null)
//					{
//						int i = DateUtil.compareDates(todayDate, expiresDate);
//						if(i < 0)
//						{
//							String authToken = HMAC.generateToken(user.getEmail()+"#$%777()^&^%^%");
//							if(authToken != null && authToken.length() > 0)
//							{
//								user.setAuthToken(authToken);
//								user.setTokenExpiresOn(DateUtil.addDays(DateUtil.getCurrentDate(), 5));
//								userMapper.updateUserAuthToken(user);
//								dbSession.commit();
//							}
//						}
//					}
//					else{
//					
//						String authToken = HMAC.generateToken(user.getEmail()+"#$%777()^&^%^%");
//						if(authToken != null && authToken.length() > 0)
//						{
//							user.setAuthToken(authToken);
//							user.setTokenExpiresOn(DateUtil.addDays(DateUtil.getCurrentDate(), 5));
//							userMapper.updateUserAuthToken(user);
//							dbSession.commit();
//						}
//					}
//					
//				}
//			}
//			closeDBSession(dbSession);
//		}
		
		return user;
	}
	
	public User getUserByAuthToken(String authToken)
	{
		User user = null;
//		authToken = StringUtil.checkNull(authToken);
//		
//		if(authToken.length() > 0)
//		{
//			SqlSession dbSession = getDBSession();
//			if(dbSession != null)
//			{
//				UserDao userMapper = dbSession.getMapper(UserDao.class);
//				user = userMapper.getUserByAuthToken(authToken);
//			}
//			closeDBSession(dbSession);
//		}
		
		return user;
	}
	
	@Override
	public List<User> getUsers()
	{
		List<User> users = null;
		/*
		 * SqlSession session = getDBSession(); if (session != null) { UserDao
		 * userMapper = session.getMapper(UserDao.class); users = userMapper.getUsers();
		 * } clo
		 seDBSession(session);*/
		return users;	
	}
	
	@Override
	public List<UserType> getUserTypes() 
	{
		List<UserType> userTypes = null;
		/*
		 * SqlSession session = getDBSession(); if (session != null) { UserDao
		 * userMapper = session.getMapper(UserDao.class); userTypes =
		 * userMapper.getUserTypes(); } closeDBSession(session);
		 */
		return userTypes;
	}	
	
	@Override
	public void saveUser(User user) 
	{	
		if (user != null) 
		{
//			SqlSession session = getDBSession();
//			if (session != null) 
//			{
//				UserDao userMapper = session.getMapper(UserDao.class);
//				String encryptpass= CryptographyUtil.generateDigest(user.getPassword());
//				user.setPassword(encryptpass);
//				if (user.getId() <= 0)
//				{
//					userMapper.insertUser(user);
//				}
//				else
//				{
//					userMapper.updateUser(user);
//				}
//				session.commit();
//			}
//			closeDBSession(session);
		}
	}	
	
	@Override
	public User getUser(int UserId) 
	{
		return null;
//		User User = null;
//		SqlSession session = getDBSession();
//		if (session != null)
//		{
//			UserDao userMapper = session.getMapper(UserDao.class);
//			User = userMapper.getUser(UserId);
//		}
//		closeDBSession(session);
		//return User;		
	}
	
	@Override
	public void deleteUser(int userId) 
	{
		if (userId > 0)
		{
			/*
			 * SqlSession session = getDBSession(); if (session != null) { UserDao
			 * userMapper = session.getMapper(UserDao.class); userMapper.deleteUser(userId);
			 * session.commit(); } closeDBSession(session);
			 */
		}	
	}	

	@Override
	public boolean invalidateUserSession(String authToken)
	{
		boolean isSessionInvalidated = false;
//		authToken = StringUtil.checkNull(authToken);
//		
//		if(authToken.length() > 0)
//		{
//			SqlSession dbSession = getDBSession();
//			if(dbSession != null)
//			{
//				UserDao userMapper = dbSession.getMapper(UserDao.class);
//				User user = userMapper.getUserByAuthToken(authToken);
//				if(user != null)
//				{
//					user.setAuthToken(null);
//					user.setTokenExpiresOn(null);
//					userMapper.updateUserAuthToken(user);
//					dbSession.commit();
//					if(user != null && user.getAuthToken() == null && user.getTokenExpiresOn() == null)
//					{
//						isSessionInvalidated = true;
//					}
//				}
//			}
//			closeDBSession(dbSession);
//		}
//		
		return isSessionInvalidated;
	}
}
