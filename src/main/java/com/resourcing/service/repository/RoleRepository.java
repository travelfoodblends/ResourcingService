package com.resourcing.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amazonaws.xray.spring.aop.XRayEnabled;
import com.resourcing.service.model.Role;

/**
 * The Interface RoleRepository.
 */
@Repository
@XRayEnabled
public interface RoleRepository extends JpaRepository<Role, Integer>{

}
