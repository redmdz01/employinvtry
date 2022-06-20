package com.grupo.empresa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo.empresa.modelo.EmpleadoEntity;
import com.grupo.empresa.modelo.EmpleadoRepositorio;
import com.grupo.empresa.modelo.UserEntity;
import com.grupo.empresa.modelo.UserRepositorio;
import com.grupo.empresa.modelo.VacunaEntity;
import com.grupo.empresa.modelo.VacunaRepositorio;
import com.grupo.empresa.modelo.VacunacionRepositorio;
import com.grupo.empresa.modelo.VaunacionEntity;
import com.grupo.empresa.modelo.validador;

@RestController
@RequestMapping("/api/empleado")
public class EmpleadoController {
	validador valida = new validador();

	@Autowired
	EmpleadoRepositorio emp_repo;

	@Autowired
	VacunaRepositorio vac_repo;
	
	@Autowired
	VacunacionRepositorio cert_repo;

	
	@Autowired
	UserRepositorio user_repo;

	@GetMapping("/lista-empleados")
	public List<EmpleadoEntity> getEmpleados() {
		List<EmpleadoEntity> listaemp = emp_repo.findAll();
		return listaemp;
	}

	@GetMapping("/get-empleado/{cedula}")
	public EmpleadoEntity getEmpleadobyId(@PathVariable(value = "cedula") String cedula) {
		EmpleadoEntity emp_enti = emp_repo.findById(cedula).get();
		return emp_enti;
	}
		
	

	@PostMapping("/crear-empleados")
	public EmpleadoEntity crearEmpleado(@RequestBody EmpleadoEntity empleado) {
		boolean empleado_existente = emp_repo.existsById(empleado.getCedula());
		EmpleadoEntity nuevo_emp = null;
		if (!empleado_existente) {
			if (valida.validaEmp(empleado)) {
				nuevo_emp = emp_repo.save(empleado);
				creaCredenciales(empleado.getCedula());

			} else {
				System.out.println("Error en validación datos empleado");
			}
		} else {
			System.out.println("Empleado ya Existe");
		}
		return nuevo_emp;
	}

	@PostMapping("/crear-credenciales/{cedula}")
	public UserEntity creaCredenciales(@PathVariable(value = "cedula") String cedula) {
		boolean existe = user_repo.existsById(cedula);
		UserEntity user_existente;
		if (!existe) {
			user_existente = new UserEntity();
			user_existente.setUsuari(cedula);
			user_existente.setClave(cedula);
			return user_existente;
		}
		return null;

	}

	@PutMapping("/modificar-empleados/{cedula}")
	public ResponseEntity<EmpleadoEntity> modificaEmpleado
	(@PathVariable(value = "cedula") String cedula,
			@RequestBody EmpleadoEntity empleado_modifica,@RequestBody VaunacionEntity certificado_modifica ) {
		EmpleadoEntity emp_modificado = new EmpleadoEntity();
		boolean existe =emp_repo.existsById(cedula);
		
		if(existe) {
		EmpleadoEntity empleado = emp_repo.findById(cedula).get();
		 
			empleado.setFecha_nac(empleado_modifica.getFecha_nac());
			empleado.setDireccion(empleado_modifica.getDireccion());
			empleado.setTelefono(empleado_modifica.getTelefono());
			empleado.setVacunado(empleado_modifica.getVacunado());
			if(empleado.getVacunado().equalsIgnoreCase("S")){
					boolean exis_cert=vac_repo.existsById(certificado_modifica.getTipo().trim());
					if(exis_cert) {
						VaunacionEntity vacun = new VaunacionEntity();
						vacun.setTipo(certificado_modifica.getTipo().trim());
						vacun.setFecha(certificado_modifica.getFecha());
						vacun.setDosis(certificado_modifica.getDosis());
						vacun.setCedula(cedula);				
						cert_repo.save(vacun);
						
						emp_modificado = emp_repo.save(empleado);
						System.out.println("Empleado actualizado junto a su certificado de vacunación");
					}else {
						
						System.out.println("No existe el certificado de vacunación. No se permite la modificacion al empleado.");
					}
			}else {
				emp_modificado = emp_repo.save(empleado);
				System.out.println("Empleado actualizado sin certificado de vacunación");
				
			}
			
		
		}else {
			System.out.println("Empleado no existe");
		}
		return ResponseEntity.ok(emp_modificado);
	}

	@DeleteMapping("/eliminar-empleados/{cedula}")
	public Map<String, Boolean> eliminaEmpleado(@PathVariable(value = "cedula") String cedula) {
		Map<String, Boolean> response = new HashMap<>();
				boolean existe=emp_repo.existsById(cedula);
				if(existe) {
					EmpleadoEntity employee = emp_repo.findById(cedula).get();
					emp_repo.delete(employee);
				   response.put("Empleado eliminado", Boolean.TRUE);
				}else {
					response.put("Empleado no existe", Boolean.FALSE);
					
				}
		
		return response;
	}
	
	@GetMapping("/lista-empleados-vacunacion/{vacunado}")
	public List<EmpleadoEntity> getEmpleadosPorEstadoVacunacion(@PathVariable(value = "vacunado") String vacunado) {
			//EmpleadoEntity emp_enti = emp_repo.findBy(vacunado).get();
			//return emp_enti;
		
		List<EmpleadoEntity> listaemp = emp_repo.findAll();
		return listaemp;
	}
}
