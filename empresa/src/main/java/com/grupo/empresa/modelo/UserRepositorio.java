package com.grupo.empresa.modelo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


	 @Repository
	   public interface UserRepositorio extends JpaRepository<UserEntity, String>{

	   }

