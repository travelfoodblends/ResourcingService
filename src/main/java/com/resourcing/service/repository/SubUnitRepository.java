package com.resourcing.service.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amazonaws.xray.spring.aop.XRayEnabled;
import com.resourcing.service.model.SubUnit;

@Repository
@XRayEnabled
public interface SubUnitRepository extends JpaRepository<SubUnit, Integer>{

	List<SubUnit> findByAccountId(Integer id);
	Optional<SubUnit> findByIdAndAccountId(Integer subunitId, Integer accountId);
}
