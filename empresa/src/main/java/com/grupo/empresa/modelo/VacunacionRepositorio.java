package com.grupo.empresa.modelo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

	 @Repository
	   public interface VacunacionRepositorio extends JpaRepository<VaunacionEntity, String>{

	   }