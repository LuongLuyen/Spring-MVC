package com.javaspring.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javaspring.converter.UserConverter;
import com.javaspring.dto.UserDTO;
import com.javaspring.entity.UserEntity;
import com.javaspring.repository.UserRepository;
import com.javaspring.service.IUserService;

@Service
public class UserService implements IUserService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserConverter userConverter;

	@Override
	public List<UserDTO> findAll() {
		List<UserDTO> models = new ArrayList<>();
		List<UserEntity> entities = userRepository.findAll();
		for (UserEntity item: entities) {
			UserDTO userDTO = userConverter.toDto(item);
			models.add(userDTO);
		}
		return models;
	}
	@Override
	@Transactional
	public UserDTO save(UserDTO dto) {
		UserEntity newEntity = new UserEntity();
		if (dto.getId() != null) {
			UserEntity oldUser = userRepository.findOne(dto.getId());
			newEntity = userConverter.toEntity(oldUser, dto);
		} else {
			newEntity = userConverter.toEntity(dto);		}
		return userConverter.toDto(userRepository.save(newEntity));
	}
	@Override
	@Transactional
	public void delete(long[] ids) {
		for (long id: ids) {
			userRepository.delete(id);
		}
	}
	@Override
	public UserDTO login(String userName ,String password) {
		UserEntity  userEntity = new UserEntity();
		userEntity = userRepository.findByUserNameAndPassword(userName, password);
		return userConverter.toDto(userEntity);
	}
}
