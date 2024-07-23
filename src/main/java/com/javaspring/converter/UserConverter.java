package com.javaspring.converter;

import org.springframework.stereotype.Component;

import com.javaspring.dto.UserDTO;
import com.javaspring.entity.UserEntity;

@Component
public class UserConverter {
	public UserDTO toDto(UserEntity entity) {
		UserDTO result = new UserDTO();
		result.setId(entity.getId());
		result.setUserName(entity.getFullName());
		result.setPassword(entity.getPassword());
		result.setFullName(entity.getFullName());
		return result;
	}
	public UserEntity toEntity(UserDTO dto) {
		UserEntity result = new UserEntity();
		result.setUserName(dto.getFullName());
		result.setPassword(dto.getPassword());
		result.setFullName(dto.getFullName());
		return result;
	}
	public UserEntity toEntity(UserEntity result, UserDTO dto) {
		result.setUserName(dto.getFullName());
		result.setPassword(dto.getPassword());
		result.setFullName(dto.getFullName());
		return result;
	}
}
