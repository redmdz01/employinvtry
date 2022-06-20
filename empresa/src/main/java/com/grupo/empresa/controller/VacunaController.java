package com.grupo.empresa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo.empresa.modelo.VacunaEntity;
import com.grupo.empresa.modelo.VacunaRepositorio;


	@RestController
	@RequestMapping("/api/empleado")
	public class VacunaController {	
		
		@Autowired
		VacunaRepositorio vac_repo;

		@GetMapping("/lista-vacunas")
		public List<VacunaEntity> getVacunas() {
			List<VacunaEntity> lista = vac_repo.findAll();
			return lista;
		}

		@GetMapping("/get-vacuna/{tipo}")
		public VacunaEntity getVacunabyId(@PathVariable(value = "tipo") String tipo)
		{
			VacunaEntity vac_enti = vac_repo.findById(tipo).get();
			return vac_enti;
		}

		@PostMapping("/crear-vacunas")
		public VacunaEntity crearVacuna(@RequestBody VacunaEntity vacuna) {
			
			boolean vacuna_existente = vac_repo.existsById(vacuna.getTipo());
			VacunaEntity nueva_vac = null;
			if(!vacuna_existente) {
				 nueva_vac = vac_repo.save(vacuna);
			 }else {
				System.out.println("tipo de vacuna ya Existe");
			}
			return nueva_vac;
		}
}
