package com.resourcing.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.resourcing.service.model.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {

	
}
