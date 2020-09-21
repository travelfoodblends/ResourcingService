package com.resourcing.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amazonaws.xray.spring.aop.XRayEnabled;
import com.resourcing.service.model.Account;

@Repository
@XRayEnabled
public interface AccountRepository extends JpaRepository<Account, Integer> {

}
