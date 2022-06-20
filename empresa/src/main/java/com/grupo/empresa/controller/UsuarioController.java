package com.grupo.empresa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo.empresa.modelo.UserEntity;
import com.grupo.empresa.modelo.UserRepositorio;


	@RestController
	@RequestMapping("/api/empleado")
	public class UsuarioController {	
		
		@Autowired
		UserRepositorio usua_repo;

		@GetMapping("/lista-usuarios")
		public List<UserEntity> getUsuarios() {
			List<UserEntity> lista = usua_repo.findAll();
			return lista;
		}

		/*
		@PostMapping("/crear-usuarios")
		public UserEntity crearVacuna(@RequestBody UserEntity) {
			UserEntity vacuna_existente = vac_repo.findById(vacuna.getTipo()).get();
			UserEntity nueva_vac = null;
			if(vacuna_existente==null) {
				 nueva_vac = vac_repo.save(vacuna);
			 }else {
				System.out.println("tipo de vacuna ya Existe");
			}
			return nuevo_user;
		} */
	
	
}
