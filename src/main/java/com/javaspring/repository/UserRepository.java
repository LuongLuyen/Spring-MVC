package com.javaspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaspring.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
	
}