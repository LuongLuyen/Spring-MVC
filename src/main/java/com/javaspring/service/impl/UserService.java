package com.javaspring.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.javaspring.dao.IUserDAO;
import com.javaspring.model.UserModel;
import com.javaspring.service.IUserService;

@Service
public class UserService implements IUserService {
	
//	@Autowired
//	private IUserDAO userDao;
//	
	@Override
	public List<UserModel> findAll() {
//		return userDao.findAll();
		List<UserModel> a = new ArrayList<UserModel>();
		UserModel u = new UserModel();
		u.setUserName("1");
		u.setPassword("1");
		u.setId(1L);
		u.setFullName("luyen");
		a.add(u);
		return a;
	}
}
