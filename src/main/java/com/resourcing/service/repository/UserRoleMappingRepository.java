package com.resourcing.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.resourcing.service.model.UserRoleMapping;

public interface UserRoleMappingRepository extends JpaRepository<UserRoleMapping, Integer>{

	List<UserRoleMapping> findByUserId(Integer id);
}
