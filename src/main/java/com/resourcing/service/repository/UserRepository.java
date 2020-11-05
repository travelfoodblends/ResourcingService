package com.resourcing.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.resourcing.service.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
