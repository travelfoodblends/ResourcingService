package com.resourcing.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.resourcing.service.model.UserAccountMapping;

public interface UserAccountMappingRepository extends JpaRepository<UserAccountMapping, Integer>{

	List<UserAccountMapping> findByUserId(Integer id);
}
