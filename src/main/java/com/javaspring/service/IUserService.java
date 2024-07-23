package com.javaspring.service;

import java.util.List;

import com.javaspring.model.UserModel;

public interface IUserService {
	List<UserModel> findAll();
}
