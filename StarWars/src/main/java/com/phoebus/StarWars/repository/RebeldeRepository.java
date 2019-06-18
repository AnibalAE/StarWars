package com.phoebus.StarWars.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phoebus.StarWars.model.Rebelde;

public interface RebeldeRepository extends JpaRepository<Rebelde, Long>{
	
	Rebelde findById(long id);

	Rebelde count(boolean traidor);

	
}
