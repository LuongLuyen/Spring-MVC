package com.javaspring.service;

import java.util.List;

import com.javaspring.dto.UserDTO;

public interface IUserService {
	List<UserDTO> findAll();
	UserDTO save(UserDTO dto);
	void delete(long[] ids);
	UserDTO login(String userName, String password);
}
