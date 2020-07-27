package com.resourcing.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.resourcing.service.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{

}
