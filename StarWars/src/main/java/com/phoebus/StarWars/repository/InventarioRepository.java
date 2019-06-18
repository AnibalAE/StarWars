package com.phoebus.StarWars.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phoebus.StarWars.model.Inventario;

public interface InventarioRepository extends JpaRepository<Inventario, Long>{

	Inventario findById(long id);
	
}
