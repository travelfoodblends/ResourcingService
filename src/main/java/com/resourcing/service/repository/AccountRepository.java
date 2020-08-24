package com.resourcing.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.resourcing.service.model.Account;

public interface AccountRepository extends JpaRepository<Account, String> {

}
